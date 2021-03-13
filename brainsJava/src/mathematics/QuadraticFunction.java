package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class QuadraticFunction implements Function {

	double a, b, c, D;
	double x1, x2;

	public static void main(String[] args) {

	}

//this will read from the file and convert the data (string) to double ((allegedly))
	@Override
	public void readFromFile(BufferedReader data) {

		try {
			a = Double.parseDouble(data.readLine());
			b = Double.parseDouble(data.readLine());
			c = Double.parseDouble(data.readLine());

		} catch (NumberFormatException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
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

			x1 = (-b + Math.sqrt(D)) / 2 * a;
			System.out.println("x1 = " + x1);
			
			x2 = (-b - Math.sqrt(D)) / 2 * a;
			System.out.println("x2 = " + x2);
		}
		else if (D == 0) {
			
			x1 = (-b + Math.sqrt(D)) / 2 * a;
			System.out.println("x1 = " + x1);	
		}

	}

	@Override
	public void printSolution() {
		

	}

}
