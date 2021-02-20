package computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Computer myComp1 = new Computer("Intel Core i3", 3.54, 5300);
		Computer myComp2 = new Computer("AMD GamerXD 3521", 2.14, 16000);

		// this uses the default constructor which sets everything to 0 or null
		Computer myComp3 = new Computer();

		Computer myComp4 = new Computer("AMD Ryzen Pro 1300", 3.5, 2560);
		Computer myComp5 = new Computer("Intel Core i5 KJRN", 5.4, 512);
		Computer myComp6 = new Computer("AMD Ryzen 9 5900X", 3.7, 1028);
		Computer myComp7 = new Computer("Intel Core i7 10700K", 5.6, 10506);

	//creates an arrayList of type Computer and adds the objects to the list
		ArrayList<Computer> alComputers = new ArrayList<Computer>();

		alComputers.add(myComp1);
		alComputers.add(myComp2);
		alComputers.add(myComp3);
		alComputers.add(myComp4);
		alComputers.add(myComp5);
		alComputers.add(myComp6);
		alComputers.add(myComp7);

		//foreach computer in the array -> printinfo
		for (Computer c : alComputers) {

			c.printInfo();
		}
		
		

	}

}
