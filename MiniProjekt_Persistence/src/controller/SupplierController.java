package controller;

import database.SupplierDB;
import database.SupplierDBIF;
import model.Supplier;
import utility.DataAccessException;

public class SupplierController {
	
	private SupplierDBIF supplierDB;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public SupplierController() throws DataAccessException {
		supplierDB = new SupplierDB();
	}
	
	/**
	 * Finds Supplier object on phone number.
	 * @param phone
	 * @return Supplier
	 * @throws DataAccessException
	 */
	public Supplier findSupplierOnPhone(String phone) throws DataAccessException {
		Supplier supplier = supplierDB.findSupplierOnPhone(phone);
		return supplier;
	}

}
