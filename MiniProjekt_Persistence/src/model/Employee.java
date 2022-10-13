package model;

public class Employee extends Person {
	
	private int CPR;
	
	/**
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param cPR
	 */
	public Employee(String fname, String lname, String address, int zipcode, String city, String phone, String email,
			int cPR) {
		super(fname, lname, address, zipcode, city, phone, email);
		CPR = cPR;
	}


	public Employee(String phone) {
		super(null, null, null, 0, null, phone, null);
	}

}
