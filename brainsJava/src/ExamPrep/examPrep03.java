package ExamPrep;

public class examPrep03 {

	public static void main(String[] args) {

		int a, b;
		a = 5;
		b = 3;
		b = 3 * a + a - 3;
		for (int i = a; i <= b; i++) {
			if (i % 2 != 0)
				continue;

			System.out.println("Q");
		}
		
		//answer:6

	}

}
