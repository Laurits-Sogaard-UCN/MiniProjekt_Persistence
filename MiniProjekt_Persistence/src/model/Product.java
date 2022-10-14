package model;


public class Product {
	
	private int barcode;
	private String name;
	private double purchasePrice;
	private String countryOfOrigin;
	private int minStock;
	private int currentStock;
	private double salesPrice;
	private Supplier supplier;
	
	/**
	 * @param barcode
	 * @param name
	 * @param purchasePrice
	 * @param countryOfOrigin
	 * @param minStock
	 * @param currentStock
	 * @param salesPrice
	 * @param supplier
	 */
	public Product(int barcode, String name, double purchasePrice, String countryOfOrigin, int minStock,
			int currentStock, double salesPrice, Supplier supplier) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.currentStock = currentStock;
		this.salesPrice = salesPrice;
		this.supplier = supplier;
	}

	/**
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * @param countryOfOrigin the countryOfOrigin to set
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	/**
	 * @return the currentStock
	 */
	public int getCurrentStock() {
		return currentStock;
	}

	/**
	 * @param currentStock the currentStock to set
	 */
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	/**
	 * @return the salesPrice
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	
}
