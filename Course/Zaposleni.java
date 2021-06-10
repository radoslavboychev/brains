package elektronskoPoslovanje;

public class Zaposleni {
	String ime; 
	String prezime;
	double koefRadnogMesta,plata;
	
	void postaviImePrezime(String i, String p){

		ime = i;
		prezime = p;

		}
	void koeficijent(double koef ){

		 koefRadnogMesta=koef ;
		 
		}
	void racunajPlatu() { 

		plata = koefRadnogMesta *2500  ;

		}
	void stampajPlatu(){ 
		System.out.println("Zaposleni " + ime +" "+ prezime
		+ " - ima platu: " + plata);

		}

}
