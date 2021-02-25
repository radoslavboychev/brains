package basketballTeams;

import textio.TextIO;

public class Player extends Person {

	private int number;

	private Attributes playerAttributes;
	private Stats playerStats;

	// set the position of a player with label
	public enum position {
		PG("Point Guard"), SG("Shooting Guard"), SF("Small Forward"), PF("Power Forward"), C("Center");

		public final String positionLabel;

		private position(String positionLabel) {
			this.positionLabel = positionLabel;
		}

	}

	// declare the enum so i can use it later
	position p;



	// constructor
	public Player(String fName, String lName, int age, int number, position p, Attributes a, Stats s) {
		super(fName, lName, age);
		this.number = number;
		this.playerStats = s;
		this.playerAttributes = a;

	}

	public Player() {

	}

	// setter for player info
	public void setPlayer() {

		int choice = 0;
		
		super.setfName();
		
		super.setlName();
		
		super.setAge();
		

		System.out.print("Number: ");

		System.out.print("Position: ");
		System.out.println("1.PG" + "\n2.SG" + "\n3.SF" + "\n4.PF" + "\n5.C");
		System.out.print("Position: ");

		choice = TextIO.getlnInt();

		// set the position
		switch (choice) {
		case 1:
			this.p = position.PG;
			break;
		case 2:
			this.p = position.SG;
			break;
		case 3:
			this.p = position.SF;
			break;
		case 4:
			this.p = position.PF;
			break;
		case 5:
			this.p = position.C;
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

	}

	// GETTERS & SETTERS
	public int getNumber() {
		return number;
	}

	public void setNumber() {
		this.number = TextIO.getlnInt();
	}

	public Attributes getPlayerAttributes() {
		return playerAttributes;
	}

	public void setPlayerAttributes(Attributes playerAttributes) {
		this.playerAttributes = playerAttributes;
	}

	public Stats getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(Stats playerStats) {
		this.playerStats = playerStats;
	}

	public position getP() {
		return p;
	}

	public void setP(position p) {
		this.p = p;
	}

}
