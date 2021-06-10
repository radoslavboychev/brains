package poslovanjeRestorana;

public class RestoranMain {

	/*
	 * Program za podršku poslovanju restorana sa isporukom
	 * 
	 * Restorani koji nude isporuku hrane na kućnu adresu u svom poslovanju vode
	 * evidenciju o klijentima, jelovniku i narudžbinama. Za klijente beleže ime,
	 * prezime, adresu i broj mobilnog telefona. Za svaku od stavki u jelovniku
	 * pamti se naziv stavke, tip (predjelo, glavno jelo, salata, dezert, piće) i
	 * cena. Narudžbina se sastoji od jedne ili više stavki iz jelovnika koje je
	 * naručio određeni klijent, kao i informacije o tome da li je narudžbina
	 * uspešno realizovana ili ne.
	 * 
	 * Realizovati sledeće funkcionalnosti: • Učitavanje podataka o klijentima i
	 * jelovniku iz datoteka (klijenti.txt, jelovnik.txt) • Dodavanje, brisanje i
	 * traženje stavki u jelovniku • Dodavanje, brisanje i traženje klijenta •
	 * Dodavanje, brisanje i traženje narudžbine • Upis podataka o svim narudžbinama
	 * u datoteku
	 * 
	 * Dodati i klase za podršku za listama odgovarajućih objekata (ListaKlijenata,
	 * ListaNarudžbina - Jelovnik je sam po sebi već lista Stavki). U test klasi
	 * kreirati restoran, učitati podatke o jelovniku i klijentima i kreirati
	 * nekoliko narudžbina. Podatke o realizovanim narudžbinama upisati u izlaznu
	 * datoteku.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restoran r = new Restoran();
		r.ucitajListu("Jelovnik.txt");

		r.pronadjiJelo("beckaSnicla");		//u cilju testiranja programa ispisane sve naredbe
		r.brisanjeJela("beckaSnicla");		//zakomentarisite potrebne linije da biste sve proverili
		r.upisiListu("Jelovnik.txt");
		r.ucitajListu("Jelovnik.txt");
		Jelo pasulj = new Jelo("pasulj", "glavnoJelo", 300.0);
		r.dodajJelo(pasulj);
		r.brisanjeJela("pasulj");
		r.upisiListu("Jelovnik.txt");
		r.ucitajFajl("Klijenti.txt");
		Klijent k = new Klijent("Sara", "Saric", "Puskinova", "0636698");
		r.ucitajFajl("Klijenti.txt");
		r.dodajKlijenta(k);
		r.upisiUFajl("Klijenti.txt");
		r.ucitajFajl("Klijenti.txt");
		Narudzbina prva=new Narudzbina(k,pasulj,3,true);
		r.racun(prva,pasulj);
		System.out.println(r.racun(prva,pasulj));
		Jelo j=r.pronadjiJelo("kokaKola");
		r.dodajNarudzbinu(prva);
		Klijent a =r.pronadjiKlijenta("0636698");
		Narudzbina druga=new Narudzbina(a,j,5,true);
		j.toString();
		System.out.println(r.racun(druga,j));
		r.brisanjeKlijenata("0636698");
		r.upisiUFajl("Klijenti.txt");
		r.ucitajFajl("Klijenti.txt");
		r.pronadjiKlijenta("0636698");
		r.dodajNarudzbinu(druga);
		r.upisiNarudzbinu("Narudzbine.txt");
		r.pronadjiNarudzbinu("pasulj", "0636698");
		

	}

}
