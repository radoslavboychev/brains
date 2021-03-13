package zaposleni;

public class RadnikNaBolovanju extends Radnik {

	public double izracunajPlatu(double cenaRada) {
		return (0.8 * koefSS) * cenaRada;
	}

}