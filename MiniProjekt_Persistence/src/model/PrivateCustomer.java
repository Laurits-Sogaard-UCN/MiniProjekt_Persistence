package model;

public class PrivateCustomer extends Customer {
	
	private int freeShipping;

	/**
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param freeShipping
	 */
	public PrivateCustomer(String fname, String lname, String address, int zipcode, String city, String phone,
			String email, int freeShipping) {
		super(fname, lname, address, zipcode, city, phone, email);
		this.freeShipping = freeShipping;
	}
	
	public PrivateCustomer() {
		super(null, null, null, 0, null, null, null);
	}

	/**
	 * @return the freeShipping
	 */
	public int getFreeShipping() {
		return freeShipping;
	}

	/**
	 * @param freeShipping the freeShipping to set
	 */
	public void setFreeShipping(int freeShipping) {
		this.freeShipping = freeShipping;
	}

}
