package basketballTeams;

import basketballTeams.Player.position;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player player1 = new Player("Goran", "Dragic", 7, position.PG);
		Player player2 = new Player("Duncan", "Robinson", 55, position.SG);
		Player player3 = new Player("Jimmy", "Butler", 60, position.SF);
		Player player4 = new Player("Kelly", "Olynyk", 43, position.PF);
		Player player5 = new Player("Bam", "Adebayo", 12, position.C);

		Player player6 = new Player("Dennis", "Schroder", 16, position.PG);
		Player player7 = new Player("Kentavious", "Caldwell-Pope", 56, position.SG);
		Player player8 = new Player("LeBron", "James", 23, position.SF);
		Player player9 = new Player("Anthony", "Davis", 55, position.PF);
		Player player10 = new Player("Montrezl", "Harrell", 12, position.C);

//		//testing out the setter
//		player1.setPlayerInfo(21, position.SF);

		// create the heat
		Team miamiHeat = new Team("Miami Heat", player1, player2, player3, player4, player5, 64, 18);
		
		System.out.println(miamiHeat.getTeam());
		
		System.out.println(player1.getPlayer());
		System.out.println(player2.getPlayer());
		System.out.println(player3.getPlayer());
		System.out.println(player4.getPlayer());
		System.out.println(player5.getPlayer());
		System.out.println();

		// create the lakers
		Team laLakers = new Team("Los Angeles Lakers", player6, player7, player8, player9, player10, 60, 22);
		
		System.out.println(laLakers.getTeam());

		System.out.println(player6.getPlayer());
		System.out.println(player7.getPlayer());
		System.out.println(player8.getPlayer());
		System.out.println(player9.getPlayer());
		System.out.println(player10.getPlayer());
		System.out.println();

//		//testing out the getter
//		System.out.println(player1.getPlayerName());

	}

}
