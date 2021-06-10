package javaclass2;

import java.util.Scanner;

import java.text.DecimalFormat;

public class QuadraticEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Quadratic equation:
		 * 
		 * x = (-b +- Sqrt(b^2 - 4ac)) / 2a
		 * 
		 * b^2 - 4ac is also known as the discriminant; there are cases where it is
		 * negative or 0; we need to include those cases
		 * 
		 * If the discriminant is: positive, there are 2 real solutions zero, there is
		 * one real solution negative, there are no real solutions
		 */

		DecimalFormat df = new DecimalFormat("0.000"); // a decimal formatter so we don't get super large numbers;
		Scanner myInput = new Scanner(System.in);

		double a, b, c, d = 0; // a,b,c are the coefficients
								// d is the discriminant

		double x1, x2 = 0; // these are the roots, 2 of them at most because we have +- in the equation

		// Start by providing the user with information and input:

		System.out.println(
				"====================================\nQuadratic Equation Calculator\n====================================\n");
		System.out.println("Welcome to this calculator. Please select an option to continue:\n");

		try {

			while (true) { // while is used so the program will restart after calculating the equation is
							// done and the user decides to calculate again

				int choice;

				System.out.println("1. Calculate a quadratic equation ");
				System.out.println("2. Exit program\n");
				System.out.print("Please insert your choice: ");

				choice = myInput.nextInt();

				switch (choice) {
				case 1:

					System.out.print("Please input the value of a: "); // initializing a
					a = myInput.nextDouble();

					System.out.print("Now, please input the value of b: "); // initializing b
					b = myInput.nextDouble();

					System.out.print("Finally, please insert the value of c: "); // initializing c
					c = myInput.nextDouble();

					d = (Math.pow(b, 2) - 4 * a * c); // calculating the discriminant

					System.out.println(
							"The discriminant of the numbers " + a + ", " + b + " and " + c + " is " + ": " + d + "\n");

					if (d < 0) // if it's <0 there's no real solution
					{
						System.out.println("The discriminant is less than 0. This equation has no real solutions. ");
					} else if (d == 0) // if it's exactly 0 there's only 1 real solution
					{
						System.out.println("The discriminant is 0. There is only 1 real solution.");
						x1 = (-b + Math.sqrt(d)) / (2 * a);
						System.out.print("The solution X to this equation is: " + df.format(x1));
					} else if (d > 0) // if its bigger than 0 there are 2 solutions
					{
						System.out.println(
								"The discriminant is bigger than 0. There will be 2 solutions to this equation");

						x1 = (-b + Math.sqrt(d)) / (2 * a);

						x2 = (-b - Math.sqrt(d)) / (2 * a);

						System.out.println(
								"The solutions to this equation x1 = " + df.format(x1) + ",x2 = " + df.format(x2));
					}

					System.out.println(
							"\nThe calculator has now finished. Please select your choice\n====================================");

					break; // closing the case; if the user keeps pressing 1 the program will restart
							// (because of the while);

				case 2: {
					System.out.println(
							"Thank you for using this quadratic equation calculator. The program will now exit");
					myInput.close();
					return; // if the user wants to exit we just turn off the program at this point

				}

				default:
					System.out.println("Invalid choice. Please try again."); // if the user selects anything else than 1
																				// or 2
					break;
				}
			}
		} catch (java.util.InputMismatchException e) { // this is what happens when a user inputs anything that's not a
														// number
			System.out.println("Wrong format.Try again.");
			return; // we turn off the program because i don't know how to make it go back to the
					// start -_-
		}

	}

}
