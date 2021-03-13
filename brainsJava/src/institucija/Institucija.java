package institucija;

public class Institucija {

	private static final int maxBroj = 20;
	private String naziv, adresa, maticniBroj;
	private Zaposleni zakonskiZastupnik;
	private Ucionica[] spisakUcionica;
	private Zaposleni[] spisakZaposlenih;
	private int brojUcionica, brojZaposlenih;

	public Institucija(String naziv, String adresa, String maticniBroj, Zaposleni zakonskiZastupnik) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.maticniBroj = maticniBroj;
		this.zakonskiZastupnik = zakonskiZastupnik;
		this.spisakUcionica = new Ucionica[maxBroj];
		this.brojUcionica = 0;
		this.spisakZaposlenih = new Zaposleni[maxBroj];
		this.brojZaposlenih = 0;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public Osoba getZakonskiZastupnik() {
		return zakonskiZastupnik;
	}

	public Ucionica[] getUcionice() {
		return spisakUcionica;
	}

	public Zaposleni[] getZaposleni() {
		return spisakZaposlenih;
	}

	public int getBrojUcionica() {
		return brojUcionica;
	}

	public int getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public void setZakonskiZastupnik(Zaposleni zakonskiZastupnik) {
		this.zakonskiZastupnik = zakonskiZastupnik;
	}

	public boolean dodajUcionicu(String oznaka, String tip, int brMesta, double povrsina, boolean racunarska) {
		if (brojUcionica == maxBroj)
			return false;
		if (racunarska) {
			spisakUcionica[brojUcionica++] = new RacunarskaUcionica(oznaka, tip, brMesta, povrsina);
		}
		else {
			spisakUcionica[brojUcionica++] = new Ucionica(oznaka, tip, brMesta, povrsina);
		}
		return true;
	}

	public boolean dodajZaposlenog(String ime, String prezime, int starost, double koefRadnogMesta) {
		if (brojZaposlenih == maxBroj)
			return false;
		spisakZaposlenih[brojZaposlenih++] = new Zaposleni(ime, prezime, starost, koefRadnogMesta);
		return true;
	}

	private Ucionica nadjiUcionicu(String oznaka) {
		for (int i = 0; i < brojUcionica; i++)
			if (spisakUcionica[i].oznaka().equals(oznaka))
				return spisakUcionica[i];
		return null;
	}

	public boolean dodajRacunarUUcionicu(String oznaka, String procesor, double radniTakt, int kapacitetMemorije) {
		Ucionica u = nadjiUcionicu(oznaka);
		if (u == null)
			return false;
		if (!(u instanceof RacunarskaUcionica)) {
			System.out.println("Racunari se mogu dodati samo u racunarsku ucionicu!");
			return false;
		}
		RacunarskaUcionica ru = (RacunarskaUcionica) u;
		ru.dodajRacunar(new Racunar(procesor, radniTakt, kapacitetMemorije));
		return true;
	}

	public String toString() {
		return "Naziv: " + naziv + ", adresa: " + adresa + ", MB: " + maticniBroj + ".";
	}

	public void prikaziPodatke() {
		System.out.println(this.toString());
		System.out.println("Spisak zaposlenih: ");
		for (int i = 0; i < brojZaposlenih; i++)
			System.out.println(this.spisakZaposlenih[i]);
		System.out.println("Spisak ucionica: ");
		for (int i = 0; i < brojUcionica; i++)
			System.out.println(this.spisakUcionica[i]);
	}
}
