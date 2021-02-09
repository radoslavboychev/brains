
package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Operators3 {

	public static void main(String[] args) {
		
		/*
		 * Write a program that determines the pressure of one mole
		 * (amount of gas - n)
		 *  of ideal gas p based on volume gas V and temperature T.
		 *  The pressure of the ideal gas 
		 * determines according to the following formula: p = n * R * T / V, 
		 * where R -universal gas constant and is 8.314472 J / (mol · K)
		 */
		
		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.000");
		
		double n,V,T; 
		final double R = 8.314472;
		
		System.out.print("Insert volume V: ");
		
		V = myInput.nextDouble();
		
		System.out.print("Insert temperature T: ");
		
		T = myInput.nextDouble();
		
		System.out.print("Insert amount of gas n: ");
		
		n = myInput.nextDouble();
		
		double p = (n * R * T) / V;
		
		System.out.println("The pressure of one mole is: " + df.format(p));
		
		myInput.close();
	
	}

}
