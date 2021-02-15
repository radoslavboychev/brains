package computer;

public class Main {

	public static void main(String[] args) {

		Computer myComp1 = new Computer();
		Computer myComp2 = new Computer();
		Computer myComp3 = new Computer();
		Computer myComp4 = new Computer();
		Computer myComp5 = new Computer();

		myComp1.setClockSpeed("AMD Ryzen 1300", 3.45);
		myComp1.setMemorySize(1024);
		myComp1.printInfo();

		myComp2.setClockSpeed("Intel Core i5 Q4K3", 2.42);
		myComp2.setMemorySize(512);
		myComp2.printInfo();

		myComp3.setClockSpeed("Intel Core i3 S45P", 1.45);
		myComp3.setMemorySize(2048);
		myComp3.printInfo();

		myComp4.setClockSpeed("AMD Ryzen 2412AB", 4.50);
		myComp4.setMemorySize(8148);
		myComp4.printInfo();

		myComp5.setClockSpeed("AMD Pro Gamer Epic", 9.50);
		myComp5.setMemorySize(10240);
		myComp5.printInfo();

		
	}

}
