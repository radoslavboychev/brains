package restaurantApp;

import java.util.ArrayList;

public class Order implements OrderHelper {

	// An order consists of one or more menu items ordered by a particular customer,
	// as well as information on whether the order was successfully realized or not.

	private ArrayList<Item> itemList;
	private Client orderClient;
	boolean isSuccess;

	// constructor
	
	public Order(ArrayList<Item> itemList, Client orderClient, boolean isSuccess) {
		super();
		this.itemList = itemList;
		this.orderClient = orderClient;
		this.isSuccess = isSuccess;
	}

	public Order() { //default constructor
	}
	

	//getters and setters
	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Override
	public void addOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOrderData(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	

}
