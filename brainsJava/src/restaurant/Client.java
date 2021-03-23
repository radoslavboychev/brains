package restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Client implements WorkWithFiles, ClientList{

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
	
	//reading the client info from the file
	@Override
	public void loadFromFile(BufferedReader br) {
		
		try {
			setfName(br.readLine());
			setlName(br.readLine());
			setAdress(br.readLine());
			setPhoneNum(br.readLine());
			
		} catch (IOException e) {
			System.out.println("An error has occurred!");
			e.printStackTrace();
		}
	}
	@Override
	public void writeToFile(BufferedWriter bw) {
		
		
	}

	

	@Override
	public void addToList(Client c, ArrayList<Client> a) {
		
		a.add(c);
		
	}
	@Override
	public void removeFromList(Client c, ArrayList<Client> a) {
		
		a.remove(c);
	}
	@Override
	public void searchForClient(Client c, ArrayList<Client> a) {
		// TODO 
		
	}

	
	


}
