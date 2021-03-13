package basketballTeams;

import java.awt.List;
import java.util.ArrayList;

import textio.TextIO;

public class Main {

	// create players
	// create a player
	// set position
	// set name, age etc...
	// create teams
	// create the team object
	// add players to a list
	// show the list

	// static int choice = 0;

	public static void main(String[] args) {

		showMenu();

	}

	// menu text method
	public static void menuText() {
		System.out.println("--- Ballin' ---\n");
		System.out.println("MAIN MENU \n");
		System.out.println("1. Create a player");
		System.out.println("0. Exit\n");
		System.out.print("Your choice: ");
	}

	// to show the menu
	public static void showMenu() {

		menuText();
		menuSwitch();
	}

	// the switch method for the menu
	public static void menuSwitch() {
		int option;

		do {

			option = TextIO.getlnInt();
			switch (option) {
			case 1:
				createPlayer();
				System.out.println("\nCreated Successfully!\n");
				showMenu();
				break;
			case 0:
				option = 0;
				break;
			default:

				break;

			}

		} while (option != 0);
	}
	

	//list of players
	public static ArrayList<Player> players = new ArrayList<>();

	public static void createPlayer() {

		Player p = new Player();

		p.setPlayer();
		addToList(p);

	}
	public static void addToList(Player p)
	{
		players.add(p);		
	}

}