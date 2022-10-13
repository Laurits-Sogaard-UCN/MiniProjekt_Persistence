package database;

import model.SaleOrder;
import utility.DataAccessException;

public interface SaleOrderDBIF {
	
	SaleOrder createSaleOrder(String phone) throws DataAccessException;

}
