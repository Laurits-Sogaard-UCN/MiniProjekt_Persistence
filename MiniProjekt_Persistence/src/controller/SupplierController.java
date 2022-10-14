package controller;

import database.SupplierDB;
import database.SupplierDBIF;
import model.Supplier;
import utility.DataAccessException;

public class SupplierController {
	
	private SupplierDBIF supplierDB;
	
	public SupplierController() throws DataAccessException {
		supplierDB = new SupplierDB();
	}
	
	public Supplier findSupplierOnPhone(String phone) throws DataAccessException {
		Supplier supplier = supplierDB.findSupplierOnPhone(phone);
		return supplier;
	}

}
