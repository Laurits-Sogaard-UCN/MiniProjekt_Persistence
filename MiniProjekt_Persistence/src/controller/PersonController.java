package controller;

import database.PersonDB;
import database.PersonDBIF;
import model.Customer;
import model.Employee;
import utility.DataAccessException;

public class PersonController {
	
	private Employee employee;
	private PersonDBIF personDB;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public PersonController() throws DataAccessException {
		personDB = new PersonDB();
		this.employee = new Employee("Anne", "Svendson", "Billegade 10", 9000, "Aalborg", "+4512344321", "Person1@mail.com", "9876543210");
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
		Customer customer = personDB.findCustomerByPhone(phone);
		return customer;
	}

}
