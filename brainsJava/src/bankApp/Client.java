package bankApp;

public class Client {

	private String firstName;
	private String lastName;
	private String idNum;
	private Computer pcNumber;

	public Client(String firstName, String lastName, String idNum, Computer pcNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNum = idNum;
		this.pcNumber = new Computer(150, false, "EUR");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public Computer getPcNumber() {
		return pcNumber;
	}

	public void setPcNumber(Computer pcNumber) {
		this.pcNumber = pcNumber;
	}

}
