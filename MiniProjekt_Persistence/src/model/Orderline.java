package model;

public class Orderline {
	
	private BuyProduct buyProduct;
	private int quantity;
	private SaleOrder saleOrder;
	
	/**
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
	 * @return the buyProduct
	 */
	public BuyProduct getBuyProduct() {
		return buyProduct;
	}
	/**
	 * @param buyProduct the buyProduct to set
	 */
	public void setBuyProduct(BuyProduct buyProduct) {
		this.buyProduct = buyProduct;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the saleOrder
	 */
	public SaleOrder getSaleOrder() {
		return saleOrder;
	}
	/**
	 * @param saleOrder the saleOrder to set
	 */
	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
}
