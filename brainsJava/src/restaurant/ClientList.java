package restaurant;

import java.util.ArrayList;

public interface ClientList {

	//this is a helper interface that makes working with client lists easier and cleaner
	
//	//this will create the list of clients
//	public void createClientList();
	
	//this will add a client to the list
	public void addToList(Client c, ArrayList<Client> a);
	
	//this will remove a client from the list
	public void removeFromList(Client c, ArrayList<Client> a);
	
	//this will find a client in a list
	public void searchForClient(Client c, ArrayList<Client> a);
	
	
	
}
