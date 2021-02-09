// metode za manipulaciju nizom
	public static void main(String[] args) {
		int velNiza;
		int[] niz;
		
		// preuzimanje veličine niza od korisnika
		velNiza = preuzmiIntSaPorukom("Unesi veličinu niza: ");
		
		// zauzimanje memorija koja odgovara nizu i popunjavanje elemenata niza od strane korisnika
		//niz = napraviNiz(velNiza);
		
		// zauzimanje memorija koja odgovara nizu 
		niz = new int[velNiza];
		// popunjavanje elemenata niza od strane korisnika
		popuniNiz(velNiza, niz);
		
		// ispisivanje (prikaz) elemanata niza
		ispitsNiz(niz);
		
	}
	
	static int preuzmiIntSaPorukom(String poruka) {
		int vrednost;
		System.out.println(poruka);
		vrednost = TextIO.getlnInt();
		return vrednost;
	}
	
	static int[] napraviNiz(int n) {
		int i = 0;
		int[] noviNiz = new int[n];
		
		System.out.println("Unesite "+n+" elemenata niza: ");
		System.out.println();
		for (i = 0; i < noviNiz.length; i++) {
			System.out.print("Unesite "+(i+1)+". element niza->");
			noviNiz[i] = TextIO.getlnInt();
		}
		return noviNiz;
	}
	
	static void ispitsNiz(int[] pNiz) {
		int i;
		System.out.print("[");
		for (i = 0; i < pNiz.length-1; i++)
			System.out.print(pNiz[i]+",");
		System.out.println(pNiz[i]+"]");
	}
	
	static void popuniNiz(int n, int[] pNiz) {
		int i = 0;

		System.out.println("Unesite "+n+" elemenata niza: ");
		System.out.println();
		for (i = 0; i < pNiz.length; i++) {
			System.out.print("Unesite "+(i+1)+". element niza->");
			pNiz[i] = TextIO.getlnInt();
		}
	}