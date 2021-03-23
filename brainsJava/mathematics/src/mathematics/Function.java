package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface Function {

	//read from file
	public void readFromFile(BufferedReader data);
	
	
	public void calculateValue();


	public void checkRealSolution();


	public void findSolution(); 
	

	//write to file
	public void printSolution(BufferedWriter output);


}
