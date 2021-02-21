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

		System.out.println("--- Custom PC Builder Tool ---");
		System.out.println("Select your option: ");
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

		// we use the sort method from the Collections class on the array list by using
		// a Comparator object which contains the compare() method and it sorts them (in
		// ascending order).
		Collections.sort(alComputers, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {

				return Double.compare(o1.getPerformanceIndex(), o2.getPerformanceIndex());

			}
		});

		// a little info message
		System.out.println("\nYour list of " + alComputers.size()
				+ " automatically generated computers, ranked by their performance index (ascending)");

		// print the info for each computer in the list
		for (Computer c : alComputers) {

			c.printInfo();
		}

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
		ArrayList<Computer> pcList = new ArrayList<>();

		for (int i = 0; i < count; i++) {

			// create the object using the default constructor
			Computer c = new Computer();

			// add it to the list
			pcList.add(c);

			// show you which PC you're making
			System.out.println("\nCreating PC #" + pcList.indexOf(c));

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

		// we use the sort method from the Collections class on the array list by using
		// a Comparator object which contains the compare() method and it sorts them (in
		// ascending order).
		Collections.sort(pcList, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {

				return Double.compare(o1.getPerformanceIndex(), o2.getPerformanceIndex());

			}
		});

		// a little info message
		System.out
				.println("Your list of " + pcList.size() + " computers, ranked by their performance index (ascending)");

		// print info for each computer in the list
		for (Computer c : pcList) {

			c.printInfo();
		}

	}

}
