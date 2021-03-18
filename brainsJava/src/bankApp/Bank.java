package bankApp;

import java.util.ArrayList;

public class Bank implements WorkWithClients, WorkWithTransactions {

	private ArrayList<Client> clients;
	
	private ArrayList<Transaction> transactions;

	@Override
	public boolean createInternalTransaction(Client sender, Client receiver, float amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dodajKlijenta(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obrisiKlijenta(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client findClient(String idNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Bank(ArrayList<Client> clients, ArrayList<Transaction> transactions) {
		super();
		this.clients = clients;
		this.transactions = transactions;
	}

	public Bank() {};
	
	
	
}
