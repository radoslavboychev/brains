package javaclass2;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Conditionals1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		Scanner myScanner = new Scanner(System.in);
//		
//		int n;
//		n = myScanner.nextInt();
//		
//		if(n>=0)
//		{
//			if(n>3)
//				System.out.println("Up");
//			else {
//				System.out.println("Middle");
//			}
//		}
//		else {
//			System.out.println("Down");
//		}
//		
		
//		
//		/* Definicija promenljive */
//		int ocena;
//		/* Unos podatka */
//		System.out.println("Program za ispis uspeha na osnovu unete ocene!");
//		System.out.print("Unesite ocenu: ");
//		ocena = TextIO.getlnInt();
//		/* Odredjivanje uspeha i ispis */
//		if (ocena == 1)
//		System.out.println("Nedovoljan!");
//		else if (ocena == 2)
//		System.out.println("Dovoljan!");
//		else if (ocena == 3)
//		System.out.println("Dobar!");
//		else if (ocena == 4)
//		System.out.println("Vrlo dobar!");
//		else
//		System.out.println("Odlican!");

		
//		/* Definicija promenljive */
//		int ocena;
//		/* Unos podatka */
//		System.out.println("Program za ispis uspeha na osnovu unete ocene!");
//		System.out.print("Unesite ocenu: ");
//		ocena = TextIO.getlnInt();
//		/* Odredjivanje uspeha i ispis */
//		
//		int a,b,c,d,x1,x2,y1,y2;	
//		
//		switch (a){
//
//		case 0: System.out.println("Nedovoljan");
//			break;
//		case 2: System.out.println("Dovoljan!");
//			break;
//		case 3: System.out.println("Dobar!");
//			break;
//		case 4: System.out.println("Vrlo dobar!");
//			break;
//		case 5: System.out.println("Odlican!");
//			break;
//		default: System.out.println("benis");
//	}
		int ocena;
		System.out.println("Program za ispis uspeha na osnovu unete ocene!");
		// do-while petlja se koristi da se proveri ulazna vrednost
		do{
		System.out.print("Unesite ocenu: ");
		ocena = TextIO.getlnInt();
		if ((ocena < 1)||(ocena > 5))
		System.out.println("Ocena mora biti izmedju 1 i 5.");
		} while ((ocena < 1)||(ocena > 5));
		switch (ocena){
		case 1: System.out.println("Nedovoljan!");
		break;
		case 2: System.out.println("Dovoljan!");
		break;
		case 3: System.out.println("Dobar!");
		break;
		case 4: System.out.println("Vrlo dobar!");
		break;
		case 5: System.out.println("Odlican!");
	}

}
}
