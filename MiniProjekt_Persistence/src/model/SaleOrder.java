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
	 * @param date
	 * @param total
	 * @param deliveryStatus
	 * @param deliveryDate
	 * @param customer
	 * @param employee
	 */
	public SaleOrder(LocalDate date, String deliveryStatus, LocalDate deliveryDate, Customer customer,
			Employee employee) {
		super();
		this.date = date;
		this.total = 0;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.employee = employee;
		this.orderlines = new ArrayList<>();
	}
	
	public SaleOrder() {
		this.orderlines = new ArrayList<>();
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	/**
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	/**
	 * @return the deliveryDate
	 */
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Orderline createOrderline(BuyProduct buyProduct, int quantity, SaleOrder saleOrder) {
		Orderline orderline = new Orderline(buyProduct, quantity, saleOrder);
		return orderline;
	}
	
	public void addOrderline(Orderline ol) {
		orderlines.add(ol);
	}
	
	public ArrayList<Orderline> getOrderlines() {
		return orderlines;
	}
	
	
	

}
