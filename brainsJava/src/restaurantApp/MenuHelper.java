package restaurantApp;

public interface MenuHelper {
	
	public void addMenuItem(Item i);
	
	public void removeMenuItem(Item i);
	
	public Item findMenuItem(String itemName);
	
	public void loadMenuFromFile(String fileName);

}
