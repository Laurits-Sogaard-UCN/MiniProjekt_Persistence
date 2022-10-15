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
	
	private static final String FIND_PRIVATE_CUSTOMER_ON_PHONE = ("SELECT p.*, c.*, d.Discount, a.*, ac.City\r\n"
			+ "FROM Person p, Customer c, PrivateCustomer pc, Discount d, Address a, AddressCity ac\r\n"
			+ "WHERE p.Phone = ?\r\n"
			+ "and p.Phone = c.Phone\r\n"
			+ "and c.Phone = pc.Phone\r\n"
			+ "and d.ID = pc.DiscountID\r\n"
			+ "and p.AddressID = a.ID\r\n"
			+ "and a.Zipcode = ac.Zipcode");
	private PreparedStatement findPrivateCustomerOnPhone;
	
	private static final String FIND_BUSINESS_CUSTOMER_ON_PHONE = ("SELECT p.*, bc.*, c.*, d.Discount, a.*, ac.City\r\n"
			+ "FROM Person p, Customer c, BusinessCustomer bc, Discount d, Address a, AddressCity ac\r\n"
			+ "WHERE p.Phone = ?\r\n"
			+ "and p.Phone = c.Phone\r\n"
			+ "and c.Phone = bc.Phone\r\n"
			+ "and d.ID = bc.DiscountID\r\n"
			+ "and p.AddressID = a.ID\r\n"
			+ "and a.Zipcode = ac.Zipcode");
	private PreparedStatement findBusinessCustomerOnPhone;
	
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
			findPrivateCustomerOnPhone = con.prepareStatement(FIND_PRIVATE_CUSTOMER_ON_PHONE);
			findBusinessCustomerOnPhone = con.prepareStatement(FIND_BUSINESS_CUSTOMER_ON_PHONE);
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
			findPrivateCustomerOnPhone.setString(1, phone);
			ResultSet rs = findPrivateCustomerOnPhone.executeQuery();
			findBusinessCustomerOnPhone.setString(1, phone);
			ResultSet rs1 = findBusinessCustomerOnPhone.executeQuery();
			if(rs.next() && rs.getString("CustomerType").equals("PrivateCustomer")) {
				customer = buildPrivateCustomerObject(rs);
			}
			else if(rs1.next() && rs1.getString("CustomerType").equals("BusinessCustomer")) {
				customer = buildBusinessCustomerObject(rs1);
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return customer;
	}
	
	/**
	 * Builds a PrivateCustomer object from ResultSet.
	 * @param rs
	 * @return PrivateCustomer
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
			privateCustomer.setFreeShipping(rs.getFloat("Discount"));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return privateCustomer;
	}
	
	/**
	 * Builds a BusinessCustomer object from ResultSet.
	 * @param rs
	 * @return BusinessCustomer
	 * @throws DataAccessException
	 */
	private BusinessCustomer buildBusinessCustomerObject(ResultSet rs) throws DataAccessException {
		BusinessCustomer businessCustomer = new BusinessCustomer();
		try {
			businessCustomer.setFname(rs.getString("Fname"));
			businessCustomer.setLname(rs.getString("Lname"));
			businessCustomer.setAddress(rs.getString("Street") + " " + rs.getInt("StreetNumber"));
			businessCustomer.setZipcode(rs.getInt("Zipcode"));
			businessCustomer.setCity(rs.getString("City"));
			businessCustomer.setEmail(rs.getString("Email"));
			businessCustomer.setPhone(rs.getString("Phone"));
			businessCustomer.setCustomerType(businessCustomer);
			businessCustomer.setDiscount(rs.getFloat("Discount"));
			businessCustomer.setBusinessName(rs.getString("BusinessName"));
			businessCustomer.setCVR(rs.getInt("CVR"));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return businessCustomer;
	}
	

}
