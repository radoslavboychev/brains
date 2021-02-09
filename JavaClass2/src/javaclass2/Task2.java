package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		//Initialize km, liters, and also current consumption and current liters;
		// the current values are preset to respectively 350km and 17 liters but ill
		//make it more flexible;
		
			double km,currentCon,currentLiter;
		
		
		System.out.println("Welcome to this program. It calculates fuel consumption");
		System.out.print("Please insert the current values for kilometers traveled: ");
		
			currentCon = myInput.nextDouble();
		
		System.out.print("Now, please input the value for liters spent: ");
		
			currentLiter = myInput.nextDouble();
		
		System.out.println("The current fuel consumption per " + currentCon + " km is " + currentLiter +  " liters.");
		
			double consumption = currentLiter/currentCon;
		
		System.out.println("Therefore, the consumption rate per km is: " + df.format(consumption) + " liters/km");
		
		System.out.println("\nWith this consumption rate, you can calculate the consumption for any distance!");
		System.out.print("Please input the kilometers traveled: ");
		
			km = myInput.nextDouble();
			
		System.out.println("\nThe consumption for " + km + " kms is " + df.format(km*consumption) + " liters");
		
		myInput.close();
	}

}
