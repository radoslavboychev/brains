package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LinearFunction implements Function {

	FileReader input = null;
	BufferedReader buffInput = null;
	FileWriter output = null;
	BufferedWriter buffOutput = null;

	// y = ax+b

	double a, b, y, x;

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

		y = (a * x) + b;
		System.out.println(y);

	}

	@Override
	public void checkRealSolution() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findSolution() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printSolution(BufferedWriter bfLinear) {
		// TODO Auto-generated method stub

	}

}
