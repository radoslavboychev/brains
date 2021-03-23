package restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface WorkWithFiles {

	public void loadFromFile(BufferedReader br);
	
	public void writeToFile(BufferedWriter bw);
	
}
