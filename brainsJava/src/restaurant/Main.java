package restaurant;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Client client1 = new Client("Joe", "Jones", "31, First str", "+3598353295");
		
		ArrayList<Client> clientList = new ArrayList<>();

		client1.addToList(client1, clientList);
		client1.removeFromList(client1, clientList);
		
		
	}

}
