package model;

public class BusinessCustomer extends Customer {

	private String businessName;
	private int CVR;
	private int discount;
	/**
	 * @param fname
	 * @param lname
	 * @param address
	 * @param zipcode
	 * @param city
	 * @param phone
	 * @param email
	 * @param businessName
	 * @param cVR
	 * @param discount
	 */
	public BusinessCustomer(String fname, String lname, String address, int zipcode, String city, String phone,
			String email, String businessName, int cVR, int discount) {
		super(fname, lname, address, zipcode, city, phone, email);
		this.businessName = businessName;
		CVR = cVR;
		this.discount = discount;
	}
	
	public BusinessCustomer() {
		super(null, null, null, 0, null, null, null);
	}

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @return the cVR
	 */
	public int getCVR() {
		return CVR;
	}

	/**
	 * @param cVR the cVR to set
	 */
	public void setCVR(int cVR) {
		CVR = cVR;
	}

	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
