package database;

import model.Supplier;
import utility.DataAccessException;

public interface SupplierDBIF {
	
	Supplier findSupplierOnPhone(String phone) throws DataAccessException;

}
