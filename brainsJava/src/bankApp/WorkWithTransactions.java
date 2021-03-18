package bankApp;

public interface WorkWithTransactions {

	boolean createInternalTransaction(Client sender, Client receiver, float amount);
	
}
