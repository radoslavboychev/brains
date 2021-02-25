package basketballTeams;

import textio.TextIO;

public class Person {

	
	private String fName;
	private String lName;
	private int age;
	
	
	//default constructor
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String fName,String lName,int age)
	{
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	
	//tostring
	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}

	//getters and setters
	public String getfName() {
		return fName;
	}
	//getters and setters
	public void setfName() {
		
		System.out.print("First name: ");
		this.fName = TextIO.getlnString();
	}
	//getters and setters
	public String getlName() {
		return lName;
	}
	//getters and setters
	public void setlName() {
		
		System.out.print("Last name: ");
		this.lName = TextIO.getlnString();
	}
	//getters and setters
	public int getAge() {
		return age;
	}
	//getters and setters
	public void setAge() {
		
		System.out.print("Age:");
		this.age = TextIO.getlnInt();
	}
	
	
}
