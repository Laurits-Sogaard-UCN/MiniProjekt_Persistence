package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BuyProduct;
import model.Clothing;
import model.Supplier;
import utility.DataAccessException;

public class SupplierDB implements SupplierDBIF {
	
	private static final String FIND_SUPPLIER_ON_PHONE = ("SELECT s.*, a.*, ac.City, ac.Country\r\n"
			+ "FROM Supplier s, Address a, AddressCity ac\r\n"
			+ "WHERE s.Phone = ?\r\n"
			+ "and s.AddressID = a.ID\r\n"
			+ "and a.Zipcode = ac.Zipcode");
	private PreparedStatement findSupplierOnPhone;
	
	public SupplierDB() throws DataAccessException {
		init();
	}
	
	private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findSupplierOnPhone = con.prepareStatement(FIND_SUPPLIER_ON_PHONE);
		} catch(SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public Supplier findSupplierOnPhone(String phone) throws DataAccessException {
		Supplier supplier = new Supplier();
		try {
			findSupplierOnPhone.setString(1, phone);
			ResultSet rs = findSupplierOnPhone.executeQuery();
			if(rs.next()) {
				supplier = buildObject(rs);
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not execute query", e);
		}
		return supplier;
	}
	
	private Supplier buildObject(ResultSet rs) throws DataAccessException {
		Supplier supplier = new Supplier();
		try {
			supplier.setAddress(rs.getString("Street") + rs.getString("StreetNumber"));
			supplier.setCity(rs.getString("City"));
			supplier.setZipcode(rs.getInt("Zipcode"));
			supplier.setCountry(rs.getString("Country"));
			supplier.setName(rs.getString("Name"));
			supplier.setEmail(rs.getString("Email"));
			supplier.setPhone(rs.getString("Phone"));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return supplier;
	}

}
