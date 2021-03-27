package restaurantApp;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> itemList;

	public ItemList(ArrayList<Item> itemList) {
		super();
		this.itemList = itemList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "ItemList [getItemList()=" + getItemList() + "]";
	}
	
	
	
}
