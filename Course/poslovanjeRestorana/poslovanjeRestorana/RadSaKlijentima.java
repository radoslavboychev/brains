package poslovanjeRestorana;

/*�Interfejs za Dodavanje, brisanje i tra�enje klijenta*/
public interface RadSaKlijentima {
	public void brisanjeKlijenata(String telefon);
	 void dodajKlijenta(Klijent k);
	Klijent pronadjiKlijenta(String telefon);
}
