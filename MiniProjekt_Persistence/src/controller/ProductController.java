package controller;

import database.ProductDB;
import database.ProductDBIF;
import model.BuyProduct;

public class ProductController {
	
	private ProductDBIF productDB;

	/**
	 * @param productDB
	 */
	public ProductController() {
		this.productDB = new ProductDB();
	}
	
	public BuyProduct findBuyProductOnBarcode(int barcode, int quantity) {
		BuyProduct buyProduct = productDB.findBuyProductOnBarcode(barcode, quantity);
		return buyProduct;
	}
	
}
