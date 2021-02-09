package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class VolumeAndAreaOfCircle {

	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		double r,O,P;
		
		System.out.print("Please insert value for the radius r: ");
		
		r = myInput.nextFloat();
		
		P = Math.pow(r, 2) * Math.PI;
		
		System.out.println("The area of the circle is:  " + df.format(P));
		
		O = 2*r*Math.PI;
		
		System.out.print("The volume of the circle is: " + df.format(O));
		
		myInput.close();
	}

}
