package basketballTeams;

import basketballTeams.Player.position;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		Player player5 = new Player();
		
		player1.createPlayer("Goran", "Dragic", 189, 75, position.PG);
		player2.createPlayer("Duncan", "Robinson", 195, 75, position.SG);
		player3.createPlayer("Jimmy", "Butler", 192, 87,position.SF);
		player4.createPlayer("Kelly", "Olynyk", 201, 93, position.PF);
		player5.createPlayer("Bam", "Adebayo", 202, 90, position.C);
		
		player1.printPlayer();
		player2.printPlayer();
		player3.printPlayer();
		player4.printPlayer();
		player5.printPlayer();
		
	}

}
