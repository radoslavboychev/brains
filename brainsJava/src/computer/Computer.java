package computer;

public class Computer {

	String processor;
	double clockSpeed;
	int memorySize;
	double indexPerformance;

	void setClockSpeed(String processorName, double clockSpeed) {
		this.processor = processorName;
		this.clockSpeed = clockSpeed;

	}

	void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	void calculateIndexPerformance(double clockSpeed, int memorySize) {

		indexPerformance = 10 * (clockSpeed + memorySize);

	}

	void printInfo() {
		System.out.println("+++++\nProcessor: " + processor + "\nProcessing speed: " + clockSpeed + " \nMemory size: "
				+ memorySize);
		calculateIndexPerformance(clockSpeed, memorySize);
		System.out.println("The index performance is: " + indexPerformance);
		System.out.println("-----");
	}
}
