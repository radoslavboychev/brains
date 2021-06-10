package poslovanjeRestorana;
/*•Interfejs za Dodavanje, brisanje i traženje narudžbine*/
public interface RadSaNarudzbinama {
	public void brisanjeNarudzbine(Narudzbina imeNarudzbine);
	 void dodajNarudzbinu(Narudzbina n);
	Narudzbina pronadjiNarudzbinu(String imeJela,String telefon);
	void upisiNarudzbinu(String imeFajla);	//kako je Listu narudzbina bilo potrebno samo upisati u txt a ne
											//i procitati iz istog, ovde sam dodala upisi narudzbinu
											// jer u klasi restoran nisam mogla imati dve iste metode
											//koje su od istog interfejsa odnosno istog imena
	
}
