package basketballTeams;

public class Team {

	String name;
	int wins;
	int losses;
	double winLossRatio;

	// constructor 
	Team(String name, Player pg, Player sg, Player sf, Player pf, Player c,int wins,int losses)

	{
		this.name = name;
		this.wins = wins;
		this.losses = losses;
	}

	//calculates w/l
	public void calculateWinLoss() {
		winLossRatio = wins / losses;
	}
	
	// prints the team info
	public void printTeam()
	{
		calculateWinLoss();
		System.out.println("Team: " + name + "\nWins: " + wins + "\nLosses: " + losses + "\nWin/Loss: " + winLossRatio + "\nPlayers:\n" );
	}
}
