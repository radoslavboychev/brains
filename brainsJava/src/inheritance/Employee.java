package inheritance;

public class Employee extends Person {

	private double coef;
	private double salary;

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();

	}

	public Employee(String name, String surname, int age, double coef, double salary) {
		super(name, surname, age);

		this.coef = coef;
		this.salary = salary;
	}

	public void calculateSalary(int days) {
		salary  = coef*days;
	}
	public void printPay()
	{
		System.out.println("Hello, my name is " + getName() + " " + getSurname() + " my coefficient is " + getCoef() + " and my pay is " + getSalary());
	}

}
