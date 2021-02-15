package basketballTeams;

public class Player {

	String fName;
	String lName;

	double height;
	double weight;

	// set the position of a player with label
	enum position {
		PG("Point Guard"), SG("Shooting Guard"), SF("Small Forward"), PF("Power Forward"), C("Center");

		public final String positionLabel;

		private position(String positionLabel) {
			this.positionLabel = positionLabel;
		}

	}

	position p;

	//this is a method that creates a player
	void createPlayer(String fname, String lname, double height, double weight, position p) {
		this.fName = fname;
		this.lName = lname;
		this.height = height;
		this.weight = weight;
		this.p = p;
	}
	//constructor that creates a player
	Player(String fname, String lname, double height, double weight, position p) {
		this.fName = fname;
		this.lName = lname;
		this.height = height;
		this.weight = weight;
		this.p = p;
	}

	void printPlayer() {
		System.out.println(
				"At " + p + ": " + fName + " " + lName + " " + height + "cm tall and weighs " + weight + " kg.");
	}
//	void printTeam()
//	{
//		
//		for (int i = 0; i < array.length; i++) {
//			printPlayer();
//		}
//	}
}
