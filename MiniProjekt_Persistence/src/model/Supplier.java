package model;

public class Supplier {

	private String phone;
	private String name;
	private String address;
	private int zipcode;
	private String city;
	private String country;
	private String email;
	
	/**
	 * Constructor to initialize instance variables.
	 * @param phone
	 * @param name
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param country
	 * @param email
	 */
	public Supplier(String phone, String name, String address, int zipcode, String city, String country, String email) {
		super();
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
		this.email = email;
	}

	/**
	 * Constructor.
	 * @param phone
	 */
	public Supplier(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Constructor.
	 */
	public Supplier() {
		
	}

	/**
	 * Gets phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets new phone.
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Sets new name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Sets new address.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * Sets new zipcode.
	 * @param zipcode
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	/**
	 * Sets new city.
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * Sets new country.
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * Sets new email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
