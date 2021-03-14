package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import fileHandling.fileInformation;

public class QuadraticFunction implements Function {

	double a, b, c, D;
	double x1, x2;

	public static void main(String[] args) {

	}

//this will read from the file and convert the data (string) to double ((allegedly))
	@Override
	public void readFromFile(BufferedReader data) {

		try {
			System.out.println("Reading parameters from file...");
			a = Double.parseDouble(data.readLine());
			System.out.println("A = " + a);
			b = Double.parseDouble(data.readLine());
			System.out.println("B = " + b);
			c = Double.parseDouble(data.readLine());
			System.out.println("C = " + c);

		} catch (NumberFormatException e) {
			System.out.println("Data is in an invalid format!");
			e.getMessage();

			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error has occurred!");
			e.getMessage();
			e.printStackTrace();
		}

	}

//calculates the descriminant
	@Override
	public void calculateValue() {

		D = Math.pow(b, 2) - 4 * a * c;
		System.out.println("D = " + D);

	}

	// checks if D is less or 0 (or >0)
	@Override
	public void checkRealSolution() {

		if (D < 0) {
			System.out.println("D is = " + D + ". There is no real solution");
		} else if (D == 0) {
			System.out.println("D is = " + D + ". There is only 1 solution");
		} else if (D > 0) {
			System.out.println("D is = " + D + ". There are 2 real solutions");
		} else {
			System.out.println("Error?");
		}

	}

	// makes the calculations
	@Override
	public void findSolution() {

		if (D > 0) {

			x1 = (-b + Math.sqrt(D)) / (2 * a);
			System.out.println("x1 = " + x1);
			
			x2 = (-b - Math.sqrt(D)) / (2 * a);
			System.out.println("x2 = " + x2);
		}
		else if (D == 0) {
			
			x1 = (-b + Math.sqrt(D)) / (2 * a);
			System.out.println("x1 = " + x1);	
		}

	}

	@Override
	public void printSolution(BufferedWriter writer) {
		
		try {
			writer.write(String.format("%.2f", x1));
			writer.newLine();
			writer.write("x2 = " + x2);
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Error!");
				e.printStackTrace();
			}
		};

	}

}
