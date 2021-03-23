package ExamPrep;

public class examPrep02 {

	public static void main(String[] args) {

		int a = 6, b = 5, c = 5;

		// Use else if to specify a new condition to test,
		// if the first condition is false

		if (a > 5) {
			c = a + b;
			System.out.println("c = a+b");
		} else if (a < 0) {
			c = a - b;
			System.out.println("c = a-b");
		} else {
			System.out.println("C is neither");
		}

	}

}
