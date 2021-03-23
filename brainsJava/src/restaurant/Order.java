package restaurant;

import java.util.ArrayList;

public class Order implements OrderList {

	// variables
	private ArrayList<Item> items;
	private Client client;
	private boolean success;

	// constructor
	public Order(ArrayList<Item> items, Client client, boolean success) {
		super();
		this.items = items;
		this.client = client;
		this.success = success;
	}

	// default constructor
	public Order() {
	}

	// getters & setters
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public void createOrderList() {

		ArrayList<Order> orderList = new ArrayList<Order>();

	}

	@Override
	public void addOrderToList(Order o, ArrayList<Order> e) {
		
		e.add(o);
		
	}

	@Override
	public void removeOrderFromList(Order o, ArrayList<Order> e) {
		
		e.remove(o);
		
	}

	@Override
	public void findOrderFromList(Order o, ArrayList<Order> e) {
		// TODO 
		
	}

}
