package poslovanjeRestorana;
/*Interfejs za Učitavanje podataka o klijentima i jelovniku iz datoteka (klijenti.txt, jelovnik.txt)
 *  Upis podataka o svim narudžbinama u datoteku*/
public interface RadSaFajlovima {
	
	void upisiListu(String imeFajla);
	void ucitajListu(String imeFajla);
}
