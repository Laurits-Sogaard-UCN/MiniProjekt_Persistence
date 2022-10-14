package controller;

import database.ProductDB;
import database.ProductDBIF;
import model.BuyProduct;
import utility.DataAccessException;

public class ProductController {
	
	private ProductDBIF productDB;

	/**
	 * @param productDB
	 * @throws DataAccessException 
	 */
	public ProductController() throws DataAccessException {
		this.productDB = new ProductDB();
	}
	
	public BuyProduct findBuyProductOnBarcode(int barcode, int quantity) throws DataAccessException {
		BuyProduct buyProduct = productDB.findBuyProductOnBarcode(barcode, quantity);
		return buyProduct;
	}
	
}
