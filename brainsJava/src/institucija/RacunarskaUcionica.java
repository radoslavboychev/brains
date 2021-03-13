package institucija;

public class RacunarskaUcionica extends Ucionica {

	private static final int maxBroj = 20;
	private Racunar[] spisakRacunara;
	private int brojRacunara;

	public RacunarskaUcionica(String oznaka, String tip, int brMesta, double povrsina) {
		super(oznaka, tip, brMesta, povrsina);
		this.spisakRacunara = new Racunar[maxBroj];
		this.brojRacunara = 0;
	}

	public boolean dodajRacunar(Racunar r) {
		if (brojRacunara == maxBroj)
			return false;

		spisakRacunara[brojRacunara++] = r;
		return true;
	}

	public Racunar[] racunari() {
		return spisakRacunara;
	}

	public Racunar racunar(int i) {
		return spisakRacunara[i];
	}

	public String toString() {
		return super.toString() + ", broj racunara: " + brojRacunara;
	}
}
