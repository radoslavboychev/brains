package computer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import textio.TextIO;

public class Main {

	static DecimalFormat dFormat = new DecimalFormat("0.00");

	// for the menu
	static int choice;

	public static void main(String[] args) {

		// this opens the main menu that loops until the user decides to exit
		menuSwitch();

	}

	// to show the menu
	public static void showMenu() {

		System.out.println("--- Custom PC Builder Tool ---\n");
		System.out.println("Select your option: \n");
		System.out.println("1. Automatic creation of PC List");
		System.out.println("2. Manual creation of PC List");
		System.out.println("0. Exit");
		System.out.print("\nYour choice: ");
		choice = TextIO.getlnInt();

	}

	// the switch method for the menu
	public static void menuSwitch() {

		do {
			showMenu();
			switch (choice) {
			case 1: {
				autoCreatePCList();
			}

				break;
			case 2: {
				customCreatePCList();
			}
				break;

			default: {
				System.out.println("~~~ Thank you for using this PC building tool! The program will now exit! ~~~");
				choice = 0;
			}

				break;
			}
		} while (choice != 0);
	}

	// this creates all the objects automatically, creates an arrayList and adds
	// them to the list
	public static void autoCreatePCList() {

		// the random object
		Random random = new Random();

		// generates random values for the cpu clock and the RAM (CPU clock between 1GHz
		// and 6GHz, RAM between 1mb and 16Gb) to keep it at a reasonable level, using
		// Math.floor to round the decimals

		// still, every PC has a specific CPU name so that's not randomized

		Computer myComp1 = new Computer("Intel Core i3", Math.floor((Math.random() * (6 - 1 + 1) + 1)),
				random.nextInt(16000));
		Computer myComp2 = new Computer("AMD GamerXD 3521", Math.floor(Math.random() * (6 - 1 + 1) + 1),
				random.nextInt(16000));

		// this uses the default constructor which sets everything to 0 or null
		Computer myComp3 = new Computer();

		Computer myComp4 = new Computer("AMD Ryzen Pro 1300", Math.floor(Math.random() * (6 - 1 + 1) + 1),
				random.nextInt(16000));
		Computer myComp5 = new Computer("Intel Core i5 KJRN", Math.floor(Math.random() * (6 - 1 + 1) + 1),
				random.nextInt(16000));
		Computer myComp6 = new Computer("AMD Ryzen 9 5900X", Math.floor(Math.random() * (6 - 1 + 1) + 1),
				random.nextInt(16000));
		Computer myComp7 = new Computer("Intel Core i7 10700K", Math.floor(Math.random() * (6 - 1 + 1) + 1),
				random.nextInt(16000));

		// creates an arrayList of type Computer and adds the objects to the list
		ArrayList<Computer> alComputers = new ArrayList<Computer>();

		alComputers.add(myComp1);
		alComputers.add(myComp2);
		alComputers.add(myComp3);
		alComputers.add(myComp4);
		alComputers.add(myComp5);
		alComputers.add(myComp6);
		alComputers.add(myComp7);

		// activate the switch menu for the sorting
		sortSwitch(alComputers);

	}

	// making the list using user inputs
	public static void customCreatePCList() {
		int count = 0;
		String nameString;
		double clockSpeedGHz;
		int memoryRAM;
		System.out.print("Insert number of computers to make: ");
		count = TextIO.getlnInt();

		// make an array list of computers
		ArrayList<Computer> alComputers = new ArrayList<>();

		for (int i = 0; i < count; i++) {

			// create the object using the default constructor
			Computer c = new Computer();

			// add it to the list
			alComputers.add(c);

			// show you which PC you're making
			System.out.println("\nCreating PC #" + alComputers.indexOf(c));

			// set the CPU name
			System.out.print("Insert processor name: ");

			nameString = TextIO.getlnString();
			c.setProcessorName(nameString);

			// set the clock speed
			System.out.print("Insert clock speed (in GHz): ");

			clockSpeedGHz = TextIO.getlnDouble();
			c.setClockSpeed(clockSpeedGHz);

			// set the RAM memory
			System.out.print("Insert the RAM memory size: ");

			memoryRAM = TextIO.getlnInt();
			c.setMemorySize(memoryRAM);

			// calculate the performance index
			c.getPerformanceIndex();
		}

		sortSwitch(alComputers);

	}

	// method that does the sorting in asc order
	public static void sortPCAsc(ArrayList<Computer> e) {
		// we use the sort method from the Collections class on the array list by using
		// a Comparator object which contains the compare() method and it sorts them (in
		// ascending order).

		Collections.sort(e, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {

				return Double.compare(o1.getPerformanceIndex(), o2.getPerformanceIndex());

			}
		});

		// a little info message
		System.out
				.println("\nYour list of " + e.size() + " computers, ranked by their performance index (ascending)\n");

		// print the info for each computer in the list
		for (Computer c : e) {

			System.out.println("\nComputer #" + e.indexOf(c));
			c.printInfo();
		}
	}

	// method that does the sorting in desc order
	public static void sortPCDesc(ArrayList<Computer> e) {

		// we use the sort method from the Collections class on the array list by using
		// a Comparator object which contains the compare() method and it sorts them (in
		// ascending order).

		Collections.sort(e, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {

				return Double.compare(o2.getPerformanceIndex(), o1.getPerformanceIndex());

			}
		});

		// a little info message
		System.out.println(
				"\nYour list of " + e.size() + "  computers, ranked by their performance index (descending)\n");

		// print the info for each computer in the list
		for (Computer c : e) {

			System.out.println("\nComputer #" + e.indexOf(c));
			c.printInfo();
		}

	}

	// switch menu for sorting choices (asc/desc)
	public static void sortSwitch(ArrayList<Computer> c) {

		int key;
		System.out.println("\nHow would you like the the PCs to be sorted?\n");
		System.out.println("1. Ascending order\n2. Descending order\n");
		System.out.print("Your choice: ");
		key = TextIO.getlnInt();

		switch (key) {
		case 1:
			sortPCAsc(c);
			break;
		case 2:
			sortPCDesc(c);
		default:
			break;
		}
	}
}
