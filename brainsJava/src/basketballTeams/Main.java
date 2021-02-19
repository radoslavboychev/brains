package basketballTeams;

import textio.TextIO;

public class Main {
	static int choice = 0;

	public static void main(String[] args) {

		// to display the menu
		showMenu();

		// to display the menu switch 
		menuSwitch();

	}

	// to show the menu
	public static void showMenu() {

		System.out.println("--- Ballin' ---");
		System.out.println("Select your option: ");
		System.out.println("1. Create a player");
		System.out.println("0. Exit");
		System.out.print("Your choice: ");
		choice = TextIO.getlnInt();

	}

	// the switch method for the menu
	public static void menuSwitch() {

		int option = 1;
		do {

			switch (choice) {
			case 1:

				Player player1 = new Player(null, null, choice, null, choice, choice, choice, choice, choice, choice,
						choice, choice, choice);

				player1.setPlayer();
				System.out.println(player1.getPlayerName());
				System.out.println(player1.getPlayerInfo());
				break;
			case 10:
				option = 0;
			default:
				break;
			}
		} while (option == 0);
	}
}
