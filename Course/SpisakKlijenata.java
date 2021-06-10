package elektronskoPoslovanje;

public class SpisakKlijenata {
	private String[] nazivKlijenta;
	private int trenutniBrojKlijenata;
	private int maxBrojKlijenata;
	
	SpisakKlijenata(){}
	
	SpisakKlijenata(int maxBrojKlijenata){
		this.maxBrojKlijenata = maxBrojKlijenata;
		this.trenutniBrojKlijenata = 0;
		this.nazivKlijenta = new String[maxBrojKlijenata];
	}
	
	public String nadjiKlijenta(String nazivKlijenta) {
		int i;
		for (i = 0; i < this.trenutniBrojKlijenata; i++) {
			if (this.nazivKlijenta[i] == nazivKlijenta) {
				return this.nazivKlijenta[i];
			}
		}
		return ("Klijent nije pronadjen!");
	}
	
	public void dodajKlijenta(String nazivKlijenta) {
		if (trenutniBrojKlijenata < maxBrojKlijenata) {
			this.nazivKlijenta[this.trenutniBrojKlijenata++] = nazivKlijenta;
			System.out.println("Uspesno dodat klijent " +nazivKlijenta+"!");
		}
		else{
			System.out.println("Nema vise mesta u spisku klijenata!");
		}
	}
}
