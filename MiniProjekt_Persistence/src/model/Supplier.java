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
	 * Gets name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets new name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets address.
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets new address.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets zipcode.
	 * @return int
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * Sets new zipcode.
	 * @param zipcode
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets city.
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets new city.
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets country.
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets new country.
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets new email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
