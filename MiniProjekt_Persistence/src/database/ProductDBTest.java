/**
 * 
 */
package database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author lauri
 *
 */
class ProductDBTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testBuildBuyProduct() throws Exception {
		// Arrange
		Connection con = DBConnection.getInstance().getConnection();
		String findProductOnBarcode = ("");
		String  = ("");
		PreparedStatement = con.prepareStatement(query);
		PreparedStatement = con.prepareStatement(query2);
		ResultSet rs = ;
		// Act
		
		// Assert
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindCustomerByNumber() throws Exception {
		fail("Not yet implemented");
	}

	
}
