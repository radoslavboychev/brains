package computer;

public class Computer {

	//variables
	private String processor;
	private double clockSpeed;
	private int memorySize;
	private double performanceIndex;

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
		this.performanceIndex = getPerformanceIndex();
	}

	// sets the memory size
	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	// calculate the index performance to be used in the constructor or by itself
	public double getPerformanceIndex() {

		performanceIndex = 10 * (clockSpeed + memorySize);

		return performanceIndex;
	}

	// prints the info for the computer
	void printInfo() {
		System.out.println("+++++\nProcessor: " + processor + "\nProcessing speed: " + clockSpeed + " \nMemory size: "
				+ memorySize);
		getPerformanceIndex();
		System.out.println("The index performance is: " + performanceIndex);
		System.out.println("-----");
	}

	// a simplified version of the printInfo method
	public String toString() {

		return "{ Processor name: " + getProcessorName() + " Processor clock speed: " + getClockSpeed() + " RAM: "
				+ memorySize + " Performance index: " + getPerformanceIndex();
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

	// setter for the processor name
	public void setProcessorName(String processor) {
		this.processor = processor;
	}
	
	//setter for the clock speed
	public void setClockSpeed(double clockSpeed)
	{
		this.clockSpeed = clockSpeed;
	}

	
}
