package model;

public class BusinessCustomer extends Customer {

	private String businessName;
	private int CVR;
	private double discount;
	
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
	 * @param businessName
	 * @param CVR
	 * @param discount
	 */
	public BusinessCustomer(String fname, String lname, String address, int zipcode, String city, String phone,
			String email, Customer customerType, String businessName, int CVR, double discount) {
		super(fname, lname, address, zipcode, city, phone, email, customerType);
		this.businessName = businessName;
		this.CVR = CVR;
		this.discount = discount;
	}

	/**
	 * Constructor.
	 */
	public BusinessCustomer() {
		super(null, null, null, 0, null, null, null, null);
	}

	/**
	 * Gets businessName.
	 * @return String
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * Sets new businessName.
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * Gets CVR.
	 * @return int
	 */
	public int getCVR() {
		return CVR;
	}

	/**
	 * Sets new CVR.
	 * @param CVR
	 */
	public void setCVR(int CVR) {
		this.CVR = CVR;
	}

	/**
	 * Gets discount.
	 * @return double
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Sets new discount.
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
