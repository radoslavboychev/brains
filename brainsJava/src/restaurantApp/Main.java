package restaurantApp;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

//		Implement the following functionalities:
//			• Load client and menu data from files (clients.txt, menu.txt)
//			• Add, delete and search for menu items
//			• Add, delete and search for a client
//			• Add, delete and search for an order
//			• Write data about all orders in a file
//
//			Add support classes for lists of relevant objects 
		// (Client List, Order List - The menu itself is a list of Items).
		// In the test class, create a restaurant, load menu and customer data, and
		// create several orders.
		// Enter the data on realized orders in the output file.

		// list of clients
		ArrayList<Client> clients = new ArrayList<>();
		ClientList myClientList = new ClientList(clients);

		// create the items
		Item soup = new Item("chicken soup", "main", 3.56);
		Item pasta = new Item("turkey pasta", "main", 6.50);
		Item baguette = new Item("baguette", "side", 2.30);

		// create a list of items
		ArrayList<Item> items = new ArrayList<>();


		// create the menu from the list of items
		Menu menu = new Menu(items);

		// add items from the menu
		menu.addMenuItem(soup);
		menu.addMenuItem(baguette);
		menu.addMenuItem(pasta);

		// check if the menu works
		System.out.println(menu.toString());

	}

}
