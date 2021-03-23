package restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Menu implements WorkWithFiles {

	private ArrayList<Item> itemList;

	public Menu(ArrayList<Item> itemList) {
		super();
		this.itemList = itemList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	// working with files
	@Override
	public void loadFromFile(BufferedReader br) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeToFile(BufferedWriter bw) {
		// TODO Auto-generated method stub

	}

}
