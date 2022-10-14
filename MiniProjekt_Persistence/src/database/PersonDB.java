package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BusinessCustomer;
import model.Customer;
import model.PrivateCustomer;
import utility.DataAccessException;

public class PersonDB implements PersonDBIF {
	
	private static final String FIND_CUSTOMER_BY_PHONE = ("SELECT p.*, c.*, d.Discount, a.*, ac.City\r\n"
			+ "FROM Person p, Customer c, PrivateCustomer pc, Discount d, Address a, AddressCity ac\r\n"
			+ "WHERE p.Phone = ?\r\n"
			+ "and p.Phone = c.Phone\r\n"
			+ "and c.Phone = pc.Phone\r\n"
			+ "and d.ID = pc.DiscountID\r\n"
			+ "and p.AddressID = a.ID\r\n"
			+ "and a.Zipcode = ac.Zipcode");
	private PreparedStatement findCustomerByPhone;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public PersonDB() throws DataAccessException {
		init();
	}
	
	/**
	 * Initialization of Connection and PreparedStatments.
	 * @throws DataAccessException
	 */
	private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findCustomerByPhone = con.prepareStatement(FIND_CUSTOMER_BY_PHONE);
		} catch(SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	/**
	 * Finds Customer by phone by executing query and building either a
	 * PrivateCustomer or BusinessCustomer object (done by internal method call).
	 */
	@Override
	public Customer findCustomerByPhone(String phone) throws DataAccessException {
		Customer customer = new Customer();
		try {
			findCustomerByPhone.setString(1, phone);
			ResultSet rs = findCustomerByPhone.executeQuery();
			if(rs.next() && rs.getString("CustomerType").equals("PrivateCustomer")) {
				customer = buildPrivateCustomerObject(rs);
			}
			else if(rs.next() && rs.getString("CustomerType").equals("BusinessCustomer")) {
				customer = buildBusinessCustomerObject(rs);
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return customer;
	}
	
	/**
	 * Builds a PrivateCustomer object from ResultSet.
	 * @param rs
	 * @return Customer
	 * @throws DataAccessException
	 */
	private PrivateCustomer buildPrivateCustomerObject(ResultSet rs) throws DataAccessException {
		PrivateCustomer privateCustomer = new PrivateCustomer();
		try {
			privateCustomer.setFname(rs.getString("Fname"));
			privateCustomer.setLname(rs.getString("Lname"));
			privateCustomer.setAddress(rs.getString("Street") + " " + rs.getInt("StreetNumber"));
			privateCustomer.setZipcode(rs.getInt("Zipcode"));
			privateCustomer.setCity(rs.getString("City"));
			privateCustomer.setEmail(rs.getString("Email"));
			privateCustomer.setPhone(rs.getString("Phone"));
			privateCustomer.setCustomerType(privateCustomer);
			privateCustomer.setFreeShipping(rs.getInt("Discount"));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return privateCustomer;
	}
	
	/**
	 * Builds a BusinessCustomer object from ResultSet.
	 * @param rs
	 * @return Customer
	 * @throws DataAccessException
	 */
	private BusinessCustomer buildBusinessCustomerObject(ResultSet rs) throws DataAccessException {
		BusinessCustomer businessCustomer = new BusinessCustomer();
		try {
			if(rs.getString("CustomerType").equals("Private")) {
				try {
					businessCustomer.setFname(rs.getString("Fname"));
					businessCustomer.setLname(rs.getString("Lname"));
					businessCustomer.setAddress(rs.getInt("Street") + " " + rs.getString("StreetNumber"));
					businessCustomer.setZipcode(rs.getInt("Zipcode"));
					businessCustomer.setCity(rs.getString("City"));
					businessCustomer.setEmail(rs.getString("Email"));
					businessCustomer.setPhone(rs.getString("Phone"));
					businessCustomer.setCustomerType(businessCustomer);
					businessCustomer.setDiscount(rs.getInt("Discount"));
					businessCustomer.setBusinessName(rs.getString("BusinessName"));
					businessCustomer.setCVR(rs.getInt("CVR"));
				} catch(SQLException e) {
					throw new DataAccessException("Could not build object", e);
				}
			}
		} catch(SQLException e) {
			throw new DataAccessException("", e);
		}
		return businessCustomer;
	}
	

}
