package restaurantApp;

import java.util.ArrayList;

public class Menu implements MenuHelper {

	private ArrayList<Item> menuItems;

	// constructor
	public Menu(ArrayList<Item> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	public Menu() { // default constructor
	}

	// getters and setters
	public ArrayList<Item> getMenu() {
		return menuItems;
	}

	public void setMenu(ArrayList<Item> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public void addMenuItem(Item i) {
		menuItems.add(i);

	}

	@Override
	public void removeMenuItem(Item i) {
		menuItems.remove(i);

	}

	@Override
	public Item findMenuItem(String itemName) {
		Item foundItem = null;

		for (Item item : menuItems) {
			if (item.getItemName().equals(itemName)) {
				foundItem = item;
			}
		}
		return foundItem;
	}

	@Override
	public void loadMenuFromFile(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Menu [getMenu()=" + getMenu() + "]";
	}
	

}
