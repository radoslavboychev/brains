package basketballTeams;

import basketballTeams.Player.position;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player player1 = new Player("Goran", "Dragic", 178, 75, position.PG);
		Player player2 = new Player("Duncan", "Robinson", 185, 74, position.SG);
		Player player3 = new Player("Jimmy", "Butler", 189, 77, position.SF);
		Player player4 = new Player("Kelly", "Olynyk", 195, 80, position.PF);
		Player player5 = new Player("Bam", "Adebayo", 198, 88, position.C);

		Player player6 = new Player("Dennis", "Schroder", 176, 75, position.PG);
		Player player7 = new Player("Kentavious", "Caldwell-Pope", 185, 74, position.SG);
		Player player8 = new Player("LeBron", "James", 195, 90, position.SF);
		Player player9 = new Player("Anthony", "Davis", 195, 80, position.PF);
		Player player10 = new Player("Montrezl", "Harrell", 198, 88, position.C);

		Team miamiHeat = new Team("Miami Heat", player1, player2, player3, player4, player5, 64, 18);

		miamiHeat.printTeam();
		player1.printPlayer();
		player2.printPlayer();
		player3.printPlayer();
		player4.printPlayer();
		player5.printPlayer();
		System.out.println();

		Team laLakers = new Team("Los Angeles Lakers", player6, player7, player8, player9, player10, 60, 22);
		laLakers.printTeam();
		player6.printPlayer();
		player7.printPlayer();
		player8.printPlayer();
		player9.printPlayer();
		player10.printPlayer();
		System.out.println();

	}

}
