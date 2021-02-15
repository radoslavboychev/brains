package computer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer myComp1 = new Computer();
		Computer myComp2 = new Computer();
		Computer myComp3 = new Computer();
		Computer myComp4 = new Computer();
		Computer myComp5 = new Computer();
		
		myComp1.setClockSpeed("AMD Ryzen 1300", 3.45);
		myComp1.setMemorySize(1024);
		myComp1.calculateIndexPerformance(myComp1.clockSpeed, myComp1.memorySize);
		
		myComp2.setClockSpeed("Intel Core i5 Q4K3", 2.42);
		myComp2.setMemorySize(512);
		myComp2.calculateIndexPerformance(myComp2.clockSpeed, myComp2.memorySize);
		
		myComp3.setClockSpeed("Intel Core i3 S45P", 1.45);
		myComp3.setMemorySize(2048);
		myComp3.calculateIndexPerformance(myComp3.clockSpeed, myComp3.memorySize);
		
		myComp4.setClockSpeed("AMD Ryzen 2412AB", 4.50);
		myComp4.setMemorySize(8148);
		myComp4.calculateIndexPerformance(myComp4.clockSpeed, myComp4.memorySize);
		
		myComp5.setClockSpeed("AMD Pro Gamer Epic", 9.50);
		myComp5.setMemorySize(10240);
		myComp5.calculateIndexPerformance(myComp5.clockSpeed, myComp5.memorySize);
	}

}
