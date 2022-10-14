package model;

public class Person {
	
	private String fname;
	private String lname;
	private String address;
	private int zipcode;
	private String city;
	private String phone;
	private String email;
		
	/**
	 * Constructor to initialize instance variables.
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 */
	public Person(String fname, String lname, String address, int zipcode, String city, String phone, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}
	
	/**
	 * Gets fname.
	 * @return String
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * Sets new fname.
	 * @param fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * Gets lname.
	 * @return String
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * Sets new lname.
	 * @param lname
	 */
	public void setLname(String lname) {
		this.lname = lname;
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
