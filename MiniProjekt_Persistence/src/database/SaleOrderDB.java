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
	
	private static final String INSERT_SALE_ORDER = ("INSERT INTO SaleOrder (Date, Total, DeliveryStatus, DeliveryDate, CustomerPhone, EmployeePhone) \r\n"
			+ "VALUES (?, ?, ?, ?, ?, ?)");
	private PreparedStatement insertSaleOrder;
	
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
			insertSaleOrder = con.prepareStatement(INSERT_SALE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
			insertOrderline = con.prepareStatement(INSERT_ORDERLINE);
		} catch(SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	/**
	 * Creates a SaleOrder object.
	 */
	@Override
	public SaleOrder createSaleOrder() {
		SaleOrder saleOrder = new SaleOrder(LocalDate.now(), "In progress", null, null, null);
		return saleOrder;
	}
	
	/**
	 * Inserts data from SaleOrder object, and its Orderline objects, into database.
	 * @param saleOrder
	 * @return boolean
	 * @throws DataAccessException
	 */
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
		java.sql.Date deliveryDate = null;
		if(localDeliveryDate != null) {
			deliveryDate = java.sql.Date.valueOf(localDeliveryDate);
		}
		String customerPhone = saleOrder.getCustomer().getPhone();
		String employeePhone = saleOrder.getEmployee().getPhone();
		
		try {
			insertSaleOrder.setDate(1, date);
			insertSaleOrder.setDouble(2, total);
			insertSaleOrder.setString(3, deliveryStatus);
			insertSaleOrder.setDate(4, deliveryDate);
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
	

}
