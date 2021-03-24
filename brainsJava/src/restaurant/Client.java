package restaurant;

public class Client {

	//fields
	private String fName;
	private String lName;
	private String adress;
	private String phoneNum;

	//constructor
	public Client(String fName, String lName, String adress, String phoneNum) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.adress = adress;
		this.phoneNum = phoneNum;
	}
	
	//default constructor
	public Client()
	{
		
	}
	
	//getters & setters
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	
	
	
	


}
