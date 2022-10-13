package model;

public class Customer extends Person {
	
	private int freeShipping;

	/**
	 * @param name
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param freeShipping
	 */
	public Customer(String name, String address, int zipcode, String city, String phone, String email,
			int freeShipping) {
		super(name, address, zipcode, city, phone, email);
		this.freeShipping = freeShipping;
	}

	public Customer(String phone) {
		super("", "", 0, "", phone, null);
	}

	

}
