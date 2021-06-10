package co.eureka;

import java.util.Arrays;
import java.util.Scanner;
public class HomeworkArray {

	public static void main(String[] args) {
		
		//creating the scanner object for user inputs
		
		Scanner myInput = new Scanner(System.in);
		
		
		System.out.print("Insert max amount of elements: ");
	    
		//define n=0; n is the amount of elements in the array
		int n=0;  
		
		try
		{	//user inputs the max amount of elements in array
			n = myInput.nextInt();
			while(n<2) //need to check if max elements are more than 2, otherwise they need to input again
			{
				System.out.print("Minimum amount of elements is 2 ! \nPlease, try again: ");
				n = myInput.nextInt();
			}
		} //catching the exception if the user inputs a string instead of a number, and end the program
		catch (java.util.InputMismatchException e) 
		{
				System.out.println("Please input an integer, the program will now close");
				return;
		}
		// creating the fibonacci array with the n amount of elements
		
		int[] fibonacci = new int[n];
		
		// user inputs the values for the first 2 (index 0 and 1) elements
		
		System.out.print("Insert element in position 0: ");
		fibonacci[0] = myInput.nextInt();
		
		System.out.print("Insert element in position 1: ");
		fibonacci[1] = myInput.nextInt();
		/* 
		 * for loop - semantics: starting from index 2, we go through each element until the n value
		 which is n in the case, increasing the index by 1 each time; the current index is created by the values of the sum
		 of the 2 indices before that [(i-1) + (i-2)];
		then we print the whole array in an efficient way with only 1 line of text
		*/
		for(int i=2; i<n; i++)
		{
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}	
		System.out.println("Your Fibonacci sequence is " + Arrays.toString(fibonacci));
	}
}
