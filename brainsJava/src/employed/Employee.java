package employed;

public class Employee {

	String fName, lName;
	double coef, pay;

	Employee() {
		// TODO Auto-generated constructor stub
	}

	Employee(String fName, String lName, double coef) {
		this.fName = fName;
		this.lName = lName;
		this.coef = coef;

	}

	void calculatePay(int days) {
		pay = coef * days * 100;
	}

	void printPay() {
		System.out.println(
				"Employee: " + fName + " " + lName + " with coefficient " + coef + " has a pay of " + pay + " dollars.");

	}

}
