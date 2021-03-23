package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class QuadraticFunction implements Function {

	private double a, b, c, D;
	private double x1, x2;

	public static void main(String[] args) {

	}

	// constructors
	public QuadraticFunction(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public QuadraticFunction() {

	}

	// some getters and setters
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	// this will read from the file and convert the data (string) to double
	// ((allegedly))
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

//calculates the discriminant
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
		} else if (D == 0) {

			x1 = (-b + Math.sqrt(D)) / (2 * a);
			System.out.println("x1 = " + x1);
		}

	}

	// outputs the results from the different cases in a text file
	@Override
	public void printSolution(BufferedWriter writer) {

		try {

			// print no answer if D<0
			if (D < 0) {

				writer.write("--- The results of the Quadratic Equation ---\n");
				writer.write("The parameters were a = " + a + ", b = " + b + ", and c = " + c);
				writer.write("The discriminant is: " + D);
				writer.write("D < 0, therefore there are no real solutions");

			}
			// print only this if D>0
			else if (D > 0) {

				writer.write("--- The results of the Quadratic Equation ---\n");
				writer.write("The discriminant is: " + D);
				writer.newLine();
				writer.write("x1 = " + x1);
				writer.newLine();
				writer.write("x2 = " + x2);

			} else if (D == 0) {

				writer.write("--- The results of the Quadratic Equation ---\n");
				writer.write("The discriminant is: " + D);
				writer.newLine();
				writer.write("x1 = " + x1);
				writer.newLine();
				writer.write("x2 = " + x2);
			}

		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Error!");
				e.printStackTrace();
			}

		}
		;

	}

}
