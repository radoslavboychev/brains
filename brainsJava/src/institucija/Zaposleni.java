package institucija;

public class Zaposleni extends Osoba {

	private static final int stdBrojDana = 20;
	private double koefRadnogMesta;
	private double plata;

	public Zaposleni(String ime, String prezime, int starost, double koefRadnogMesta) {
		super(ime, prezime, starost);
		this.koefRadnogMesta = koefRadnogMesta;
		setPlata(stdBrojDana);
	}

	public String ime() {
		return super.ime;
	}

	public String prezime() {
		return super.prezime;
	}

	public int starost() {
		return super.starost;
	}

	public double getKoefRadnogMesta() {
		return this.koefRadnogMesta;
	}

	public double getPlata() {
		return this.plata;
	}

	public void setPlata(int brojDana) {
		this.plata = getKoefRadnogMesta() * brojDana;
	}

	public String toString() {
		return this.getIme() + " " + this.getPrezime() + ", na radnom mestu sa koeficijentom " + this.getKoefRadnogMesta() + " ima platu " + this.getPlata();
	}
}
