package bankApp;

public class Transaction implements WorkWithFiles {

	private Client receiver;
	private Client sender;
	private float deposit;
	private boolean interna;
	
	
	@Override
	public void readFromFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	public Client getReceiver() {
		return receiver;
	}

	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public boolean isInterna() {
		return interna;
	}

	public void setInterna(boolean interna) {
		this.interna = interna;
	}

	public Transaction(Client receiver, Client sender, float deposit, boolean interna) {
		super();
		this.receiver = receiver;
		this.sender = sender;
		this.deposit = deposit;
		this.interna = interna;
	}

	public Transaction() {};
	
	
}
