package restaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientList implements WorkWithFilesMore, WorkWithClients {

	private ArrayList<Client> listOfClients;
	Client newClient;

	public ClientList() {

	}

	@Override
	public void removeClient(String phoneNum) {
		
		listOfClients.remove(findClient(phoneNum));

	}

	@Override
	public void addClient(Client c) {
		
		listOfClients.add(c);

	}

	@Override
	public Client findClient(String phoneNum) {
		Client foundClient = null;
		for (int i = 0; i < listOfClients.size(); i++) 
			if (listOfClients.get(i).getPhoneNum().equals(phoneNum))
				foundClient=listOfClients.get(i);
				return foundClient;
	
	}

	@Override
	public void readFile(String fileName) {
		Scanner s = null;
		ArrayList<Client> listOfClients = new ArrayList<Client>();
		try {
			s = new Scanner(new File(fileName));
			do {
				String fName = s.next();
				String lName = s.next();
				String address = s.next();
				String phoneNum = s.next();
				Client newClient = new Client(fName, lName, address, phoneNum);
				listOfClients.add(newClient);
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
	public void writeFile(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (Client newClient : this.listOfClients)
				pw.println(newClient.getfName() + " " + newClient.getlName() + " " + newClient.getPhoneNum() + " "
						+ newClient.getAdress());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

}
