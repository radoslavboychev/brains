package basketballTeams;

public class Stats {

	private int points;
	private int rebounds;
	private int assists;
	private int steals;
	private int blocks;
	
 // variables for field goals; attempted fg and made fg; fg ratio
	private int fgA;
	private int fgM;
	private float fgRatio = fgM/fgA;
	
	
	Stats(int points,int rebounds,int assists, int steals, int blocks)
	{
		this.points = points;
		this.rebounds = rebounds;
		this.assists = assists;
		this.steals = steals;
		this.blocks = blocks;
	}
}
