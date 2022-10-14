package model;

public class Orderline {
	
	private BuyProduct buyProduct;
	private int quantity;
	private SaleOrder saleOrder;
	
	/**
	 * Constructor to initialize instance variables.
	 * @param buyProduct
	 * @param quantity
	 * @param saleOrder
	 */
	public Orderline(BuyProduct buyProduct, int quantity, SaleOrder saleOrder) {
		this.buyProduct = buyProduct;
		this.quantity = quantity;
		this.saleOrder = saleOrder;
	}
	
	/**
	 * Gets buyProduct.
	 * @return BuyProduct
	 */
	public BuyProduct getBuyProduct() {
		return buyProduct;
	}
	
	/**
	 * Sets new buyProduct.
	 * @param buyProduct
	 */
	public void setBuyProduct(BuyProduct buyProduct) {
		this.buyProduct = buyProduct;
	}
	
	/**
	 * Gets quantity.
	 * @return int
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets new quantity.
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets saleOrder.
	 * @return SaleOrder
	 */
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	
	/**
	 * Sets new saleOrder.
	 * @param saleOrder
	 */
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	
}
