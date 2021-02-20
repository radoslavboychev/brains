package computer;

import java.util.Comparator;

public class Computer {

	private String processor;
	private double clockSpeed;
	private int memorySize;
	private double indexPerformance;

	// sets the processor info (clock speed and name)
	public void setClockSpeed(String processorName, double clockSpeed) {
		this.processor = processorName;
		this.clockSpeed = clockSpeed;
	}

	// some default constructor, not sure if necessary :/
	public Computer() {
	}

	// constructor for the computer, sets the processor, clock speed, memory size
	// and
	// calculates the performance index
	public Computer(String processor, double clockSpeed, int memorySize) {
		this.processor = processor;
		this.clockSpeed = clockSpeed;
		this.memorySize = memorySize;
		this.indexPerformance = calculateIndexPerformance();
	}

	// sets the memory size
	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	// calculate the index performance to be used in the constructor or by itself
	public double calculateIndexPerformance() {

		return indexPerformance = 10 * (clockSpeed + memorySize);

	}

	// prints the info for the computer
	void printInfo() {
		System.out.println("+++++\nProcessor: " + processor + "\nProcessing speed: " + clockSpeed + " \nMemory size: "
				+ memorySize);
		calculateIndexPerformance();
		System.out.println("The index performance is: " + indexPerformance);
		System.out.println("-----");
	}

	// getter for the processor name
	public String getProcessorName() {
		return processor;
	}

	// getter for clock speed
	public double getClockSpeed() {
		return clockSpeed;
	}

	// getter for the memory size
	public int getMemorySize() {
		return memorySize;
	}

	@Override
	public int compare(Computer o1, Computer o2) {

	return	o2.getMemorySize().compareTo(o1.getMemorySize());
		

	}

}
