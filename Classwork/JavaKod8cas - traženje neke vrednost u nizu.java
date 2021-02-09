// Primer operacije traženja neke vrednosti u nizu:
	final int MAXNIZA = 20;
   
  int[] niz = new int[MAXNIZA];
  int brElem = 0;
  int i, koliko = 0;
  int traziBroj;
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
  System.out.println("Unesite broj koji se traži u nizu:\t"); // prihvati broj vrsta i kolona
  traziBroj = TextIO.getlnInt();
   
  for (i = 0; i < brElem; i++)
    if (traziBroj == niz[i]) {
      pozicijaBroja[koliko++] = i;
    }
   
  System.out.println();
  System.out.println();
   
  System.out.println(" Elemenati niza su:");
  System.out.print(" { ");
  for (i = 0; i < brElem; i++)
    System.out.print(niz[i] +" ");
  System.out.println(" } ");
   
  System.out.println(" Broj " + traziBroj + " se u nizu pojavljuje "+koliko+" puta.");
   
  System.out.println(" Broj se nalazi na sledećim pozicijama:");
  System.out.print(" [ ");
  for (i = 0; i < koliko; i++)
    System.out.print((pozicijaBroja[i]+1) +" ");
  System.out.println("] ");
//------------------------------------------------------------------------------------