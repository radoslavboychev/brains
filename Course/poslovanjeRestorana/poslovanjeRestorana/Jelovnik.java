package poslovanjeRestorana;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Jelovnik implements RadSaJelovnikom, RadSaFajlovima {
	/*
	 * Za svaku od stavki u jelovniku pamti se naziv stavke, tip (predjelo, glavno
	 * jelo, salata, dezert, piće) i cena.
	 */
	private ArrayList<Jelo> spisakHrane;

	Jelovnik() {
		spisakHrane = new ArrayList<Jelo>();
	}

	@Override
	public void brisanjeJela(String imeJela) {
		spisakHrane.remove(pronadjiJelo(imeJela));
		System.out.println( imeJela + " jelo je uklonjeno.");
		}
		
	@Override
	public void dodajJelo(Jelo jelo) {
			spisakHrane.add(jelo);}

	@Override
	public Jelo pronadjiJelo(String imeJela) {
		Jelo pronadjiJelo = null;
		for (int i = 0; i < spisakHrane.size(); i++)
			if (spisakHrane.get(i).getImeJela().equals(imeJela))
				pronadjiJelo = spisakHrane.get(i);

		return pronadjiJelo;
	}

	@Override
	public void ucitajListu(String imeFajla) {
		Scanner s = null;
		ArrayList<Jelo> spisakHrane = new ArrayList<Jelo>();
		try {
			s = new Scanner(new File(imeFajla));
			do {
				String imeJela = s.next();
				String tip = s.next();
				double cena = s.nextDouble();
				Jelo novoJelo = new Jelo(imeJela,tip, cena);
				spisakHrane.add(novoJelo);
			} while (s.hasNext());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
		this.spisakHrane = spisakHrane;
	}

	@Override
	public void upisiListu(String imeFajla) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(imeFajla));
			for (Jelo novoJelo : this.spisakHrane)
				pw.println( novoJelo.getImeJela()+ " "+novoJelo.getTip() + " "  + " " + novoJelo.getCena());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}
	void stampaj() {
		System.out.println(this.spisakHrane);
	}
	public String toString() {
		return "Jela su sledeca " +spisakHrane; 
	}
	}
