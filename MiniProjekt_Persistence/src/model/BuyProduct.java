package model;

public class BuyProduct extends Product {
	
	private int amount;
	private BuyProduct BuyProductType;
	
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
	 * @param size
	 * @param buyProductType
	 */
	public BuyProduct(int barcode, String name, double purchasePrice, String countryOfOrigin, int minStock,
			int currentStock, double salesPrice, Product productType, Supplier supplier, int amount,
			BuyProduct buyProductType) {
		super(barcode, name, purchasePrice, countryOfOrigin, minStock, currentStock, salesPrice, productType, supplier);
		this.amount = amount;
		BuyProductType = buyProductType;
	}
	
	/**
	 * Constructor.
	 */
	public BuyProduct() {
		super(0, null, 0, null, 0, 0, 0, null, null);
	}
	
	
	/**
	 * Sets new amount.
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets buyProductType.
	 * @return BuyProduct
	 */
	public BuyProduct getBuyProductType() {
		return BuyProductType;
	}
	
	/**
	 * Sets new buyProductType.
	 * @param buyProductType
	 */
	public void setBuyProductType(BuyProduct buyProductType) {
		BuyProductType = buyProductType;
	}
	
}
