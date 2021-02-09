import java.util.Scanner;

public class smallestElement {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
	Scanner myScanner = new Scanner(System.in);
//
//		int[] myArray = new int[10];
//		int min = 1;
//
//		for (int i = 0; i < myArray.length; i++) {
//
//			System.out.print("Element " + i + " is: ");
//			myArray[i] = myScanner.nextInt();
//
//			if (min > myArray[i]) {
//
//				min = myArray[i];
//
//			}
//			
//		}
//		System.out.print("Min is: " + min);
		
		final int MAXNIZA = 20;
		   
		  int[] niz = new int[MAXNIZA];
		  int tmp;
		  int i, j, brElem;
		   
		  System.out.println("Program za sortiranje niza prirodnih brojeva.\n\n");
		  System.out.println("Unesite broj elemenata:\t"); // prihvati broj vrsta i kolona
		  brElem = myScanner.nextInt();
		  for (i = 0; i < brElem; i++) { // prihvati elemente matrice od korisnika
		    System.out.println("Unesite element niza na koordinati [" + (i+1) + "]:\t");
		    niz[i] = myScanner.nextInt();
		  }
		      
		  System.out.println("Elementi niza pre sortiranja su:");
		  System.out.print("{ ");
		  for (i = 0; i < brElem; i++) {
		    System.out.print(niz[i] +" ");
		  }
		  System.out.println("} ");
		  
		  for (i=0; i < brElem-1; i++) {
		    for (j=i+1; j < brElem; j++) {
		      if (niz[i] > niz[j]) {
		        tmp = niz[i];
		        niz[i] = niz[j];
		        niz[j] = tmp;
		      }    
		    }
		  }
		  System.out.println();
		      
		  System.out.println("Elementi niza posle sortiranja su:");
		  System.out.print("{ ");
		  for (i = 0; i < brElem; i++) {
		    System.out.print(niz[i] +" ");
		  }
		  System.out.println("} ");
	}
}