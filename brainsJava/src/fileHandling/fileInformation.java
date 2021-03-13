package fileHandling;

import java.io.File;
import java.io.IOException;

//getting file info
public class fileInformation {

	public static void main(String[] args) {

		File myFile = new File("C:\\Users\\fxckr\\Desktop\\File01.txt");
		if (myFile.exists()) {

			System.out.println("This filename: " + myFile.getName());
			System.out.println("This file location: " + myFile.getAbsolutePath());
			System.out.println("Writeable: " + myFile.canWrite());
			System.out.println("Readable: " + myFile.canRead());
			System.out.println("Size in bytes: " + myFile.length());

		} else {
			System.out.println("The file does not exist.");
		}

	}

}
