package database;

import model.SaleOrder;
import utility.DataAccessException;

public interface SaleOrderDBIF {
	
	SaleOrder createSaleOrder();
	
	boolean completeSaleOrder(SaleOrder saleOrder) throws DataAccessException;

}
