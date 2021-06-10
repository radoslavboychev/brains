package poslovanjeRestorana;

public class Narudzbina {
/* Narudžbina se sastoji od jedne ili više stavki iz jelovnika koje je naručio određeni klijent, kao i 
	 informacije o tome da li je narudžbina uspešno realizovana ili ne.*/
	int kolicina=0;
	Jelo porucenoJelo;
	boolean realizovana;
	Klijent porucilac;
	Narudzbina (){
		
	}

Narudzbina (Klijent porucilac,Jelo porucenoJelo,int kolicina, boolean realizovana){
	this.kolicina=kolicina;
	this.porucenoJelo=porucenoJelo;
	this.realizovana=realizovana;
	this.porucilac=porucilac;
	
}

public Klijent getPorucilac() {
	return porucilac;
}

public void setPorucilac(Klijent porucilac) {
	this.porucilac = porucilac;
}

public int getKolicina() {
	return kolicina;
}

public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}

public Jelo getPorucenoJelo() {
	return porucenoJelo;
}

public void setPorucenoJelo(Jelo porucenoJelo) {
	this.porucenoJelo = porucenoJelo;
}

public boolean isRealizovana() {
	return realizovana;
}

public void setRealizovana(boolean realizovana) {
	this.realizovana = realizovana;
}
public String toString() {						// toString radi stampanja :)
	return "Klijent: "+porucilac.getIme()+
			" "+porucilac.getPrezime()+" je porucio/la  "+porucenoJelo.getImeJela() +" jelo/pice za "+ kolicina+" osoba"; 
}
}

