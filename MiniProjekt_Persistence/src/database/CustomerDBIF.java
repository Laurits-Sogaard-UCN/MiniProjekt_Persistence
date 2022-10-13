package database;

import model.Customer;
import utility.DataAccessException;

public interface CustomerDBIF {
	
	Customer findCustomerByPhone(String phone) throws DataAccessException;

}
