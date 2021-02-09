package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Operators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.000");
		
	/*  
	 * Write a program that calculates the resistance of copperconductor of 
	 * length l, diameter d. Specific resistancecopper 
	 * is 1,588 * 10-8 (R = RCu * 4 * l / (d * d * 3.14))
	 */

		final double RCu = Math.pow(1588, -8);
		double l,d; //length and diameter;
		
		System.out.print("Please insert the value of the length: ");
		
		l = myInput.nextDouble();
		
		System.out.print("Please insert the value of the diameter: ");
		
		d = myInput.nextDouble();
		
		double R = ((RCu * 4 * l) / (Math.pow(d, 2) * Math.PI));
		
		System.out.println("The resistance is: " + R);
		
		myInput.close();
		
	}

}
