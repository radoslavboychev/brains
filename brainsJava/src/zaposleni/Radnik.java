package zaposleni;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public abstract class Radnik {
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String tekuciRacun;
	protected double koefSS;

	public void unosTxt(BufferedReader datoteka) {
		try {
			ime = datoteka.readLine();
			prezime = datoteka.readLine();
			jmbg = datoteka.readLine();
			tekuciRacun = datoteka.readLine();
			koefSS = Double.parseDouble(datoteka.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void upisTxt(BufferedWriter datoteka, double cenaRada) {
		try {
			datoteka.write(ime);
			datoteka.newLine();
			datoteka.write(prezime);
			datoteka.newLine();
			datoteka.write(tekuciRacun);
			datoteka.newLine();
			datoteka.write(Double.valueOf(izracunajPlatu(cenaRada)).toString());
			datoteka.newLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	abstract public double izracunajPlatu(double cenaRada);
}