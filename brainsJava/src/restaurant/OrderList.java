package restaurant;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OrderList implements WorkWithOrders {

	ArrayList<Order> listOfOrders = new ArrayList<Order>();
	Order o = new Order();

	public OrderList() {
		this.listOfOrders = new ArrayList<Order>();

	}

	@Override
	public void deleteOrder(Order orderName) {
		listOfOrders.remove(orderName);

	}

	@Override
	public void addOrder(Order o) {
		listOfOrders.add(o);

	}

	@Override
	public Order findOrder(String mealName, String phoneNum) {
		Order n = null;
		for (int i = 0; i < listOfOrders.size(); i++) {
			if (listOfOrders.get(i).getOrderedMeal().getName().equals(mealName)
					&& listOfOrders.get(i).getOrderClient().getPhoneNum().equals(phoneNum))
				;
			n = listOfOrders.get(i);
		}
		return n;
	}

	@Override
	public void writeOrder(String fileName) {
		PrintWriter pw = null;
		
		try {

			pw = new PrintWriter(new FileOutputStream(fileName));
			for (Order n : listOfOrders) {
				pw.println(n.toString());
			}
		} catch (IOException e) {
			System.out.println("An error has occurred!");
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}
