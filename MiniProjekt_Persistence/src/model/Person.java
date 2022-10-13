package model;

public class Person {
	
	private String name;
	private String address;
	private int zipcode;
	private String city;
	private String phone;
	private String email;
	/**
	 * @param name
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 */
	public Person(String name, String address, int zipcode, String city, String phone, String email) {
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}
	
	

}
