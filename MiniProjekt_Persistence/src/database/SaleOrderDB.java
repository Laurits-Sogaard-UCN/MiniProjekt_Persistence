package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;
import model.Employee;
import model.SaleOrder;
import utility.DataAccessException;

public class SaleOrderDB implements SaleOrderDBIF {
	
	private static final String FIND_CUSTOMER_BY_PHONE = ("");
	private PreparedStatement findCustomerByPhone;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public SaleOrderDB() throws DataAccessException {
		init();
	}
	
	/**
	 * Initialization of database connection and PreparedStatements.
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
	 * Creates a SaleOrder by executing query and building a
	 * SaleOrder Object (done by internal method call).
	 */
	@Override
	public SaleOrder createSaleOrder(String phone) throws DataAccessException {
		SaleOrder saleOrder = new SaleOrder();
		try {
			findCustomerByPhone.setString(1, phone);
			ResultSet rs = findCustomerByPhone.executeQuery();
			if(rs.next()) {
				saleOrder = buildObject(rs);
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return saleOrder;
	}
	
	/**
	 * Builds SaleOrder object from ResultSet.
	 * @param rs
	 * @return SaleOrder
	 * @throws DataAccessException
	 */
	public SaleOrder buildObject(ResultSet rs) throws DataAccessException {
		SaleOrder saleOrder = new SaleOrder();
		try {
			saleOrder.setDate(rs.getDate("Date").toLocalDate());
			saleOrder.setDeliveryStatus(rs.getString("DeliveryStatus"));
			saleOrder.setDeliveryDate(rs.getDate("DeliveryDate").toLocalDate());
			saleOrder.setTotal(rs.getFloat("Total"));
			saleOrder.setCustomer(new Customer(rs.getString("CustomerPhone")));
			saleOrder.setEmployee(new Employee(rs.getString("EmployeePhone")));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return saleOrder;
	}

}
