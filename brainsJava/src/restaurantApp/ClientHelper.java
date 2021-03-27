package restaurantApp;

public interface ClientHelper {

	public void addClient(Client c);
	
	public void removeClient(Client c);
	
	public Client findClient(String phoneNum);
	
	public void loadClientList(String fileName);

	
	
}
