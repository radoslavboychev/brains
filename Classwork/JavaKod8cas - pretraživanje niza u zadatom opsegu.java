// Primer operacije pretraživanja neke vrednosti u nizu (traženje da li se vrednost nalazi u nekom opsegu):
	final int MAXNIZA = 20;

  int[] niz = new int[MAXNIZA];
  int brElem = 0;
  int i, koliko = 0;
  int traziBrojGornji, traziBrojDonji;
  int[] pozicijaBroja =  new int[MAXNIZA];

  System.out.println("Program za pretraživanje niza prirodnih brojeva.\n\n");
  System.out.println("Unesite broj elemenata:\t"); // prihvati broj vrsta i kolona
  brElem = TextIO.getlnInt();
  for (i = 0; i < brElem; i++) { // prihvati elemente matrice od korisnika
    System.out.println("Unesite element niza na koordinati [" + (i+1) + "]:\t");
    niz[i] = TextIO.getlnInt();
  }
  System.out.println();
  System.out.println();
  System.out.println("Unesite gornju vrednost broja koji se traži u nizu:\t");
  traziBrojGornji = TextIO.getlnInt();
  System.out.println("Unesite donju vrednost broja koji se traži u nizu:\t");
  traziBrojDonji = TextIO.getlnInt();

  for (i = 0; i < brElem; i++)
    if ((traziBrojDonji < niz[i])&&(niz[i] < traziBrojGornji)) {
      pozicijaBroja[koliko++] = i; // pozicijaBroja[koliko] = i; koliko++;
    }

  System.out.println();
  System.out.println();

  System.out.println(" Elemenati niza su:");
  System.out.print(" { ");
  for (i = 0; i < brElem; i++)
    System.out.print(niz[i] +" ");
  System.out.println(" } ");

  System.out.println(" U opsegu [ " + traziBrojDonji + " , " + traziBrojGornji + " ] se nalazi " + koliko + " broja.");

  System.out.println(" To su sledeći brojevi (i njihove pozicije):");
  for (i = 0; i < koliko; i++)
    System.out.println("["+(pozicijaBroja[i]+1) +"] = "+niz[pozicijaBroja[i]]);
//------------------------------------------------------------------------------------
