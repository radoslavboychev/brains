package oaiguranje;

public class Osiguranje {

	static final int KATEGORIJE = 5;
	static final int DANI = 30;

	public static void main(String[] args) {

		double[][] evidencijaOsiguranja = { { 34, 45, 65, 54, 43 }, { 34, 54, 32, 54, 32 }, { 54, 43, 55, 76, 43 },
				{ 54, 54, 32, 57, 43 }, { 76, 54, 32, 87, 43 }, { 65, 43, 87, 45, 32 }, { 54, 43, 76, 43, 87 },
				{ 54, 43, 76, 43, 86 }, { 54, 36, 43, 87, 98 }, { 34, 54, 32, 76, 98 }, { 34, 54, 76, 87, 98 },
				{ 23, 43, 54, 32, 65 }, { 34, 65, 32, 65, 32 }, { 34, 65, 43, 43, 75 }, { 34, 54, 76, 32, 65 },
				{ 34, 65, 54, 67, 87 }, { 12, 24, 32, 43, 32 }, { 87, 56, 43, 32, 43 }, { 65, 54, 32, 21, 23 },
				{ 45, 43, 54, 32, 21 }, { 87, 65, 43, 32, 23 }, { 34, 54, 32, 54, 43 }, { 34, 54, 43, 32, 43 },
				{ 76, 45, 32, 32, 54 }, { 45, 34, 32, 54, 32 }, { 54, 43, 32, 24, 43 }, { 34, 54, 33, 43, 32 },
				{ 54, 43, 54, 43, 54 }, { 35, 43, 23, 32, 43 }, { 65, 54, 43, 32, 54 } };
		int izbor;

		do {
			prikaziMeni();

			izbor = napraviIzbor("", 0, 7);

			switch (izbor) {
			case 1:
				unesiPrihod(evidencijaOsiguranja);
				break;
			case 2:
				izmeniPrihod(evidencijaOsiguranja);
				break;
			case 3:
				System.out.println("Unesite dan za koji zelite da sortirate prihode:");
				int dan = TextIO.getInt();
				sortiranjePoKategorijama(evidencijaOsiguranja, dan);
				break;
			case 4:
				System.out.println("Unesite kategoriju za koju zelite da sortirate prihode:");

				int kategorija = TextIO.getInt();
				sortiranjePoDanima(evidencijaOsiguranja, kategorija);
				break;
			case 5:
				najmanjiPrihod(evidencijaOsiguranja);
				break;
			case 6:
				mesecniPrihodPrikaz(evidencijaOsiguranja);
				break;
			case 7:
				prosecniPrihod(evidencijaOsiguranja);
				break;

			}

		} while (izbor != 0);

	}

	static void prikaziMeni() {
		System.out.println("MENI");
		System.out.println("1. Unos ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu");
		System.out.println("2. Izmena ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu");
		System.out.println("3. Sortiranje po kategorijama osiguranja za izabrani dan u mesecu");
		System.out.println("4. Sortiranje po danima u mesecu za izabranu kategoriju");
		System.out.println("5. Dan kad je ostvaren najmanji prihod i koliko on iznosi");
		System.out.println("6. Ukupan mesecni prihod za svaku kategoriju osiguranja");
		System.out.println("7. Prosecan mesecni prihod\n");
		System.out.print("Izaberite operaciju:\t");

	}

	static int napraviIzbor(String poruka, int dole, int gore) {
		int vrati = 0;
		System.out.println(poruka);

		do {
			vrati = TextIO.getInt();
			if (vrati < dole || vrati > gore) {
				System.out.println("Moreti uneti vretnost u opsegu (" + dole + "-" + gore + ")");

			}

		} while (vrati < dole || vrati > gore);
		return vrati;
	}

	static void unesiPrihod(double[][] evidencijaOsiguranja) {
		int ponavljanje = 0;
		do {
			System.out.println("Unesite dan za koji zelite da unesete prihod:");
			int dan = TextIO.getInt();
			System.out.println("Unesite kategoriju za koju zelite da unesete prihod:");
			int kategorija = TextIO.getInt();
			evidencijaOsiguranja[dan - 1][kategorija - 1] = TextIO.getDouble();
			System.out.println("Ukoliko zelite da unesete jos neki prihod, unesite 0.");
			ponavljanje = TextIO.getInt();

		} while (ponavljanje == 0);

	}

	static void izmeniPrihod(double[][] evidencijaOsiguranja) {
		int ponavljanje = 0;
		do {
			System.out.println("Unesite dan za koji zelite da izmenite prihod:");
			int dan = TextIO.getInt();
			System.out.println("Unesite kategoriju za koju zelite da izmenite prihod:");
			int kategorija = TextIO.getInt();
			evidencijaOsiguranja[dan - 1][kategorija - 1] += TextIO.getDouble();
			System.out.println("Ukoliko zelite da izmenite jos neki prihod, unesite 0.");
			ponavljanje = TextIO.getInt();

		} while (ponavljanje == 0);
	}

	static void sortiranjePoKategorijama(double[][] evidencijaOsiguranja, int dan) {
		double[] a = new double[5]; // pomocni niz koji pamti prihode po katgorijama za zadati dan
		int[] b = new int[5]; // redni brojevi kategorija
		int i, j;
		double tmp;
		int tmp2;
		for (i = 0; i < 5; i++) {
			a[i] = evidencijaOsiguranja[dan - 1][i];
			b[i] = i;
		}

		for (i = 0; i < 4; i++) {
			for (j = i + 1; j < 5; j++) {
				if (a[i] < a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					tmp2 = b[i];
					b[i] = b[j];
					b[j] = tmp2;
				}
			}
		}

		System.out.println("Prihodi po kategorijama za " + dan + ". dan su: ");
		for (i = 0; i < 5; i++) {
			System.out.println((b[i] + 1) + ". kategorija:\t" + a[i]);
		}

	}

	static void sortiranjePoDanima(double[][] evidencijaOsiguranja, int kategorija) {
		double[] a = new double[30];
		int[] b = new int[30];
		int i, j;
		double tmp;
		int tmp2;
		for (i = 0; i < 30; i++) {
			a[i] = evidencijaOsiguranja[i][kategorija - 1];
			b[i] = i;
		}

		for (i = 0; i < 29; i++) {
			for (j = i + 1; j < 30; j++) {
				if (a[i] < a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					tmp2 = b[i];
					b[i] = b[j];
					b[j] = tmp2;
				}
			}
		}

		System.out.println("Prihodi po danima za " + kategorija + ". kategoriju su: ");
		for (i = 0; i < 30; i++) {
			System.out.println((b[i] + 1) + ". dan:                  " + a[i]);
		}

	}

	static void najmanjiPrihod(double[][] evidencijaOsiguranja) {
		int i, j;
		double min = 0;
		double suma;
		int[] pozicije = new int[30];
		int k = 0;
		for (j = 0; j < 5; j++) {
			min += evidencijaOsiguranja[0][j];
		}
		for (i = 1; i < 30; i++) {
			suma = 0;
			for (j = 0; j < 5; j++) {
				suma += evidencijaOsiguranja[i][j];
			}
			if (min > suma) {
				min = suma;
			}
		}

		for (i = 0; i < 30; i++) {
			suma = 0;
			for (j = 0; j < 5; j++) {
				suma += evidencijaOsiguranja[i][j];
			}
			if (suma == min) {
				pozicije[k] = i;
				k++;
			}
		}
		System.out.println("Najamnji prihod iznosi:\t" + min + " i ostavren je danima: ");
		for (i = 0; i < k; i++) {
			System.out.println((pozicije[i] + 1) + ". dan");
		}
	}

	static double[] mesecniPrihodIznos(double[][] evidencijaOsiguranja) {
		double[] kat = new double[5];
		int i, j;

		for (j = 0; j < 5; j++) {
			kat[j] = 0;
			for (i = 0; i < 30; i++) {
				kat[j] += evidencijaOsiguranja[i][j];
			}
		}
		return kat;
	}

	static void mesecniPrihodPrikaz(double[][] evidencijaOsiguranja) {
		double[] a = new double[5];
		int i;
		for (i = 0; i < 5; i++) {
			a[i] = mesecniPrihodIznos(evidencijaOsiguranja)[i];
			System.out.println("Ukupan mesecni prihod za " + (i + 1) + ". kategoriju iznosi:   " + a[i]);
		}
	}

	static void prosecniPrihod(double[][] evidencijaOsiguranja) {
		System.out.println("Ovde ce ici prosecni mesecni prihod.");
	}
}