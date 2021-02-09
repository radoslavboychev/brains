import java.util.Scanner;

public class averageArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myInput = new Scanner(System.in);
		double avg = 0;
		int sum = 0;
		int[] array = new int[10];

		for (int i = 0; i < array.length; i++) {

			System.out.print("Element " + i + " is: ");
			array[i] = myInput.nextInt();
			sum += array[i];
			avg = sum / array.length;

		}
		System.out.println("Average is: " + avg + " and the sum is " + sum);

		myInput.close();
	}
	
}
