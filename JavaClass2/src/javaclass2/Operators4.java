package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Operators4 {

	public static void main(String[] args) {
		
		/*
		 * Write a program that calculates the area 
		 * of ​​a roller withradius ri height H (A = 2 * r * (r + H) * PI)
		 */
		Scanner userInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.000");
		double r,H;
		
		System.out.print("Insert radius r: ");
		r = userInput.nextDouble();
		
		System.out.print("Insert height H: ");
		H = userInput.nextDouble();
		
		double A = 2 * r * (r+H) * Math.PI;
		
		System.out.println("The area of a roller is: " + df.format(A));
		
		userInput.close();
	}
}
