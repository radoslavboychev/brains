package basketballTeams;

import textio.TextIO;

public class Main {
	static int choice = 0;

	public static void main(String[] args) {

		// to display the menu
		showMenu();

	}

	// to show the menu
	public static void showMenu() {

		System.out.println("--- Ballin' ---\n");
		System.out.println("MAIN MENU \n");
		System.out.println("1. Create a player");
		System.out.println("0. Exit\n");
		System.out.print("Your choice: ");
		choice = TextIO.getlnInt();
		menuSwitch();
	}

	// the switch method for the menu
	public static void menuSwitch() {

		int option = 1;
		do {

			switch (option) {
			case 1:
				createPlayer();
				break;
			case 2:
				break;
			case 10:
				option = 0;
				break;
			default:
				break;
			}
		} while (option != 0);
	}

	
	
	public static void createPlayer() {
		
		Player p = new Player();
		Stats s = new Stats();
		Attributes a = new Attributes();
		
		p.setPlayer();
		
	}

}
