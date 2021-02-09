// Pozicija maksimalnog elementa niza pri čemu se uzima u obzir da može biti više pozicija::
	final int MAXELNIZA = 50; // final sluzi da oznaci vrednost koja se vise ne moze menjati
  int N = 1, i, brojMaksimuma;
  int NizPrirordnihBrojeva[] = new int[MAXELNIZA];
  int[] pozMaks;
      
  System.out.println("Program za racunanje sume elemenata niza N prirodnih brojeva.");
  System.out.print("Unesite N:\t"); // prihvati broi elemenata niza
  N = TextIO.getlnInt();
      
  for (i = 0; i < N; i++){ // prihvati elemente niza od korisnika
    System.out.println("Unesite " + (i+1) + ". element niza:\t");
    NizPrirordnihBrojeva[ i ] = TextIO.getlnInt();
  }   
      
  pozMaks = new int[N];
      
  pozMaks[0] = 0;
  brojMaksimuma = 1;
      
  for (i = 1; i < N; i++)
    if (NizPrirordnihBrojeva[pozMaks[0]] < NizPrirordnihBrojeva[i]) {
      pozMaks[0] = i;
      brojMaksimuma = 1;
    }
    else if(NizPrirordnihBrojeva[pozMaks[0]] == NizPrirordnihBrojeva[i]) {
      pozMaks[brojMaksimuma] = i;   
      brojMaksimuma++;
    }
         
  if (brojMaksimuma == 1)
    System.out.println("Otkriven je jedan maksimum na poziciji "+(pozMaks[0]+1)+". i ima vrednost: "+NizPrirordnihBrojeva[pozMaks[0]]+".");
  else {
    System.out.println("Otkriveno je ukupno "+brojMaksimuma+"maksimuma sa vrednošću "+NizPrirordnihBrojeva[pozMaks[0]]+"koja se nalazi na pozicijama:");
    for(i=0; i < brojMaksimuma; i++)
      if (i < brojMaksimuma-1)
        System.out.print((pozMaks[i]+1) + ", ");
      else
        System.out.print((pozMaks[i]+1) + ".");
  }