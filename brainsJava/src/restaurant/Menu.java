package restaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements WorkWithFiles, WorkWithMenus {

	private ArrayList<Meal> itemList;

	public Menu() {

		itemList = new ArrayList<Meal>();
	}

	public Menu(ArrayList<Meal> itemList) {
		super();
		this.itemList = itemList;
	}

	public ArrayList<Meal> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Meal> itemList) {
		this.itemList = itemList;
	}

	@Override
	public void removeMeal(String mealName) {

		itemList.remove(findMeal(mealName));
		System.out.println(mealName + " has been removed.");

	}

	@Override
	public void addMeal(Meal m) {
		itemList.add(m);

	}

	@Override
	public Meal findMeal(String mealName) {
		Meal findMeal = null;
		for (int i = 0; i < itemList.size(); i++)
			if (itemList.get(i).getName().equals(mealName))
				findMeal = itemList.get(i);

		return findMeal;
	}

	@Override
	public void readList(String fileName) {

		Scanner s = null;
		ArrayList<Meal> listOfMeal = new ArrayList<Meal>();
		try {
			s = new Scanner(new File(fileName));
			do {
				String mealName = s.next();
				String mealType = s.next();
				double price = s.nextDouble();
				Meal newMeal = new Meal(mealName, mealType, price);
				listOfMeal.add(newMeal);
			} while (s.hasNext());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}

	}

	@Override
	public void writeList(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (Meal m : this.itemList)
				pw.println(m.getName() + " " + m.getType() + " " + " " + m.getPrice());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

	public void printList() {
		System.out.println(this.itemList);
	}

	public String toString() {
		
		return "Meals: " + itemList;

	}

}
