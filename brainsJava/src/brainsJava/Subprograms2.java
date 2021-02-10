package brainsJava;

import java.util.Scanner;

public class Subprograms2 {

	public static void main(String[] args) {

		double op1 = 0, op2 = 0;

		double sum = 0, dif = 0, prod = 0, div = 0;
		System.out.println("-=- Calculator -=-");
		op1 = inputOp("Enter op1: ");
		op2 = inputOp("Input op2: ");
		
		sum = op1 + op2;
		dif = op1 - op2;
		prod = op1 * op2;
		div = op1/op2;
		
		System.out.println("Sum is: " + sum);
		System.out.println("Dif is: " + dif);
		System.out.println("Prod is: " + prod);
		System.out.println("Div is: " + div);
		
	}

	static double inputOp(String message) {
		Scanner myScanner = new Scanner(System.in);
		double op = 0.0;
		System.out.println(message);
		op = myScanner.nextDouble();
		myScanner.close();
		return op;
		
	}

}
