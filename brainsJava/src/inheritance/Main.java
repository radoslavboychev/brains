package inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person("John", "Davis", 24);
		p.introduceYourself();
		
		Employee e = new Employee("Jill", "Clinton", 44, 4.5, 0);
		e.calculateSalary(30);
		e.printPay();
		
	}

}
