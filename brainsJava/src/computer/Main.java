package computer;

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

//		myComp1.setClockSpeed("AMD Ryzen 1300", 3.45);
//		myComp1.setMemorySize(1024);
//		myComp1.getClockSpeed();
//		myComp2.setClockSpeed("Intel Core i5 Q4K3", 2.42);
//		myComp2.setMemorySize(512);

		// now to print the info for all PCs
		myComp1.printInfo();
		myComp2.printInfo();
		myComp3.printInfo();
		myComp4.printInfo();
		myComp5.printInfo();
		myComp6.printInfo();
		myComp7.printInfo();
		
		System.out.println(myComp1.compareTo(myComp2));

	}

}
