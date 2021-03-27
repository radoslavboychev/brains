package restaurantApp;

import java.util.ArrayList;

public class OrderList {

	private ArrayList<Order> orders;
	private int orderID;

	public OrderList(int orderID, ArrayList<Order> orders) {
		super();
		this.orderID = orderID;
		this.orders = orders;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "OrderList [getOrders()=" + getOrders() + ", getOrderID()=" + getOrderID() + "]";
	}

	
	
}
