package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface Function {

	//read from file
	public void readFromFile(BufferedReader data);
	
	//calculates the descriminant
	public void calculateValue();

	// check the descriminant
	public void checkRealSolution();


	// calculates the x1 and/or x2
	public void findSolution(); 


	// prints the solution
	public void printSolution(BufferedWriter data, double solution);

}
