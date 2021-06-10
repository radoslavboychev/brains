package poslovanjeRestorana;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListaNarudzbina implements RadSaNarudzbinama {
	/* Upis podataka o svim narudžbinama u datoteku */
	ArrayList<Narudzbina> listaNarudzbina = new ArrayList<Narudzbina>();
	Narudzbina n= new Narudzbina();

	ListaNarudzbina() {
		this.listaNarudzbina = new ArrayList<Narudzbina>();
	}

	@Override
	public void dodajNarudzbinu(Narudzbina n) {

		listaNarudzbina.add(n);
	}

	@Override
	public void brisanjeNarudzbine(Narudzbina n) {
		listaNarudzbina.remove(n);
	}

	@Override
	public Narudzbina pronadjiNarudzbinu(String imeJela, String telefon) {
		Narudzbina n = null;
		for (int i = 0; i < listaNarudzbina.size(); i++) {
			if (listaNarudzbina.get(i).porucenoJelo.getImeJela().equals(imeJela)
					&& listaNarudzbina.get(i).porucilac.getTelefon().equals(telefon))
				;
			n = listaNarudzbina.get(i);
		}
		return n;
	}

	public void upisiNarudzbinu(String imeFajla) {
		PrintWriter pw = null;
	
			try {

				pw = new PrintWriter(new FileOutputStream(imeFajla));
				for (Narudzbina n : listaNarudzbina) {
					pw.println(n.toString());
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
	}

}
