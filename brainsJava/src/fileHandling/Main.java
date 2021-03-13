package fileHandling;

import java.io.File;
import java.io.IOException;

public class Main {

	// creating a file
	public static void main(String[] args) {

		try {
			File myFile = new File("C:\\Users\\fxckr\\Desktop\\File01.txt");
			if (myFile.createNewFile()) {
				System.out.println("File created: " + myFile.getName());

			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {

			System.out.println("An error occurred");
			e.printStackTrace();
		}

	}

}
