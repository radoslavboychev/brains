package arrays;

import java.util.Iterator;

public class IntroductionToArrays {

	public static void main(String[] args) {

		//declaring an array
		int[] myArray;
		
		//allocating memory for an array
		myArray = new int [20];
		
		myArray[0] = 1;
		//initializing elements
//		myArray[0] = 1;
//		myArray[1] = 2;
//		myArray[2] = 3;
		
		for(int i=0;i< myArray.length;i++)
		{
			myArray[i+1] = myArray[i] + 1; 
			System.out.println(myArray[i]);
		}
	}

}
