package restaurant;

public interface WorkWithOrders {

	public void deleteOrder(Order orderName);
	 void addOrder(Order o);
	Order findOrder(String mealName,String phoneNum);
	void writeOrder(String fileName);
}
