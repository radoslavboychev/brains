package brainsJava;

import textio.TextIO;

public class Homework3 {

	static final int branches = 10;
	static final int month = 12;

	public static void main(String[] args) {

		/*
		 * Program for monitoring the bank's annual operations // The bank operates in
		 * the city through 10 branches and its income is recorded for each month. //
		 * The program should enable:
		 * 
		 * // 1) Enter the realized income for the given branch and month.
		 * 
		 * 2) Change in the realized income for the given branch and month.
		 * 
		 * // 3) Display of monthly revenues for the selected branch.
		 * 
		 * // 4) Presentation of revenues of individual branches for the selected month
		 * 
		 * // 5) Calculation and presentation of the month in which the total income is
		 * the largest and how much it amounts to.
		 * 
		 * // 6) Calculation and presentation of total annual income.
		 * 
		 * // 7) Calculation and presentation of average revenue for each branch.
		 * 
		 * // 8) Menu from which the offered functions are selected. // Be sure to use
		 * the features to implement the required functionalities. Select the correct
		 * data types and data structures and limit the input so that incorrect values
		 * ​​cannot be entered
		 */

		int option = 0;

		double[][] BankBranch = new double[branches][month]; // create the bank branches with 30 days

		// sets all the elements to 0 instead of null
		setToZero(BankBranch);

		System.out.println("");

		// switch for the menu

		do {

			showMenu(); // displays the menu

			option = inputValues("", "Invalid selection", -1, 10); // i put -1 as the min because id like to use 0
																	// instead of 10 for the last case so user doesnt
																	// have to type 10, but 0 instead

			switch (option) {
			case 1: {
				inputValues(BankBranch); // insert values for selected branch

			}
				break;
			case 2: {
				changeValues(BankBranch); // edit values for selected branch

			}
				break;
			case 3: {
				printMatrix(BankBranch); // print table of branches and revenue

			}
				break;
			case 4: {
				revenuePerBranch(BankBranch); // prints revenue per branch

			}
				break;
			case 5: {
				totalRevenue(BankBranch); // print total revenue of branches

			}
				break;
			case 6: {
				revenuePerMonth(BankBranch); // prints revenue per month

			}
				break;

			case 7: {
				avgRevenuePerMonth(BankBranch); // prints average revenue per month

			}
				break;
			case 8: {
				avgRevenuePerBranch(BankBranch); // prints average revenue per branch
			}
				break;
			case 9: {
				biggestTotalRevenue(BankBranch); // prints biggest revenue and the month it was made
			}
				break;

			case 0: {
				exitProgram();
				// option = 10; // end.
			}
			default:
				break;
			}
		} while (option != 0); // end switch, exit program
	}

	// displays the menu
	static void showMenu() {

		System.out.println("--- Bank Branch Software ---\n\nPlease select your option:\n");

		System.out.println("1.Enter data for branch");
		System.out.println("2.Edit data for branch");
		System.out.println("3.Display revenue for branches");
		System.out.println("4.Show revenue per branch");
		System.out.println("5.Show total annual income");
		System.out.println("6.Show revenue per month");
		System.out.println("7.Show average revenue per month");
		System.out.println("8.Show average revenue per branch");
		System.out.println("9.Show biggest total revenue, the branch and the month when it was generated");
		System.out.println("0.Exit program");
		System.out.println("");

		System.out.print("Your choice: ");
	}

	// this manages the input selection for every input
	static int inputValues(String message, String error, int minValue, int maxValue) { // message is the message you'll
																						// get, error is if the input is
																						// wrong, minValue is the least
																						// you can enter, max is the
																						// most
		int option = 0;
		do {
			System.out.print(message);
			option = TextIO.getlnInt();

			if ((option < minValue) || (option > maxValue)) {
				System.out.print(error);
			}

		} while ((option < minValue) || (option > maxValue));
		return option;
	}

	// this will be inputing the values
	static void inputValues(double[][] bankBranch) {
		int branch = 10, month = 12;
		char pick;
		do {

			branch = inputValues("Input the branch you want to insert: ", "Only values between 1 and " + branches, 1,
					10);

			month = inputValues("Input the month you want to insert: ", "Only values between 1 and " + month, 1, month);

			System.out.print("Enter the value to input on branch " + branch + " and month " + month + ": ");
			bankBranch[branch - 1][month - 1] = TextIO.getlnInt();

			System.out.println("You've added: " + bankBranch[branch - 1][month - 1]);

			System.out.println("Would you like to continue - press Y to continue and N to stop.");
			pick = TextIO.getlnChar();

		} while (pick == 'Y' || pick == 'y');
	}

	// this will be used to change the values of the matrix
	static void changeValues(double[][] bankBranch) {
		int branch = 10, month = 12;
		char pick;
		do {

			branch = inputValues("Input the branch you want to edit: ", "Only values between 1 and " + branches, 1, 10);

			month = inputValues("Input the month you want to edit: ", "Only values between 1 and " + month, 1, month);

			System.out.print("Enter the value to edit on branch " + branch + " and month " + month + ": ");
			bankBranch[branch - 1][month - 1] = TextIO.getDouble();

			System.out.println("You've added: " + bankBranch[branch - 1][month - 1]);

			System.out.println("Would you like to continue - press Y to continue and N to stop.");
			pick = TextIO.getlnChar();

		} while (pick == 'Y' || pick == 'y');
	}

	// this prints the matrix
	static void printMatrix(double[][] bankBranch) {
		System.out.println("Rows are branches, columns are months\n");

	}

	// sets all the elements to 0 instead of null
	static void setToZero(double[][] bankBranch) {
		// this sets them all to 0;

		for (int i = 0; i < bankBranch.length; i++) {
			for (int j = 0; j < bankBranch.length; j++) {
				bankBranch[i][j] = 0.0;
			}
		}
	}

	// this sums all the rows and columns to find out the total revenue of all the
	// branches
	static void totalRevenue(double[][] BankBranch) {
		int sum = 0;
		for (int i = 0; i < BankBranch.length; i++) {
			for (int j = 0; j < BankBranch.length; j++) {

				sum += BankBranch[i][j];
			}
		}
		System.out.println("The revenue for the entire year for all branches is: " + sum);
	}

	// this prints the revenue per branch (per row)
	static void revenuePerBranch(double[][] BankBranch)

	{
		int sumRows;
		int rows = BankBranch.length;
		int cols = BankBranch[0].length;
		for (int i = 0; i < rows; i++) {
			sumRows = 0;
			for (int j = 0; j < cols; j++) {

				sumRows += BankBranch[i][j];
			}
			System.out.println("Revenue for branch " + (i + 1) + " is: " + sumRows);
		}
	}

	// this prints the revenue per month (column)
	static void revenuePerMonth(double[][] BankBranch) {
		int sumCols;
		int rows = BankBranch.length;
		int cols = BankBranch[0].length;
		for (int i = 0; i < cols; i++) {
			sumCols = 0;
			for (int j = 0; j < rows; j++) {
				sumCols += BankBranch[j][i];

			}
			System.out.println("Revenue for month " + (i + 1) + " is " + sumCols);
		}

	}

	// this basically takes the revenue per month and divides by the total number of
	// months
	static void avgRevenuePerMonth(double[][] BankBranch) {
		int sumCols;
		int rows = BankBranch.length;
		int cols = BankBranch[0].length;
		for (int i = 0; i < cols; i++) {
			sumCols = 0;
			for (int j = 0; j < rows; j++) {
				sumCols += BankBranch[j][i];

			}
			System.out.println("The average revenue for month " + (i + 1) + " is: " + (sumCols / 12));

		}
	}

	// this takes the revenue per branch and divides by the total amount of branches
	static void avgRevenuePerBranch(double[][] BankBranch) {
		int sumRows;
		int rows = BankBranch.length;
		int cols = BankBranch[0].length;
		for (int i = 0; i < rows; i++) {
			sumRows = 0;
			for (int j = 0; j < cols; j++) {

				sumRows += BankBranch[i][j];
			}
			System.out.println("Revenue for branch " + (i + 1) + " is: " + sumRows / 10);
		}
	}

	// finding the biggest revenue and what month it's in
	static void biggestTotalRevenue(double[][] BankBranch) {
		int i, j;
		double max = 0;
		double sum;
		int[] index = new int[12];
		int k = 0;
		for (j = 0; j < 10; j++) {
			max += BankBranch[0][j];
		}
		for (i = 1; i < 10; i++) {
			sum = 0;
			for (j = 0; j < 10; j++) {
				sum += BankBranch[i][j];
			}
			if (max < sum) {
				max = sum;
			}
		}

		for (i = 0; i < 10; i++) {
			sum = 0;
			for (j = 0; j < 12; j++) {
				sum += BankBranch[i][j];
			}
			if (sum == max) {
				index[k] = i;
				k++;
			}
		}
		System.out.println("Biggest revenue is:\t" + max + " and happened during the: ");
		for (i = 0; i < k; i++) {
			System.out.println((index[i] + 1) + "th month ");
		}
	}

	// a method to exit the program
	static void exitProgram() {
		System.out.println("\nThe program will now exit. Thank you for using this program.");
		System.exit(0);
	}
}
