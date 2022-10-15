package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.ProductDB;
import model.BuyProduct;
import model.Clothing;
import model.Product;
import model.Supplier;
import utility.DataAccessException;

class TestUnit {
	ProductDB productDB;


	@Test
	public void buildBuyProduct() throws DataAccessException {
		// Arrange
		productDB = new ProductDB();
		int barcode = 1;
		int quantity = 1;
		// Act
		BuyProduct buyProduct = productDB.findBuyProductOnBarcode(barcode, quantity);
		// Assert
		assertNotNull(buyProduct);
		assertNotNull(buyProduct.getBuyProductType());
		assertEquals("Denmark", buyProduct.getCountryOfOrigin());
	} 
	
	@Test
	public void findCustomerOnPhone() {
		
	}

}
