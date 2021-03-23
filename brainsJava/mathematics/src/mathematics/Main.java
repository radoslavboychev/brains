package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* Create an interface "Function" which contains 5 methods:
 * 1. Read parameters from file
 * 
 * 2. Calculate the value of the function
 * 
 * 3. Check for real answers
 * 
 * 4. Calculate real answers
 * 
 * 5. Output answers to file
 * 
 * Two more classes: 
 * 
 * 1. LinearFunction 
 * 		
 * 	y = mx+b
 * 
 * 2. Quadratic function
 * 
 * 	y = ax^2+bx+c
 * 
 */

public class Main {

	public static void main(String[] args) throws IOException {

		// run the menu
		menu();

	}

	// this is just a separate method that prints the menu text to the menu
	public static void menuText() {
		System.out.println("Choose a function: ");
		System.out.println("1. Calculate a quadratic equation");
		System.out.println("2. Calculate a linear equation");
		System.out.println("0. Exit program");

	}

	// this is for the menu
	private static int choice;

	public static void menu() {

		try {

			Scanner myScanner = new Scanner(System.in);

			boolean keepGoing = true;
			// keep showing the menu until the user presses 0
			while (keepGoing) {

				// print the menu text
				menuText();

				// get the user input
				System.out.print("\nYour choice: ");
				choice = myScanner.nextInt();

				switch (choice) {
				case 1:
					runQuadratic();
					break;
				case 2:
					runLinear();
					break;
				case 0:
					keepGoing = false;
					break;
				default:
					break;
				}

			}
			myScanner.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Wrong input format (integers only)");
		}

	}

	// this runs everything for the quadratic function
	public static void runQuadratic() {
		// create the readers; set the directory
		FileReader inputQuadratic = null;
		try {
			inputQuadratic = new FileReader("dataQuadratic.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}

		FileWriter outputQuadratic = null;
		try {
			outputQuadratic = new FileWriter(
					"outputQuadratic.txt");
		} catch (IOException e) {
			System.out.println("An error has occurred!");
			e.printStackTrace();
		}
		// create the function
		QuadraticFunction quadraticFunction = new QuadraticFunction();
		BufferedReader brQuadratic = new BufferedReader(inputQuadratic);
		BufferedWriter bfQuadratic = new BufferedWriter(outputQuadratic);

		// execute the methods for the quadratic function
		quadraticFunction.readFromFile(brQuadratic);
		quadraticFunction.calculateValue();
		quadraticFunction.checkRealSolution();
		quadraticFunction.findSolution();
		quadraticFunction.printSolution(bfQuadratic);
	}

	// this runs the whole program for linear equation and all the methods
	public static void runLinear() {
		FileReader inputLinear = null;
		try {
			inputLinear = new FileReader("dataLinear.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}

		// create the function
		LinearFunction linearFunction = new LinearFunction();
		BufferedReader brLinear = new BufferedReader(inputLinear);
		
		FileWriter outputLinear = null;
		try {
			outputLinear = new FileWriter("outputLinear.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bwLinear = new BufferedWriter(outputLinear);
		// same methods for the linear
		linearFunction.readFromFile(brLinear);
		linearFunction.calculateValue();
		linearFunction.checkRealSolution();
		linearFunction.findSolution();
		linearFunction.printSolution(bwLinear);
	}

}