package restaurantApp;

public class Item {

	// The name of the item, type (appetizer, main course, salad, dessert, drink)
	// and price are remembered for each of the menu items.

	// variables
	private String itemName;
	private String itemType;
	private double itemPrice;

	// constructors
	public Item(String itemName, String itemType, double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}
	
	public Item() //default constructor
	{
		
	}

	//getter and setters
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	
	//item tostring
	@Override
	public String toString() {
		return "Item [getItemName()=" + getItemName() + ", getItemType()=" + getItemType() + ", getItemPrice()="
				+ getItemPrice() + "]";
	}
	
	

}
