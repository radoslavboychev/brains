import java.util.Scanner;

public class arraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[10];
		int sum = 0;

		Scanner myScanner = new Scanner(System.in);

		for (int i = 0; i < array.length; i++) {

			System.out.print("Element " + i + " is: ");
			array[i] = myScanner.nextInt();
			sum += array[i];

		}
		System.out.print("Sum is: " + sum);
		myScanner.close();
	}

}
