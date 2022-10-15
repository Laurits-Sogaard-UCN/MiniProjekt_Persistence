package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BuyProduct;
import model.Clothing;
import model.Supplier;
import utility.DataAccessException;

public class ProductDB implements ProductDBIF {
	
	private static final String FIND_BUY_PRODUCT_ON_BARCODE = ("SELECT *\r\n"
			+ "FROM BuyProduct bp, Product p, Clothing c\r\n"
			+ "WHERE p.Barcode = ?\r\n"
			+ "and bp.Barcode = p.Barcode \r\n"
			+ "and c.Barcode = bp.Barcode");
	private PreparedStatement findBuyProductOnBarcode;
	
	private static final String UPDATE_CURRENT_STOCK = ("UPDATE Product\r\n"
			+ "SET CurrentStock = ?\r\n"
			+ "WHERE Barcode = ?");
	private PreparedStatement updateCurrentStock;
	
	private static final String FIND_CURRENT_STOCK = ("SELECT p.CurrentStock\r\n"
			+ "FROM Product p\r\n"
			+ "WHERE p.Barcode = ?");
	private PreparedStatement findCurrentStock;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public ProductDB() throws DataAccessException {
		init();
	}
	
	/**
	 * Initialization of Connection and PreparedStatements.
	 * @throws DataAccessException
	 */
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
	
	/**
	 * Finds BuyProduct on barcode by executing ResultSet and building
	 * a BuyProduct object (internal method call). Updates currentStock.
	 * @param barcode
	 * @param quantity
	 * @return BuyProduct
	 * @throws DataAccessException
	 */
	@Override
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
			
			if(rowsAffected > 0 && rs.next()) {
				buyProduct = buildBuyProductObject(rs);
			}
		} catch(SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
		}
		return buyProduct;
	}
	
	/**
	 * Builds a subtype of BuyProduct depending on value of coloumn "BuyProductType".
	 * @param rs
	 * @return BuyProduct
	 * @throws DataAccessException
	 */
	private BuyProduct buildBuyProductObject(ResultSet rs) throws DataAccessException {
		BuyProduct buyProduct = null;
		try {
			if(rs.getString("BuyProductType").equals("Clothing")) {
				buyProduct = new Clothing();
				buyProduct = buildClothingObject(rs);
			}
			else if(rs.getString("BuyProductType").equals("Equipment")) {
				//TODO buildEquipmentObject(rs);
			}
			else if(rs.getString("BuyProductType").equals("GunReplica")) {
				//TODO buildGunReplicaObject(rs);
			}
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return buyProduct;
	}
	
	/**
	 * Builds a Clothing object from ResultSet.
	 * @param rs
	 * @return Clothing
	 * @throws DataAccessException
	 */
	private Clothing buildClothingObject(ResultSet rs) throws DataAccessException {
		Clothing buyProduct = new Clothing();
		try {
			buyProduct.setBarcode(rs.getInt("Barcode"));
			buyProduct.setName(rs.getString("Name"));
			buyProduct.setPurchasePrice(rs.getFloat("PurchasePrice"));
			buyProduct.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
			buyProduct.setMinStock(rs.getInt("MinStock"));
			buyProduct.setCurrentStock(rs.getInt("CurrentStock"));
			buyProduct.setSalesPrice(rs.getFloat("SalesPrice"));
			buyProduct.setColour(rs.getString("Colour"));
			buyProduct.setSize(rs.getInt("Size"));
			buyProduct.setAmount(rs.getInt("Amount"));
			buyProduct.setProductType(buyProduct);
			buyProduct.setBuyProductType(buyProduct);
			buyProduct.setSupplier(new Supplier(rs.getString("SupplierPhone")));
		} catch(SQLException e) {
			throw new DataAccessException("Could not build object", e);
		}
		return buyProduct;
	}
	
	
}
