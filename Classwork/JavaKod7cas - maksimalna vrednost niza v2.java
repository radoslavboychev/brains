// Maksimalna vrednost u nizu i njegova pozicija, verzija 2:
	int N = 1, i;
  int NizPrirordnihBrojeva[] = new int[MAXELNIZA];
  int maks;
  int pozMaks;

  pozMaks = 0;
      
  System.out.println("Program za racunanje sume elemenata niza N prirodnih brojeva.");
  System.out.print("Unesite N:\t"); // prihvati broi elemenata niza
  N = TextIO.getlnInt();
      
  for (i = 0; i < N; i++){ // prihvati elemente niza od korisnika
    System.out.println("Unesite " + (i+1) + ". element niza:\t");
    NizPrirordnihBrojeva[ i ] = TextIO.getlnInt();
  }   
  pozMaks = 0;
  for (i = 0; i < N; i++)
    if (NizPrirordnihBrojeva[pozMaks] < NizPrirordnihBrojeva[i])
      pozMaks = i;
  System.out.println("Najveću vrednost, " + NizPrirordnihBrojeva[pozMaks] + ", ima "+ pozMaks+1 +". element niza.");
//------------------------------------------------------------------------------------
