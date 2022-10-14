package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BuyProduct;
import utility.DataAccessException;

public class ProductDB implements ProductDBIF {
	
	private static final String FIND_BUY_PRODUCT_ON_BARCODE = ("");
	private PreparedStatement findBuyProductOnBarcode;
	
	private static final String UPDATE_CURRENT_STOCK = ("");
	private PreparedStatement updateCurrentStock;
	
	private static final String FIND_CURRENT_STOCK = ("");
	private PreparedStatement findCurrentStock;
	
	public ProductDB() throws DataAccessException {
		init();
	}
	
	private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findBuyProductOnBarcode = con.prepareStatement(FIND_BUY_PRODUCT_ON_BARCODE);
			updateCurrentStock = con.prepareStatement(UPDATE_CURRENT_STOCK);
			findCurrentStock = con.prepareStatement(FIND_CURRENT_STOCK);
		} catch(SQLException e) {
			throw new DataAccessException("Could not prepare statements", e);
		}
	}
	
	public BuyProduct findBuyProductOnBarcode(int barcode, int quantity) throws DataAccessException {
		BuyProduct buyProduct = new BuyProduct();
		int rowsAffected = 0;
		try {
			findBuyProductOnBarcode.setInt(1, barcode);
			findCurrentStock.setInt(1, barcode);
			
			DBConnection.getInstance().startTransaction();
			ResultSet rs = findBuyProductOnBarcode.executeQuery();
			ResultSet rs1 = findCurrentStock.executeQuery();
			if(rs1.next()) {
				int newStock = rs1.getInt("CurrentStock") - quantity;
				updateCurrentStock.setInt(1, newStock);
				updateCurrentStock.setInt(2, barcode);
			}
			rowsAffected = updateCurrentStock.executeUpdate();
			DBConnection.getInstance().commitTransaction();
			
			if(rowsAffected > 0) {
				buyProduct = buildBuyProductObject(rs);
			}
		} catch(SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
		}
		return buyProduct;
	}
	
	private BuyProduct buildBuyProductObject(ResultSet rs) throws DataAccessException {
		BuyProduct buyProduct = new BuyProduct();
		try {
			if(rs.getString("BuyProductType").equals("Clothing")) {
				buyProduct.setBarcode(rs.getInt("Barcode"));
				buyProduct.setName(rs.getString("Name"));
				buyProduct.setPurchasePrice(rs.getFloat("PurchasePrice"));
				buyProduct.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
				buyProduct.setMinStock(rs.getInt("MinStock"));
				buyProduct.setCurrentStock(rs.getInt("CurrentStock"));
				buyProduct.setSalesPrice(rs.getFloat("SalesPrice"));
				buyProduct.setBuyProductType(new Clothing());
			}
			else if(rs.getString("BuyProductType").equals("Equipment")) {
				buyProduct.setBuyProductType(new Equipment());
			}
			else if(rs.getString("BuyProductType").equals("GunReplica")) {
				buyProduct.setBuyProductType(new GunReplica());
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
	}
}
