package restaurantApp;

import java.util.ArrayList;

public class Restaurant {

	private int restaurantID;
	private String restaurantName;
	private Menu menu;
	private OrderList orderList;
	private ClientList clientList;

	public Restaurant(int restaurantID, String restaurantName, Menu menu, OrderList orderList, ClientList clientList) {
		super();
		this.restaurantID = restaurantID;
		this.restaurantName = restaurantName;
		this.menu = menu;
		this.orderList = orderList;
		this.clientList = clientList;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	public ClientList getClientList() {
		return clientList;
	}

	public void setClientList(ClientList clientList) {
		this.clientList = clientList;
	}

	@Override
	public String toString() {
		return "Restaurant [getRestaurantID()=" + getRestaurantID() + ", getRestaurantName()=" + getRestaurantName()
				+ ", getMenu()=" + getMenu() + ", getOrderList()=" + getOrderList() + ", getClientList()="
				+ getClientList() + "]";
	}

	
}
