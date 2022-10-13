package controller;

import database.SaleOrderDB;
import database.SaleOrderDBIF;
import model.SaleOrder;

public class SaleOrderController {
	
	private SaleOrderDBIF saleOrderDB;
	
	public SaleOrderController() {
		saleOrderDB = new SaleOrderDB();
	}
	
	public SaleOrder createSaleOrder(String phone) {
		saleOrderDB.createSaleOrder(phone);
	}

}
