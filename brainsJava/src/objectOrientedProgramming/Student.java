package objectOrientedProgramming;

public class Student {

	String fName;
	String lName;
	double pointsTest1, pointsTest2, average;

	void setLastName(String i, String p) {
		fName = i;
		lName = p;
	}

	void setPoints(double pTest1, double pTest2) {
		pointsTest1 = pTest1;
		pointsTest2 = pTest2;
	}

	void calculateAverage() {
		average = (pointsTest1 + pointsTest2) / 2;
	}

	void printPoints() {
		System.out.println("Student name: " + fName + " " + lName
				+ "\nScore Test 1: " + pointsTest1 + "\nScore Test 2: " + pointsTest2 + "\nAverage Score: " + average);
	}
}
