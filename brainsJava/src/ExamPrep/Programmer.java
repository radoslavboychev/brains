package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class Programmer extends Person implements Iterator {

	private String experience;
	private double salary;

	//constructor
	public Programmer(String name, String surname, int age, String experience, double salary) {
		super(name, surname, age);
		this.experience = experience;
		this.salary = salary;
	}

	//getters and setters
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
