package poslovanjeRestorana;

/*Interfejs za Dodavanje, brisanje i tra�enje stavki u jelovniku*/
public interface RadSaJelovnikom {
	public void brisanjeJela(String imejela);
	 void dodajJelo(Jelo jelo);
	Jelo pronadjiJelo(String imeJela);
}
