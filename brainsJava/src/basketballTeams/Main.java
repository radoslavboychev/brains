package basketballTeams;

import textio.TextIO;

public class Main {
	
	
	//create players
		//create a player
			//set position
			//set name, age etc...
	//create teams
		//create the team object
		//add players to a list
		//show the list
	
	
	
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
		//choice = TextIO.getlnInt();
		menuSwitch();
	}

	// the switch method for the menu
	public static void menuSwitch() {
	int option = TextIO.getlnInt();
		do {

			switch (option) {
			case 1:
				createPlayer();
				break;
			case 0:
				option = 0;
				break;
			default:
				break;
			}
		} while (option != 0);
	}

	public static void createPlayer() {

		Player p = new Player();

		p.setPlayer();

	}

}
