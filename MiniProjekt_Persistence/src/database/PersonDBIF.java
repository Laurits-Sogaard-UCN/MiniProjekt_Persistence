package database;

import model.Customer;
import utility.DataAccessException;

public interface PersonDBIF {
	
	Customer findCustomerByPhone(String phone) throws DataAccessException;

}
