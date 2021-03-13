package institucija;

public class Main {

	public static void main(String[] args) {
		
		Institucija ftn = new Institucija("FTN", "Trg Dositeja Obradovica 6, Novi Sad", "123456", new Zaposleni("Srdjan", "Kolakovic", 62, 8.0));
		
		ftn.dodajUcionicu("A1", "amfiteatar", 300, 200.0, false);
		ftn.dodajUcionicu("MI A2-1", "kabinet", 32, 50.0, true);
		ftn.dodajRacunarUUcionicu("MI A-21", "Intel", 2.0, 16);
		ftn.dodajRacunarUUcionicu("MI A-21", "AMD", 3.0, 32);
		ftn.dodajZaposlenog("Dusan", "Gajic", 38, 4.0);
		ftn.dodajZaposlenog("Dinu", "Dragan", 42, 6.0);
		ftn.prikaziPodatke();
		
	}
}
