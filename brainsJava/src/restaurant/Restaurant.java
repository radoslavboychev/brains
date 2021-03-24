package restaurant;

public class Restaurant implements WorkWithClients, WorkWithMenus, WorkWithFiles, WorkWithFilesMore, WorkWithOrders {

	private ClientList listOfClients;
	private OrderList orders;
	private Menu menu;
	private String fileName;
	private double bill;

	public Restaurant(double bill, ClientList listOfClients, OrderList orders, Menu menu, String fileName) {
		this.bill = bill;
		this.listOfClients = listOfClients;
		this.orders = orders;
		this.menu = menu;
		this.fileName = fileName;
	}

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public double calculateBill(Order o, Meal m) {
		return bill = o.getAmount() * m.getPrice();
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public ClientList getListOfClients() {
		return listOfClients;
	}

	public void setListOfClients(ClientList listOfClients) {
		this.listOfClients = listOfClients;
	}

	public OrderList getOrders() {
		return orders;
	}

	public void setOrders(OrderList orders) {
		this.orders = orders;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void deleteOrder(Order orderName) {

		orders.deleteOrder(orderName);
	}

	@Override
	public void addOrder(Order o) {

		orders.addOrder(o);

	}

	@Override
	public Order findOrder(String mealName, String phoneNum) {

		return orders.findOrder(mealName, phoneNum);
	}

	@Override
	public void writeOrder(String fileName) {

		orders.writeOrder(fileName);

	}

	@Override
	public void readFile(String fileName) {

		listOfClients.readFile(fileName);

	}

	@Override
	public void writeFile(String fileName) {

		listOfClients.writeFile(fileName);
	}

	@Override
	public void writeList(String fileName) {

		menu.writeList(fileName);
	}

	@Override
	public void readList(String fileName) {
		menu.readList(fileName);

	}

	@Override
	public void removeMeal(String mealName) {
		menu.removeMeal(mealName);

	}

	@Override
	public void addMeal(Meal m) {
		menu.addMeal(m);

	}

	@Override
	public Meal findMeal(String mealName) {
		return menu.findMeal(mealName);
	}

	@Override
	public void removeClient(String phoneNum) {
		listOfClients.removeClient(phoneNum);

	}

	@Override
	public void addClient(Client c) {
		listOfClients.addClient(c);

	}

	@Override
	public Client findClient(String phoneNum) {
		return listOfClients.findClient(phoneNum);
	}

}
