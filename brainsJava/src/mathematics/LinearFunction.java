package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import textio.TextIO;

public class LinearFunction implements Function {

	private double a, b, x, y;

	
	//constructors
	public LinearFunction(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public LinearFunction() {

	}

	// read from the file
	@Override
	public void readFromFile(BufferedReader data) {
		try {
			System.out.println("Reading parameters from file...");
			a = Double.parseDouble(data.readLine());
			System.out.println("A = " + a);
			b = Double.parseDouble(data.readLine());
			System.out.println("B = " + b);

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

	@Override
	public void calculateValue() {

		/*
		 * this is probably not the way that's expected to be done in the exercise but I
		 * couldn't come up with a good way of calculating an y = mx + b without using
		 * slopes and intercept tables and so on
		 * 
		 */

		System.out.print("Insert the value of x: ");
		x = TextIO.getlnDouble();

	}

	@Override
	public void checkRealSolution() {

		y = (a * x) + b;

	}

	@Override
	public void findSolution() {

	}

	// this prints the solution to the file
	@Override
	public void printSolution(BufferedWriter bfLinear) {

		try {
			bfLinear.write("a =  " + getA());
			bfLinear.newLine();
			bfLinear.write("b = " + getB());
			bfLinear.newLine();
			bfLinear.write("x = " + x);
			bfLinear.newLine();
			bfLinear.write("y = " + y);
			System.out.println("File Writing Complete!");
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			try {
				bfLinear.close();
			} catch (IOException e) {
				System.out.println("Error!");
				e.printStackTrace();
			}
		}

	}

	// getters setters etc
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

}
