package controller;

import database.SaleOrderDB;
import database.SaleOrderDBIF;
import model.Customer;
import model.Employee;
import model.SaleOrder;
import utility.DataAccessException;

public class SaleOrderController {
	
	private SaleOrderDBIF saleOrderDB;
	private PersonController personCtr;
	private ProductController productCtr;
	private SaleOrder saleOrder;
	
	public SaleOrderController() throws DataAccessException {
		saleOrderDB = new SaleOrderDB();
		personCtr = new PersonController();
	}
	
	public SaleOrder createSaleOrder(String phone) throws DataAccessException {
		this.saleOrder = saleOrderDB.createSaleOrder(phone);
		Employee employee = personCtr.findCurrentEmployee();
		Customer customer = personCtr.findCustomerByPhone(phone);
		this.saleOrder.setEmployee(employee);
		this.saleOrder.setCustomer(customer);
		return saleOrder;
	}

}
