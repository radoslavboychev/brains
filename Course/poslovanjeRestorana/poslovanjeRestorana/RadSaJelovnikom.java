package poslovanjeRestorana;

/*Interfejs za Dodavanje, brisanje i traženje stavki u jelovniku*/
public interface RadSaJelovnikom {
	public void brisanjeJela(String imejela);
	 void dodajJelo(Jelo jelo);
	Jelo pronadjiJelo(String imeJela);
}
