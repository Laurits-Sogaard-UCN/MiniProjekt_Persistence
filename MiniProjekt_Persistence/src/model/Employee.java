package model;

public class Employee extends Person {
	
	private int CPR;

	/**
	 * @param name
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param cPR
	 */
	public Employee(String name, String address, int zipcode, String city, String phone, String email, int cPR) {
		super(name, address, zipcode, city, phone, email);
		CPR = cPR;
	}
	
	public Employee(String phone) {
		super("", "", 0, "", phone, "");
	}

}
