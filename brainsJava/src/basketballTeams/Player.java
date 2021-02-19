package basketballTeams;

import textio.TextIO;

public class Player {

	private String fName;
	private String lName;

	private int number;

	// attributes
	private int layups, closeShot, midRange, threePtShot, insideD, perimeterD, blocks, offReb, defReb;

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

	// constructor that creates a player
	Player(String fname, String lname, int number, position p, int layups, int closeShot, int midRange, int threePtShot,
			int insideD, int perimeterD, int blocks, int offReb, int defReb) {
		this.fName = fname;
		this.lName = lname;
		this.p = p;
		this.number = number;
		this.blocks = blocks;
		this.closeShot = closeShot;
		this.defReb = defReb;
		this.insideD = insideD;
		this.midRange = midRange;
		this.offReb = offReb;
		this.threePtShot = threePtShot;

	}

	// setter for player name
	public void setPlayerName() {
		System.out.print("First name: ");
		this.fName = TextIO.getlnString();

		System.out.print("Last name: ");
		this.lName = TextIO.getlnString();
	}

	// setter for player info
	public void setPlayerInfo() {

		int choice = 0;

		System.out.print("Number: ");
		this.number = TextIO.getlnInt();

		System.out.print("Position: ");
		System.out.println("1. PG" + "\n2.SG" + "\n3.SF" + "\n4.PF" + "\n5.C");
		System.out.print("Position: ");

		choice = TextIO.getlnInt();

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
		case 5:
			this.p = position.C;
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

	}

	// getter for player name
	public String getPlayerName() {
		return this.fName + " " + this.lName;
	}

	// getter for player info
	public String getPlayerInfo() {
		return "#" + number + ", Position:  " + p + " ";
	}

	// method to return the player
	public String getPlayer() {
		return "Player: " + getPlayerName() + " " + getPlayerInfo();
	}

	public void setPlayerAttributes(int layups, int closeShot) {
	}

	public void setPlayer() {
		setPlayerName();
		setPlayerInfo();
	}
	public String returnPlayer()
	{
		return getPlayer() + " " + getPlayerInfo();
	}

}
