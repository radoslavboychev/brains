package basketballTeams;

public class Player {

	private String fName;
	private String lName;

	private int number;

//	double height;
//	double weight;

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
	Player(String fname, String lname, int number, position p) {
		this.fName = fname;
		this.lName = lname;
		this.p = p;
		this.number = number;
	}


	// setter for player name
	public void setPlayerName(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	// setter for player info
	public void setPlayerInfo(int number, position p) {
		this.number = number;
		this.p = p;
	}

	// getter for player name
	public String getPlayerName() {
		return this.fName + " " + this.lName;
	}

	// getter for player info
	public String getPlayerInfo() {
		return "#" + number + " at " + p + " ";
	}
	
	// method to return the player
	public String getPlayer() {
		return "Player: " + getPlayerName() + " " + getPlayerInfo();
	}
}
