package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Operators1 {
	public static void main(String[] args) {
		
		/*
		Write a program that calculates the volume of a 
		compartment with radius ri height H (V = 1/3 * r * r * H * PI)
		*/
		
		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.000");
		
		double r,H,V;
		final double pi = 3.1415926535897932384626433;
		
		System.out.print("This program calculates the volume of a compartment."
				+ "\nPlease insert the value for radius (r): ");
		r = myInput.nextDouble();
		
		System.out.print("Now, please insert the value of the height (H): ");
		
		H = myInput.nextDouble();
		
		V = ((r*r)*H*pi)/3;
		
		System.out.println("The volume of the compartment is: " + df.format(V));
		
		myInput.close();
	}
	
	
}
