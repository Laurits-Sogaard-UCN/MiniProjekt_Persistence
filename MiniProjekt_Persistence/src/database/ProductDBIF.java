package database;

import model.BuyProduct;
import utility.DataAccessException;

public interface ProductDBIF {
	
	BuyProduct findBuyProductOnBarcode(int barcode, int quantity) throws DataAccessException;

}
