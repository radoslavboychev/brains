
import textio.TextIO;

public class ArrayManipulationCustom {

	public static void main(String[] args) {
		// TODO Method to create an array

		// TODO Method to count the amount of elements in an array

		// TODO Method to populate an array with user input

		// TODO Method to print an array

		// TODO Method to count the amount of times a number occurs in an array
		int[] anArray = createArray(10);

	}

	static int[] createArray(int numElements) {
		int i = 0;
		System.out.print("Amount elements: ");
		numElements = TextIO.getlnInt();
		int[] myArray = new int[numElements];

		for (i = 0; i < myArray[numElements - 1]; i++) {
			myArray[i] = TextIO.getlnInt();
		}
		System.out.print("Elements: ");
		for (i = 0; i < myArray[numElements - 1]; i++) {
			System.out.print(myArray[i]);
		}
		return myArray;
	}

//	 static int[] createArray(int n) {	//creating an array and populating it by selecting 
//
//			int i = 0;		//create the counter
//			int[] myArray = new int[n];		//create a new array with the n as the amount of elements 
//
//			System.out.print("Input " + n + " elements of the array: ");
//
//			for (i = 0; i < myArray[n-1]; i++) {
//				System.out.println("Input " + (n+1) + " element of the array: ");
//				myArray[n] = TextIO.getlnInt();
//			}
//			return myArray;
//		}

}
