package model;

public class Employee extends Person {
	
	private String CPR;
	
	/**
	 * Constructor to initialize instance variables.
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param CPR
	 */
	public Employee(String fname, String lname, String address, int zipcode, String city, String phone, String email,
			String CPR) {
		super(fname, lname, address, zipcode, city, phone, email);
		this.CPR = CPR;
	}

	/**
	 * Constructor.
	 * @param phone
	 */
	public Employee(String phone) {
		super(null, null, null, 0, null, phone, null);
	}

}
