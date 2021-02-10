package brainsJava;

import textio.TextIO;

public class MethodsToManipulateArrays {
	public static void main(String[] args) {

//		int arraySize;
//		int[] myArray;
//
//		arraySize = inputArrayFromUser("Input array: ");
//
//		myArray = createArray(arraySize);
//
//		printArray(myArray);
//
//		fillArray(10, myArray);
		createArray(5);

	}

	static int inputArraySizeFromUser(String message) { // input the size of an array from the user

		int value;
		System.out.println(message);
		value = TextIO.getlnInt();
		return value;
	}

	static int[] createArray(int n) {	//creating an array and populating it by selecting 

		int i = 0;		//create the counter
		int[] myArray = new int[n];	//create a new array with the n as the amount of elements 

		System.out.print("Input " + n + " elements of the array: ");

		for (i = 0; i < myArray[n-1]; i++) {
			System.out.println("Input " + (n+1) + " element of the array: ");
			myArray[n] = TextIO.getlnInt();
		}
		return myArray;
	}

	static void printArray(int[] pArray) {
		int i;
		System.out.println("[");
		for (i = 0; i < pArray.length - 1; i++) {
			System.out.println(pArray[i] + ",");
		}
		System.out.println(pArray[i] + "]");
	}

	static void fillArray(int n, int[] pArray) {

		int i = 0;
		System.out.println("Input" + n + " element of the array: ");
		System.out.println();
		for (i = 0; i < pArray.length; i++) {
			System.out.println("");
			pArray[i] = TextIO.getlnInt();
		}

	}

}
