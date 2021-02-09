package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Tasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		
		//Dinar to eur calculator		
		
		
		double dinar,exchangeRate = 123.5;
		
		System.out.print("Welcome to the convertor from dinar to euro. \nPlease input the desired amount: ");
		
		dinar = myInput.nextDouble();
		
		System.out.println("You have selected to convert " + df.format(dinar) + " dinars to euros.\nThe current exchange rate is " + exchangeRate);
		
		System.out.print("Your converted sum is: " + df.format(dinar / exchangeRate) + "EUR");
		myInput.close();
	}

}
