package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.PersonDB;
import database.ProductDB;
import model.BuyProduct;
import model.Clothing;
import model.Customer;
import model.Product;
import model.Supplier;
import utility.DataAccessException;

class TestUnit {
	ProductDB productDB;
	PersonDB personDB;
	


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
		assertEquals("Hat", buyProduct.getName());
		assertEquals(10, buyProduct.getPurchasePrice());
		assertEquals("Denmark", buyProduct.getCountryOfOrigin());
		assertEquals(10, buyProduct.getMinStock());
		assertEquals(2501, buyProduct.getSalesPrice());
	} 
	
	@Test
	public void findCustomerOnPhone() throws DataAccessException {
		// Arrange
		personDB = new PersonDB();
		String phone = "+4512341234";
		// Act
		Customer customer = personDB.findCustomerByPhone(phone);
		// Assert
		assertEquals("Per", customer.getFname());
		assertEquals("Svendson", customer.getLname());
		assertEquals("Billegade 10", customer.getAddress());
		assertEquals(9000, customer.getZipcode());
		assertEquals("Aalborg", customer.getCity());
		assertEquals("Person1@mail.com", customer.getEmail());
		assertEquals(phone, customer.getPhone());
	}
	
	@Test
	public void findCustomerOnPhoneNegative() throws DataAccessException {
		// Arrange
		personDB = new PersonDB();
		String phone = "+4512341232";
		// Act
		Customer customer = personDB.findCustomerByPhone(phone);
		// Assert
		assertNull(customer.getPhone());
	}

}
