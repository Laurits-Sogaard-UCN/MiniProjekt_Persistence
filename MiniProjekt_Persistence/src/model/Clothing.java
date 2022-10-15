package model;

public class Clothing extends BuyProduct {

	private int size;
	private String colour;
	
	
	
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
	 * @param amount
	 * @param buyProductType
	 * @param size
	 * @param colour
	 */
	public Clothing(int barcode, String name, double purchasePrice, String countryOfOrigin, int minStock,
			int currentStock, double salesPrice, Product productType, Supplier supplier, int amount,
			BuyProduct buyProductType, int size, String colour) {
		super(barcode, name, purchasePrice, countryOfOrigin, minStock, currentStock, salesPrice, productType, supplier,
				amount, buyProductType);
		this.size = size;
		this.colour = colour;
	}

	/**
	 * Constructor.
	 */
	public Clothing() {
		super(0, null, 0, null, 0, 0, 0, null, null, 0, null);
	}


	/**
	 * Sets new size.
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * Sets new colour.
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
