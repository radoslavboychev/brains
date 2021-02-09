package javaclass2;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
	Scanner myInput = new Scanner(System.in);
	
	double a,b;
	
	System.out.println("Welcome to this calculator app!\nThis application calculates the sum,subtraction,multiplication and division of 2 numbers\nPlease input your two numbers (a and b)");
		
	System.out.print("a = ");
	a = myInput.nextDouble();
	
	System.out.print("b = ");
	b = myInput.nextDouble();
	
	System.out.println("\nThe sum of these numbers is: " + (a+b));
	System.out.println("\nThe subtraction of these numbers is: " + (a-b));
	System.out.println("\nThe multiplication of these numbers is: " + (a*b));
	System.out.println("\nThe division of these numbers is: " + (a/b));
	myInput.close();
	
	}
}