package restaurant;

public class Order {

	// variables
	private int amount = 0;
	private Meal orderedMeal;
	private boolean isSuccess;
	private Client orderClient;

	// constructor
	public Order(Client orderClient, Meal orderedMeal, int amount, boolean isSuccess) {
		this.amount = amount;
		this.orderedMeal = orderedMeal;
		this.isSuccess = isSuccess;
		this.orderClient = orderClient;

	}

	// default constructor
	public Order() {
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Meal getOrderedMeal() {
		return orderedMeal;
	}

	public void setOrderedMeal(Meal orderedMeal) {
		this.orderedMeal = orderedMeal;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Client getOrderClient() {
		return orderClient;
	}

	public void setOrderClient(Client orderClient) {
		this.orderClient = orderClient;
	}

	@Override
	public String toString() {
		return "Order [amount=" + amount + ", orderedMeal=" + orderedMeal + ", isSuccess=" + isSuccess
				+ ", orderClient=" + orderClient + ", getAmount()=" + getAmount() + ", getOrderedMeal()="
				+ getOrderedMeal() + ", isSuccess()=" + isSuccess() + ", getOrderClient()=" + getOrderClient() + "]";
	}

	// getters & setters
	
	
}
