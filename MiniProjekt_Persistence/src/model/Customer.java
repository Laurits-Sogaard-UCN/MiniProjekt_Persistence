package model;

public class Customer extends Person {

	/**
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 */
	public Customer(String fname, String lname, String address, int zipcode, String city, String phone, String email) {
		super(fname, lname, address, zipcode, city, phone, email);
	}

	public Customer(String phone) {
		super(null, null, null, 0, null, phone, null);
	}
	
	public Customer() {
		super(null, null, null, 0, null, null, null);
	}

	

}
