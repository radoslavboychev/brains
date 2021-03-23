package restaurant;

import java.util.ArrayList;

public interface OrderList {

	public void createOrderList();
	
	public void addOrderToList(Order o, ArrayList<Order> e);
	
	public void removeOrderFromList(Order o, ArrayList<Order> e);
	
	public void findOrderFromList(Order o, ArrayList<Order> e);
}
