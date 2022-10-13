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
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}


	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}


	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}


	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
