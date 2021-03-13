package institucija;

public class Osoba {

	protected String ime;
	protected String prezime;
	protected int starost;

	public Osoba(String ime, String prezime, int starost) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setStarost(starost);
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public int getStarost() {
		return starost;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public String toString() {
		return "Ime: " + this.getIme() + " Prezime: " + this.getPrezime() + " Starost: " + this.getStarost() + " godina";
	}
}
