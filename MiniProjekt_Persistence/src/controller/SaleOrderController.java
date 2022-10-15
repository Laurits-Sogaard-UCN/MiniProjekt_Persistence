package controller;

import database.SaleOrderDB;
import database.SaleOrderDBIF;
import model.BusinessCustomer;
import model.BuyProduct;
import model.Customer;
import model.Employee;
import model.Orderline;
import model.PrivateCustomer;
import model.Product;
import model.SaleOrder;
import model.Supplier;
import utility.DataAccessException;

public class SaleOrderController {
	
	private SaleOrderDBIF saleOrderDB;
	private PersonController personCtr;
	private ProductController productCtr;
	private SupplierController supplierCtr;
	private SaleOrder saleOrder;
	
	/**
	 * Constructor to initialize instance variables.
	 * @throws DataAccessException
	 */
	public SaleOrderController() throws DataAccessException {
		saleOrderDB = new SaleOrderDB();
		personCtr = new PersonController();
		productCtr = new ProductController();
		supplierCtr = new SupplierController();
	}
	
	/**
	 * Creates a SaleOrder object containing a Customer and Employee object.
	 * @param phone
	 * @return SaleOrder
	 * @throws DataAccessException
	 */
	public SaleOrder createSaleOrder(String phone) throws DataAccessException {
		this.saleOrder = saleOrderDB.createSaleOrder();
		Employee employee = personCtr.findCurrentEmployee();
		Customer customer = personCtr.findCustomerByPhone(phone);
		this.saleOrder.setEmployee(employee);
		this.saleOrder.setCustomer(customer);
		return saleOrder;
	}
	
	/**
	 * Adds an Orderline object containing a Product to SaleOrder object.
	 * Calculates total on SaleOrder object.
	 * @param barcode
	 * @param quantity
	 * @return SaleOrder
	 * @throws DataAccessException
	 */
	public SaleOrder addProduct(int barcode, int quantity) throws DataAccessException {
		BuyProduct product = productCtr.findBuyProductOnBarcode(barcode, quantity);
		if(product.getBuyProductType() != null) {
			Supplier supplier = supplierCtr.findSupplierOnPhone(product.getSupplier().getPhone());
			product.setSupplier(supplier);
			Orderline orderline = saleOrder.createOrderline(product, quantity, this.saleOrder);
			this.saleOrder.addOrderline(orderline);
			this.saleOrder.setTotal(calculateTotal());
		}
		return this.saleOrder;
	}
	
	/**
	 * Completes saleOrder by adding the SaleOrder objects data to database.
	 * @return boolean
	 * @throws DataAccessException
	 */
	public boolean completeSaleOrder() throws DataAccessException {
		boolean completed = false;
		if(saleOrderDB.completeSaleOrder(this.saleOrder)) {
			completed = true;
		}
		this.saleOrder = null;
		return completed;
	}
	
	/**
	 * Calculates total on SaleOrder object.
	 * @return double
	 */
	private double calculateTotal() {
		double total = 0;
		for(Orderline element : this.saleOrder.getOrderlines()) {
			this.saleOrder.setTotal(total += (element.getBuyProduct().getSalesPrice() * element.getQuantity()));
		}
		if(this.saleOrder.getCustomer() instanceof PrivateCustomer && this.saleOrder.getTotal() >= 2500) {
			PrivateCustomer customer = (PrivateCustomer) this.saleOrder.getCustomer();
			this.saleOrder.setTotal(total - customer.getFreeShipping());
		}
		if(this.saleOrder.getCustomer() instanceof BusinessCustomer && this.saleOrder.getTotal() >= 1500) {
			BusinessCustomer customer = (BusinessCustomer) this.saleOrder.getCustomer();
			this.saleOrder.setTotal(total - ((customer.getDiscount()/100) * total));
		}
		return this.saleOrder.getTotal();
	}
	
	/**
	 * Gets SaleOrder instance variable.
	 * @return SaleOrder
	 */
	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

}
