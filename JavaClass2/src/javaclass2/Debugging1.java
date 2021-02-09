package javaclass2;

public class Debugging1 {

	public static void main(String[] args) {
		/* Deklaracija promenljivih. */
		double investicija; // Vrednost investicije.
		double stopa;       // Kamatana stopa.
		double zarada; // Ukupna kamata po godini.
		/* Izracunavanje. */
		investicija = 1000;
		stopa = 0.027;
		zarada = investicija * stopa;   // Compute the interest.
		investicija = investicija / zarada;
		// Izracunavanje investicije posle godinu dana sa kamatom.
		// (Obratiti paznju da nova vrednost investicije prepisuje staru.)
		/* Ispisivanje rezultata. */
		System.out.print("Za godinu dana zaradjeno je: ");
		System.out.print(zarada);
		System.out.println(" dinara.");
		System.out.print("Ukupna vrednost investije je sada: ");
		System.out.print(stopa);
		System.out.print(" dinara.");
		} 
	
	// kraj main metode


}
