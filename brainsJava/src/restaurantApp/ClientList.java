package restaurantApp;

import java.util.ArrayList;

public class ClientList {
	
	private ArrayList<Client> clientList;

	public ClientList(ArrayList<Client> clientList) {
		super();
		this.clientList = clientList;
	}

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}
	
	

}
