package model;


public class Product {
	
	private int barcode;
	private String name;
	private double purchasePrice;
	private String countryOfOrigin;
	private int minStock;
	private int currentStock;
	private double salesPrice;
	private Product productType;
	private Supplier supplier;
	
	/**
	 * Constructor to initialize instance variables.
	 * @param barcode
	 * @param name
	 * @param purchasePrice
	 * @param countryOfOrigin
	 * @param minStock
	 * @param currentStock
	 * @param salesPrice
	 * @param productType
	 * @param supplier
	 */
	public Product(int barcode, String name, double purchasePrice, String countryOfOrigin, int minStock,
			int currentStock, double salesPrice, Product productType, Supplier supplier) {
		this.barcode = barcode;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.currentStock = currentStock;
		this.salesPrice = salesPrice;
		this.productType = productType;
		this.supplier = supplier;
	}

	/**
	 * Gets barcode.
	 * @return int
	 */
	public int getBarcode() {
		return barcode;
	}

	/**
	 * Sets new barcode.
	 * @param barcode
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
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
	 * Gets purchasePrice.
	 * @return double
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Sets new purchasePrice.
	 * @param purchasePrice
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * Gets countryOfOrigin.
	 * @return String
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * Sets new countryOfOrigin.
	 * @param countryOfOrigin
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * Gets minStock.
	 * @return int
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * Sets new minStock.
	 * @param minStock
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	/**
	 * Gets currentStock.
	 * @return int
	 */
	public int getCurrentStock() {
		return currentStock;
	}

	/**
	 * Sets new currentStock.
	 * @param currentStock
	 */
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	/**
	 * Gets salesPrice.
	 * @return double
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * Sets new salesPrice.
	 * @param salesPrice
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	/**
	 * Gets productType.
	 * @return Product
	 */
	public Product getProductType() {
		return productType;
	}

	/**
	 * Sets new productType.
	 * @param productType
	 */
	public void setProductType(Product productType) {
		this.productType = productType;
	}

	/**
	 * Gets supplier.
	 * @return Supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * Sets new supplier.
	 * @param supplier
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
