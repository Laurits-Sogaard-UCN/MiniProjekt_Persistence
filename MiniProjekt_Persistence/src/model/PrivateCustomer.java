package model;

public class PrivateCustomer extends Customer {
	
	private double freeShipping;
	
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
	 * @param freeShipping
	 */
	public PrivateCustomer(String fname, String lname, String address, int zipcode, String city, String phone,
			String email, Customer customerType, double freeShipping) {
		super(fname, lname, address, zipcode, city, phone, email, customerType);
		this.freeShipping = freeShipping;
	}

	/**
	 * Constructor.
	 */
	public PrivateCustomer() {
		super(null, null, null, 0, null, null, null, null);
	}

	/**
	 * Gets freeShipping.
	 * @return double
	 */
	public double getFreeShipping() {
		return freeShipping;
	}

	/**
	 * Sets new freeShipping.
	 * @param freeShipping
	 */
	public void setFreeShipping(double freeShipping) {
		this.freeShipping = freeShipping;
	}

}
