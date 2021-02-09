// Prebrojavanje slova: 
  String str;  // linija teksta koju unosi korisnik.
  int ukSlova; // ukupan broj razlicitih slova u str tekstu.
	int ukPojSlova = 0; // broji koliko se puta jedno slovo pojavljuje u tekstu
  char slovo;  // Slovo iz alfabeta.
  int i;      // indeks slova u nizu karaktera string str.
  System.out.println("Unesite jedan red teskta:");
  str = TextIO.getln();
  str = str.toUpperCase();
  ukSlova = 0;
  System.out.println("Vas red teksta sadrzi sledeca slova:");
  System.out.println();
  System.out.print("  ");
  for ( slovo = 'A'; slovo <= 'Z'; slovo++ ) { // prolaz kroz karaktere u ASCII tabeli
    for ( i = 0; i < str.length(); i++ ) { // prolaz kroz string
      if ( slovo == str.charAt(i) ) { 
        ukPojSlova++;                    // za svako pojavljivanje slova u nizu karaktera povećava se vrednost brojača
      }            
    }
		if (ukPojSlova > 0) {                             // ako je pronađeno neko slovo ukPojSlova mora biti veći od nule
			System.out.print(slovo + "("+ukPojSlova+") ");  // ispis pronađenog slova i koliko puta se ono pojavljuje u ulaznom stringu
      ukSlova++;																			// povećanje ukupnog broja pronađenih slova
      ukPojSlova = 0;																	// da bi moglo da se broji koliko pojavljivanja 
    }
  }     
  System.out.println();
  System.out.println();
  System.out.println("Otkriveno je " + ukSlova + " razlicitih slova.");
//------------------------------------------------------------------------------------


