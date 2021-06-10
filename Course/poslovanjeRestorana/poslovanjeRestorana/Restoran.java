package poslovanjeRestorana;

public class Restoran implements RadSaJelovnikom, RadSaKlijentima, RadSaNarudzbinama, RadSaFajlovima, RadSaFajlovima2 {
	double racun;
	private ListaKlijenata spisak;
	private ListaNarudzbina narudzbine;
	private Jelovnik meni;
	String imeFajla;

	Restoran() {
		this.meni = new Jelovnik();
		this.spisak = new ListaKlijenata();
		this.narudzbine = new ListaNarudzbina();
	}

	@Override
	public void dodajJelo(Jelo jelo) { // poziva metodu dodajJelo iz jelovnika
		meni.dodajJelo(jelo);
	}

	@Override
	public void brisanjeJela(String brisijelo) { // poziva metodu brisanjeJela iz Jelovnika
		meni.brisanjeJela(brisijelo);
	}

	@Override
	public Jelo pronadjiJelo(String jelo) {		//poziva metodu pronadjiJelo iz Jelovnika
		return meni.pronadjiJelo(jelo);
	}

	public double racun(Narudzbina narudzbina, Jelo jelo) {		//racuna iznos jedne narudzbine
		return racun = narudzbina.getKolicina() * jelo.getCena();

	}

	@Override
	public void brisanjeNarudzbine(Narudzbina imeNarudzbine) {	//poziva se metod brisanjeNarudzbine iz klase ListaNarudzbina
		narudzbine.brisanjeNarudzbine(imeNarudzbine);
		// TODO Auto-generated method stub

	}

	@Override
	public void dodajNarudzbinu(Narudzbina n) {	//poziva metodu za dodavanje Narudzbine iz klase ListaNarudzbina
		narudzbine.dodajNarudzbinu(n);
		// TODO Auto-generated method stub
	}

	@Override
	public Narudzbina pronadjiNarudzbinu(String imeJela, String telefon) {	//poziva metodu za pronalazenje narudzbine
		return narudzbine.pronadjiNarudzbinu(imeJela, telefon);
		// TODO Auto-generated method stub

	}

	@Override
	public void brisanjeKlijenata(String telefon) {			//metoda brisanje klijenata pozvana iz ListeKlijenata
		spisak.brisanjeKlijenata(telefon);
		// TODO Auto-generated method stub

	}

	@Override
	public void dodajKlijenta(Klijent k) {		//metoda dodajKlijenta pozvana iz ListeKlijenata
		spisak.dodajKlijenta(k);
		// TODO Auto-generated method stub

	}

	@Override
	public Klijent pronadjiKlijenta(String telefon) {	//metoda za pronalazenje klijenata pozvana iz ListeKlijenata
		return spisak.pronadjiKlijenta(telefon);
		// TODO Auto-generated method stub

	}

	@Override

	public void ucitajListu(String imeFajla) {		//metoda koja ucitava Jelovnik
		meni.ucitajListu(imeFajla);
		// TODO Auto-generated method stub

	}

	@Override
	public void upisiListu(String imeFajla) {	//metoda za dodavanje jela u jelovnik
		meni.upisiListu(imeFajla);
		// TODO Auto-generated method stub

	}

	public void ucitajFajl(String imeFajla) {		//ucitava txt fajl sa spiskom klijenata
		spisak.ucitajFajl(imeFajla);
		// TODO Auto-generated method stub

	}

	@Override
	public void upisiUFajl(String imeFajla) { //upisuje nove klijente u txt fajl
		spisak.upisiUFajl(imeFajla);
	}

	// TODO Auto-generated method stub
	public String toString() {		
		return narudzbine.toString();
	}

	@Override
	public void upisiNarudzbinu(String imeFajla) {		//metod koji upisuje pojedinacne narudzbine u txt fajl
		narudzbine.upisiNarudzbinu(imeFajla);

	}
}