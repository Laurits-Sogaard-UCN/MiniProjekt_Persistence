package model;

public class BuyProduct extends Product {
	
	private int amount;
	private BuyProduct BuyProductType;
	
	/**
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
	
	public BuyProduct() {
		super(0, null, 0, null, 0, 0, 0, null, null);
	}
	/**
	 * @return the size
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param size the size to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the buyProductType
	 */
	public BuyProduct getBuyProductType() {
		return BuyProductType;
	}
	/**
	 * @param buyProductType the buyProductType to set
	 */
	public void setBuyProductType(BuyProduct buyProductType) {
		BuyProductType = buyProductType;
	}
	
}
