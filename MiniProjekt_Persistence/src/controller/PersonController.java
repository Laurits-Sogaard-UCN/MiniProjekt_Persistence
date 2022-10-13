package controller;

import database.CustomerDB;
import database.CustomerDBIF;
import model.Customer;
import model.Employee;
import utility.DataAccessException;

public class PersonController {
	
	private Employee employee;
	private CustomerDBIF customerDB;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public PersonController() throws DataAccessException {
		customerDB = new CustomerDB();
		this.employee = new Employee("Bo", "Hansen", "Vej 1", 9000, "Aalborg", "+4512345678", "mail.bo", 1234567890);
	}
	
	/**
	 * Finds the Employee who is currently logged in to the system.
	 * @return
	 */
	public Employee findCurrentEmployee() {
		return this.employee;
	}
	
	/**
	 * Finds a Customer by phone number.
	 * @param phone
	 * @return Customer
	 * @throws DataAccessException
	 */
	public Customer findCustomerByPhone(String phone) throws DataAccessException {
		Customer customer = customerDB.findCustomerByPhone(phone);
		return customer;
	}

}
