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
	 * @param size
	 * @param buyProductType
	 * @param size2
	 * @param colour
	 */
	public Clothing(int barcode, String name, double purchasePrice, String countryOfOrigin, int minStock,
			int currentStock, double salesPrice, Product productType, Supplier supplier, int size,
			BuyProduct buyProductType, int size2, String colour) {
		super(barcode, name, purchasePrice, countryOfOrigin, minStock, currentStock, salesPrice, productType, supplier,
				size, buyProductType);
		size = size2;
		this.colour = colour;
	}
	
	public Clothing() {
		super(0, null, 0, null, 0, 0, 0, null, null, 0, null);
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
