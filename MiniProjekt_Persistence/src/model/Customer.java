package model;

public class Customer extends Person {
	
	private Customer customerType;

	/**
	 * Constructor to initialize instance variables.
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param customerType
	 */
	public Customer(String fname, String lname, String address, int zipcode, String city, String phone, String email,
			Customer customerType) {
		super(fname, lname, address, zipcode, city, phone, email);
		this.customerType = customerType;
	}

	/**
	 * Constructor.
	 * @param phone
	 */
	public Customer(String phone) {
		super(null, null, null, 0, null, phone, null);
	}
	
	/**
	 * Constructor.
	 */
	public Customer() {
		super(null, null, null, 0, null, null, null);
	}


	/**
	 * Sets new customerType.
	 * @param customerType
	 */
	public void setCustomerType(Customer customerType) {
		this.customerType = customerType;
	}
	

}
