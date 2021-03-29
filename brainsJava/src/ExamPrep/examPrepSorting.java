package ExamPrep;

import java.util.Scanner;

public class examPrepSorting {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		int tmp, i, j;

		

		System.out.print("Max number of elements: ");
		final int arrayLimit = myScanner.nextInt();
		int[] myArray = new int[arrayLimit];

		for (i = 0; i < arrayLimit; i++) // input the elements in an array
		{
			System.out.print("Insert element " + (i + 1) + ": ");
			myArray[i] = myScanner.nextInt();
		}

		System.out.println("]");

		for (i = 0; i < arrayLimit - 1; i++) {
			for (j = i + 1; j < arrayLimit; j++) {
				if (myArray[i] > myArray[j]) {
					tmp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = tmp;
				}
			}
		}
		System.out.println();
		System.out.println();

		System.out.print("Elements of the array after sorting are: ["); // present the elements after sorting
		for (i = 0; i < arrayLimit; i++) {
			System.out.print(" " + myArray[i]);
		}
		System.out.println("]");

		myScanner.close();

	}

}
