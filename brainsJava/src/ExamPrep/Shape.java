package ExamPrep;

public abstract class Shape {

	private String color;
	private String type;
	private int numSides;

	// constructor
	public Shape(String color, String type, int numSides) {

		this.color = color;
		this.type = type;
		this.numSides = numSides;
	}

	// Getters and setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	public abstract void calculateVolume();

	public abstract void calculateSurface();

}
