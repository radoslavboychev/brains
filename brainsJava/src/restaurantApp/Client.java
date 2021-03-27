package restaurantApp;

public class Client {

	// For clients, they record the name, surname, address and mobile phone number.

	// variables
	private String fName;
	private String lName;
	private String address;
	private String phonenNum;

	// constructors
	public Client(String fName, String lName, String address, String phonenNum) {

		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phonenNum = phonenNum;

	}

	public Client() // default constructor
	{

	}

	// getters and setters
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenNum() {
		return phonenNum;
	}

	public void setPhonenNum(String phonenNum) {
		this.phonenNum = phonenNum;
	}

	//the client to string
	@Override
	public String toString() {
		return "Client [getfName()=" + getfName() + ", getlName()=" + getlName() + ", getAddress()=" + getAddress()
				+ ", getPhonenNum()=" + getPhonenNum() + "]";
	}
	

}
