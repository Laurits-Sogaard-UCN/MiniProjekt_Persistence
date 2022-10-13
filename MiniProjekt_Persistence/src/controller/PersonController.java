package controller;

import database.CustomerDB;
import database.CustomerDBIF;
import model.Customer;
import model.Employee;
import utility.DataAccessException;

public class PersonController {
	
	private Employee employee;
	private CustomerDBIF customerDB;
	
	public PersonController() throws DataAccessException {
		customerDB = new CustomerDB();
		this.employee = new Employee("Bo", "Hansen", "Vej 1", 9000, "Aalborg", "+4512345678", "mail.bo", 1234567890);
	}
	
	public Employee findCurrentEmployee() {
		return this.employee;
	}
	
	public Customer findCustomerByPhone(String phone) throws DataAccessException {
		Customer customer = customerDB.findCustomerByPhone(phone);
		return customer;
	}

}
