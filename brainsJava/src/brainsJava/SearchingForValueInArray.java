package brainsJava;

import java.util.Scanner;

public class SearchingForValueInArray {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);

		final int maxElement = 20; // declare max amount of elements in an array

		int[] myArray = new int[maxElement]; // create array and set max elements

		int countElement = 0; // amounts of rows and columns
		int i, howMany = 0;		//i is the counter; howMany is the number of occurrences of the number
		int numberWeLookFor;		//this is the number we're looking for
		int[] elementIndex = new int[maxElement];	//the index at which the number we're looking for occurs

		System.out.println("Program for searching a string of natural numbers");
		System.out.print("Input max amount of elements: ");

		countElement = myScanner.nextInt(); // max amount of elements

		for (int j = 0; j < countElement; j++) {	//inputting every element of our array with numbers
			System.out.print("Input value of element: ");
			myArray[j] = myScanner.nextInt(); // input every element

		}
		System.out.println();
		System.out.println();
		System.out.print("Enter a number to search for in the array: "); //now we look for the number we want
		numberWeLookFor = myScanner.nextInt();	//input the number we want

		for (i = 0; i < countElement; i++) {		
			if (numberWeLookFor == myArray[i]) {		//if the number we're looking for matches the value of an array
				elementIndex[howMany++] = i;			//we increase the counter
			}
		}
		System.out.println();
		System.out.println();

		System.out.print("The elements of the array are: ");	//printing out all of the elements
		System.out.print("{");
		for (i = 0; i < countElement; i++) {
			System.out.print(myArray[i]);
		}
		System.out.println("}");		
		System.out.println("The number " + numberWeLookFor + " is in the array " + howMany + " time(s)");	//the number and how many times it occurs

		System.out.print("The number is on the following position(s): ");	//the indices the number is at
		System.out.print("[");
		for (i = 0; i < howMany; i++) {
			System.out.print(elementIndex[i] + 1); //+1 because array starts from 0
		}
		System.out.print("]");
		myScanner.close();
	}
	
}