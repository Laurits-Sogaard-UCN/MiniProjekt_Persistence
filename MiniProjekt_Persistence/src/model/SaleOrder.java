package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SaleOrder {
	
	private LocalDate date;
	private double total;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private Customer customer;
	private Employee employee;
	private ArrayList<Orderline> orderlines;
	
	/**
	 * Constructor to initialize instance variables.
	 * @param date
	 * @param total
	 * @param deliveryStatus
	 * @param deliveryDate
	 * @param customer
	 * @param employee
	 */
	public SaleOrder(LocalDate date, String deliveryStatus, LocalDate deliveryDate, Customer customer,
			Employee employee) {
		this.date = date;
		this.total = 0;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.employee = employee;
		this.orderlines = new ArrayList<>();
	}
	
	/**
	 * Constructor.
	 */
	public SaleOrder() {
		this.orderlines = new ArrayList<>();
	}
	
	/**
	 * Gets date.
	 * @return LocalDate
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Gets total.
	 * @return double
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * Sets new total.
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
	/**
	 * Gets deliveryStatus.
	 * @return String
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	
	
	/**
	 * Gets deliveryDate.
	 * @return LocalDate
	 */
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	
	
	/**
	 * Gets customer.
	 * @return Customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Sets new customer.
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * Gets employee.
	 * @return Employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Sets new employee.
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Creates new Orderline object.
	 * @param buyProduct
	 * @param quantity
	 * @param saleOrder
	 * @return Orderline
	 */
	public Orderline createOrderline(BuyProduct buyProduct, int quantity, SaleOrder saleOrder) {
		Orderline orderline = new Orderline(buyProduct, quantity, saleOrder);
		return orderline;
	}
	
	/**
	 * Adds Orderline object to ArrayList of Orderlines.
	 * @param ol
	 */
	public void addOrderline(Orderline ol) {
		orderlines.add(ol);
	}
	
	/**
	 * Gets ArrayList of Orderlines. 
	 * @return ArrayList<Orderline>
	 */
	public ArrayList<Orderline> getOrderlines() {
		return orderlines;
	}
	
	/**
	 * Calculates total on SaleOrder object.
	 * @return double
	 */
	public double calculateTotal() {
		double total = 0;
		ArrayList<Orderline> orderlines1 = new ArrayList<>();
		for(Orderline element : orderlines) {
			if(!orderlines1.contains(element)) {
				setTotal(total += (element.getBuyProduct().getSalesPrice() * element.getQuantity()));
				orderlines1.add(element);
			}
		}
		if(getCustomer() instanceof PrivateCustomer && getTotal() >= 2500) {
			PrivateCustomer customer = (PrivateCustomer) getCustomer();
			setTotal(total - customer.getFreeShipping());
		}
		else if(getCustomer() instanceof PrivateCustomer && getTotal() < 2500) {
			PrivateCustomer customer = (PrivateCustomer) getCustomer();
			setTotal(total + customer.getFreeShipping());
		}
		if(getCustomer() instanceof BusinessCustomer && getTotal() >= 1500) {
			BusinessCustomer customer = (BusinessCustomer) getCustomer();
			setTotal(total - ((customer.getDiscount()/100) * total));
		}
		return getTotal();
	}
	
	
	

}
