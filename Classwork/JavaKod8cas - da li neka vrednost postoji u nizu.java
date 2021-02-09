// Primer provera da li neka vrednost posoji ili ne u nizu :
		final int MAXNIZA = 20;
		   
		int[] niz = new int[MAXNIZA];
		int brElem = 0;
		int i;
		int traziBroj;
		int[] pozicijaBroja =  new int[MAXNIZA];
		
		System.out.println("Program za pretraživanje niza prirodnih brojeva.\n\n");
		System.out.println("Unesite broj elemenata:\t"); // prihvati broj elemenata niza
		brElem = TextIO.getlnInt();
		for (i = 0; i < brElem; i++) { // prihvati elemente niza od korisnika
		    System.out.println("Unesite element niza na koordinati [" + (i+1) + "]:\t");
		    niz[i] = TextIO.getlnInt();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Unesite broj koji se traži u nizu:\t"); // prihvati broj koji se tra#i
		traziBroj = TextIO.getlnInt();
		
		i = 0;
		
		while ((i< brElem)&&(niz[i] != traziBroj))
			i++;
		
		if (i< brElem)
			System.out.println("Našao sam ga! Na poziciji " + (i+1));
		else
			System.out.println("Nisam ga našao!");

