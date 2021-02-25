package basketballTeams;

public class Stats {

	private int points;
	private int rebounds;
	private int assists;
	private int steals;
	private int blocks;

// // variables for field goals; attempted fg and made fg; fg ratio
//	private int fgA;
//	private int fgM;

	Stats(int points, int rebounds, int assists, int steals, int blocks) {
		this.points = points;
		this.rebounds = rebounds;
		this.assists = assists;
		this.steals = steals;
		this.blocks = blocks;

	}
	
	public Stats()
	{
	
	}
	//GETTERS & SETTERS
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	
//	public void  fgRatio()
//	{
//		float fgRatio = fgM/fgA;
//	}
//	public void getAdvancedStats(int fgA, int fgM)
//	{
//		this.fgA = fgA;
//		this.fgM = fgM;
//		fgRatio();
//	}
}
