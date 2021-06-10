package restaurant;

public interface WorkWithClients {

	public void removeClient(String phoneNum);

	public void addClient(Client c);

	Client findClient(String phoneNum);

}
