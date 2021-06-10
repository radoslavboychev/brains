
public class Osiguranje {
	
	static final int KATEGORIJE =5;
	static final int DANI =30;

	public static void main(String[] args) {
		
		double [][] EvidencijaOsiguranja = new double [DANI][KATEGORIJE];
		int izbor;
		
		do {
			prikazMenija();
			
			
			izbor = napraviIzbor (" " , 0 , 7);
		
		
		switch (izbor ){
		case 1: unesiPrihod(EvidencijaOsiguranja);
			break;
		case 2 : izmeniPrihod(EvidencijaOsiguranja);
			break;
		case 3 : prikazKategorijeZaDan(EvidencijaOsiguranja);
			break;
		case 4 : prikazDanaZaKategoriju(EvidencijaOsiguranja);
			break;
		case 5 : danSaNajmanjimPrihodom(EvidencijaOsiguranja);
			break;
		case 6 : prihodiKategorija(EvidencijaOsiguranja);
			break;
		case 7 : prosecniMesecniPrihod(EvidencijaOsiguranja);
			break;
		default : System.out.println(" Niste izabrali ni jednu od ponudjenih opcija");
		}
		
		} while (izbor !=0);
		
	}
	
	static int napraviIzbor (String poruka, int dole, int gore) {
		int vrati =0;
		
		System.out.println(poruka);
		
		do {
			vrati = TextIO.getlnInt();
			if ((vrati < dole) || (vrati > gore))
				System.out.println(" Morate uneti vrednost u opsegu (" +dole+"-"+gore+")");
		}
		while ((vrati < dole) || (vrati > gore));
		
		return vrati;
	}
	
	
		
		static void prikazMenija() {
			System.out.println("Program za praćenje poslovanja agenta za osiguranje.");
			System.out.println(" Opcija 0 : Izlaz iz programa. ");
			System.out.println(" Opcija 1 : Unos ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu. ");
			System.out.println(" Opcija 2 : Izmenu ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu. ");
			System.out.println(" Opcija 3 : Prikaz rezultata sortiran po kategorijama osiguranja za izabrani dan u mesecu.");
			System.out.println(" Opcija 4 : Prikaz rezultata sortiran po danima u mesecu za izabranu kategoriju.");
			System.out.println(" Opcija 5 : Izračunavanje i prikaz dana kad je ostvaren najmanji prihod i koliko on iznosi.");
			System.out.println(" Opcija 6 : Izračunavanje i prikaz ukupnog mesečnog prihod za svaku kategoriju osiguranja.");
			System.out.println(" Opcija 7 : Izračunavanje i prikaz prosečnog mesečnog prihoda.");
			System.out.println(" Izaberite neku od gore navedenih opcija opcija :");
		}
		
		

		static void unesiPrihod( double [][] EvidencijaOsiguranja) {
			System.out.println(" Unesite zeljeni dan za evidenciju prihoda :");
			int DANI =TextIO.getlnInt();
			System.out.println(" Unesite zeljenu kategoriju osiguranja za ostvareni prihod " + DANI + " dana :");
			int KATEGORIJE =TextIO.getlnInt();
			System.out.println(" Unesite prihod za dan : " + DANI + " u kategoriji " +  KATEGORIJE);
			EvidencijaOsiguranja[DANI][KATEGORIJE] = TextIO.getlnDouble();
			
				
		}
		
		static void izmeniPrihod(double [][] EvidencijaOsiguranja) {
			System.out.println(" Unesite dan za koji zelite da izmenite ostvareni prihod :");
			int DANI =TextIO.getlnInt();
			System.out.println(" Unesite kategoriju osiguranja koju zelite da izmenite izabranog " + DANI + " dana : " );
			int KATEGORIJE =TextIO.getlnInt();
			System.out.println(" Unesite izmenu za prihod dana : " + DANI + " u kategoriji " +  KATEGORIJE);
			EvidencijaOsiguranja[DANI][KATEGORIJE] += TextIO.getlnDouble();
	}
		
		static void prikazKategorijeZaDan (double [][] EvidencijaOsiguranja) {
			System.out.println("Uneti koji dan u mesecu zelite da prikazete :");
			int DANI =TextIO.getlnInt();
			for (int j=0; j<KATEGORIJE; j++)
				System.out.println("[" + EvidencijaOsiguranja[DANI][j] + "]" + " ");
			
		}
		
		
		
		static void prikazDanaZaKategoriju (double [][] EvidencijaOsiguranja) {
			System.out.println("Uneti koju kategoriju zelite da prikazete :");
			int KATEGORIJE =TextIO.getlnInt();
			System.out.println(" Prihodi po danima za " + (KATEGORIJE) + " . kategoriju su :");
			for (int i=0; i<DANI; i++) {
				System.out.println("[" + EvidencijaOsiguranja[i][KATEGORIJE-1] + "]" + " ");
			}
			System.out.println("[" + EvidencijaOsiguranja[DANI-1][KATEGORIJE-1] + "]" + " ");
		}
		
		
		static void danSaNajmanjimPrihodom (double [][] EvidencijaOsiguranja) {
		double min=	EvidencijaOsiguranja[0][0];
		int dan=0;
		for  (int i=0; i<DANI; i++){
			for(int j=0;j<KATEGORIJE;j++) {
				if (EvidencijaOsiguranja[i][j]<min)
					min=EvidencijaOsiguranja[i][j];
				dan=i;
			}
		}
		System.out.println(" Dan sa najmanje prihoda je : " + (dan+1) + " . dan." );
			
		}
		
		
		static void prihodiKategorija (double [][] EvidencijaOsiguranja) {
			int i, j;
			double[] sumaKategorija = new double [KATEGORIJE];
			
			for (i=0; i<KATEGORIJE; i++) {
				sumaKategorija[i]=0;
				for (j=0; j<DANI ; j++) {
					sumaKategorija[i] += EvidencijaOsiguranja[j][i];
				}
				System.out.printf("Kategorija %d ima sumu %f\n" , i ,sumaKategorija[i] );
			}
		}
		
		
		
		static void prosecniMesecniPrihod (double [][] EvidencijaOsiguranja) {
			int i,j;
			double suma =0;
			
			for (i=0; i<KATEGORIJE ;i++) {
				for (j=0; j<DANI; j++) {
					suma +=EvidencijaOsiguranja[i][j];
				}
			}
			System.out.println(" Prosecni mesecni prihod svih kategorija je : " + (suma/DANI)  );
		}

}
