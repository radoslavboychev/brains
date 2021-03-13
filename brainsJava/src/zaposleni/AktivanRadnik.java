package zaposleni;

import java.io.IOException;
import java.io.BufferedReader;

public class AktivanRadnik extends Radnik {

	private double varKoef;

	public void unosTxt(BufferedReader datoteka) {
		try {
			super.unosTxt(datoteka);
			varKoef = Double.parseDouble(datoteka.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public double izracunajPlatu(double cenaRada) {
		return (koefSS + varKoef) * cenaRada;
	}
}
