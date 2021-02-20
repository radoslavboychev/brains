package computer;

public class Computer implements Comparable<Computer> {

	private String processor;
	private double clockSpeed;
	private int memorySize;
	private double indexPerformance;

	// sets the processor info (clock speed and name)
	void setClockSpeed(String processorName, double clockSpeed) {
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
		calculateIndexPerformance(clockSpeed, memorySize);
	}

	// sets the memory size
	void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	// calculate the index performance to be used in the constructor or by itself
	public double calculateIndexPerformance(double clockSpeed, int memorySize) {

		return indexPerformance = 10 * (clockSpeed + memorySize);

	}

	// prints the info for he computer
	void printInfo() {
		System.out.println("+++++\nProcessor: " + processor + "\nProcessing speed: " + clockSpeed + " \nMemory size: "
				+ memorySize);
		calculateIndexPerformance(clockSpeed, memorySize);
		System.out.println("The index performance is: " + indexPerformance);
		System.out.println("-----");
	}

	// getter for the processor name
	public String getProcessorName() {
		return this.processor;
	}

	// getter for clock speed
	public double getClockSpeed() {
		return this.clockSpeed;
	}

	// getter for the memory size
	public int getMemorySize() {
		return this.memorySize;
	}

	@Override
	public int compareTo(Computer c) {
		double ip = calculateIndexPerformance(clockSpeed, memorySize)
				- c.calculateIndexPerformance(clockSpeed, memorySize);

		if (ip > 0) {
			return 1;
		} else if (ip < 0) {

			return -1;
		} else
			return 0;

	}

}
