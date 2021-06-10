package restaurant;

public class Meal {


	//variables
	private String type;
	private String name;
	private double price;

	// constructor
	public Meal(String name, String mealType, double price) {
		super();
		this.name = name;
		this.type = mealType;
		this.price = price;
	}

	// default constructor
	public Meal() {

	}

	// getters & setters


	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


}
