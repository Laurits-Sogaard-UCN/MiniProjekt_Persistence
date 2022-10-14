package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import model.Customer;
import model.Employee;
import model.Orderline;
import model.SaleOrder;
import utility.DataAccessException;

public class SaleOrderDB implements SaleOrderDBIF {
	
	private static final String FIND_CUSTOMER_BY_PHONE = ("SELECT *\r\n"
			+ "FROM Person p, Customer c\r\n"
			+ "WHERE p.Phone = ?\r\n"
			+ "and p.Phone = c.Phone");
	private PreparedStatement findCustomerByPhone;
	
	private static final String INSERT_SALE_ORDER = ("INSERT INTO SaleOrder (Date, Total, DeliveryStatus, DeliveryDate, CustomerPhone, EmployeePhone) \r\n"
			+ "VALUES (?, ?, ?, ?, ?, ?)");
	private PreparedStatement insertSaleOrder;
	
	private static final String GET_MOST_RECENT_IDENTITY = ("SELECT SCOPE_IDENTITY() AS [ID];");
	private PreparedStatement getMostRecentIdentity;
	
	private static final String INSERT_ORDERLINE = ("INSERT INTO Orderline (Quantity, SaleOrderID, BuyProductBarcode)\r\n"
			+ "VALUES (?, ?, ?)");
	private PreparedStatement insertOrderline;
	
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
			insertSaleOrder = con.prepareStatement(INSERT_SALE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
			getMostRecentIdentity = con.prepareStatement(GET_MOST_RECENT_IDENTITY);
			insertOrderline = con.prepareStatement(INSERT_ORDERLINE);
		} catch(SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	/**
	 * Creates a SaleOrder by executing query and building a
	 * SaleOrder Object (done by internal method call).
	 */
	@Override
	public SaleOrder createSaleOrder() {
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setDate(LocalDate.now());
		saleOrder.setDeliveryStatus("In progress");
		saleOrder.setDeliveryDate(null);
		saleOrder.setTotal(0);
		saleOrder.setCustomer(null);
		saleOrder.setEmployee(null);
		return saleOrder;
	}
	
	@Override
	public boolean completeSaleOrder(SaleOrder saleOrder) throws DataAccessException {
		boolean completed = false;
		int rowsAffected1 = 0;
		int rowsAffected2 = 0;
		
		LocalDate localDate = saleOrder.getDate();
		java.sql.Date date = java.sql.Date.valueOf(localDate);
		double total = saleOrder.getTotal();
		String deliveryStatus = saleOrder.getDeliveryStatus();
		LocalDate localDeliveryDate = saleOrder.getDeliveryDate();
		Date deliveryDate = null;
		if(localDeliveryDate != null) {
			deliveryDate = Date.from(localDeliveryDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
		String customerPhone = saleOrder.getCustomer().getPhone();
		String employeePhone = saleOrder.getEmployee().getPhone();
		
		try {
			insertSaleOrder.setDate(1, date);
			insertSaleOrder.setDouble(2, total);
			insertSaleOrder.setString(3, deliveryStatus);
			insertSaleOrder.setDate(4, (java.sql.Date) deliveryDate);
			insertSaleOrder.setString(5, customerPhone);
			insertSaleOrder.setString(6, employeePhone);
			
			DBConnection.getInstance().startTransaction();
			rowsAffected1 = insertSaleOrder.executeUpdate();
			ResultSet rs = insertSaleOrder.getGeneratedKeys();
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			for(Orderline element : saleOrder.getOrderlines()) {
				int quantity = element.getQuantity();
				int buyProductBarcode = element.getBuyProduct().getBarcode();
				insertOrderline.setInt(1, quantity);
				insertOrderline.setInt(2, id);
				insertOrderline.setInt(3, buyProductBarcode);
				rowsAffected2 = insertOrderline.executeUpdate();
			}
			DBConnection.getInstance().commitTransaction();
			
		} catch(SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
		}
		
		if(rowsAffected1 > 0 && rowsAffected2 > 0) {
			completed = true;
		}
		return completed;
	}
	
//	/**
//	 * Builds SaleOrder object from ResultSet.
//	 * @param rs
//	 * @return SaleOrder
//	 * @throws DataAccessException
//	 */
//	private SaleOrder buildObject(ResultSet rs) throws DataAccessException {
//		SaleOrder saleOrder = new SaleOrder();
//		try {
//			saleOrder.setDate(rs.getDate("Date").toLocalDate());
//			saleOrder.setDeliveryStatus(rs.getString("DeliveryStatus"));
//			saleOrder.setDeliveryDate(rs.getDate("DeliveryDate").toLocalDate());
//			saleOrder.setTotal(rs.getFloat("Total"));
//			saleOrder.setCustomer(new Customer(rs.getString("CustomerPhone")));
//			saleOrder.setEmployee(new Employee(rs.getString("EmployeePhone")));
//		} catch(SQLException e) {
//			throw new DataAccessException("Could not build object", e);
//		}
//		return saleOrder;
//	}

}
