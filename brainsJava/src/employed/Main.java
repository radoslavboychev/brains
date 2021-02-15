package employed;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee("John", "Wick", 3);
		Employee e2 = new Employee("Don", "Dick", 5);
		Employee e3 = new Employee("Wong", "Mick", 7);
		
		e1.calculatePay(30);
		e2.calculatePay(60);
		e3.calculatePay(100);
		
		e1.printPay();
		e2.printPay();
		e3.printPay();
		
		
	}

}
