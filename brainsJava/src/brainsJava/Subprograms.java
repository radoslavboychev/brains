package brainsJava;

import java.util.Scanner;

public class Subprograms {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		double a, b;
		int choice;
		String menuConsole;
		System.out.print("Welcome to this calculator. Select a function: ");

		menuConsole = ("--- MENU --- \nPress 1 for addition" + "\nPress 2 for subtraction"
				+ "\nPress 3 for multiplication" + "\nPress 4 for division" + "\nPress 5 to exit" + "\nYour choice: ");

		do {
			System.out.print(menuConsole);
			choice = myScanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.print("--- SUM---\nPlease insert 2 numbers: ");
				a = myScanner.nextDouble();
				b = myScanner.nextDouble();
				System.out.println("The sum of the numbers is: " + Sum(a, b));
				break;
			}
			case 2: {
				System.out.print("--- SUBTRACTION---\nPlease insert 2 numbers: ");
				a = myScanner.nextDouble();
				b = myScanner.nextDouble();
				System.out.println("The subtraction of the numbers is: " + Sub(a, b));
				break;
			}
			case 3: {
				System.out.print("--- MULTIPLICATION---\nPlease insert 2 numbers: ");
				a = myScanner.nextDouble();
				b = myScanner.nextDouble();
				System.out.println("The multiplication of the numbers is: " + Mul(a, b));
				break;
			}
			case 4: {
				System.out.print("--- DIVISION---\nPlease insert 2 numbers: ");
				a = myScanner.nextDouble();
				b = myScanner.nextDouble();
				System.out.println("The division of the numbers is: " + Div(a, b));
				break;
			}
			case 5: {
				choice = 0;
			}

			default:
				break;
			}

		} while (choice == 1);
		myScanner.close();
	}

	static double Sum(double a, double b) {
		return a + b;
	}

	static double Sub(double a, double b) {
		return a - b;
	}

	static double Mul(double a, double b) {
		return a * b;
	}

	static double Div(double a, double b) {
		if (a > 0 && b > 0) {
			return a / b;
		} else {
			return 0;
		}
	}

}
