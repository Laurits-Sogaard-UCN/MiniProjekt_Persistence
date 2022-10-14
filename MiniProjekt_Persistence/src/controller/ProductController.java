package controller;

import database.ProductDB;
import database.ProductDBIF;
import model.BuyProduct;
import utility.DataAccessException;

public class ProductController {
	
	private ProductDBIF productDB;

	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException 
	 */
	public ProductController() throws DataAccessException {
		this.productDB = new ProductDB();
	}
	
	/**
	 * Finds a BuyProduct on barcode.
	 * @param barcode
	 * @param quantity
	 * @return BuyProduct
	 * @throws DataAccessException
	 */
	public BuyProduct findBuyProductOnBarcode(int barcode, int quantity) throws DataAccessException {
		BuyProduct buyProduct = productDB.findBuyProductOnBarcode(barcode, quantity);
		return buyProduct;
	}
	
}
