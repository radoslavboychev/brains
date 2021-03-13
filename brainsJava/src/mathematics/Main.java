package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/* Create an interface "Function" which contains 5 methods:
 * 1. Read parameters from file
 * 
 * 2. Calculate the value of the function
 * 
 * 3. Check for real answers
 * 
 * 4. Calculate real answers
 * 
 * 5. Output answers to file
 * 
 * Two more classes: 
 * 
 * 1. LinearFunction 
 * 		
 * 	y = ax+b
 * 
 * 2. Quadratic function
 * 
 * 	y = ax^2+bx+c
 * 
 */

public class Main {

	public static void main(String[] args) throws IOException {

		FileReader input = new FileReader("C:\\Users\\fxckr\\Desktop\\java\\brains\\brainsJava\\dataQuadratic.txt");
//		String line;
//
//		try {
//			BufferedReader bReader = new BufferedReader(input);
//			while ((line = bReader.readLine()) != null) {
//				System.out.println(bReader.readLine());
//			}
//
//		} catch (java.io.FileNotFoundException e) {
//			System.out.println("File not found!");
//		}

		QuadraticFunction function = new QuadraticFunction();
		BufferedReader br = new BufferedReader(input);

		function.readFromFile(br);
		function.calculateValue();
		function.checkRealSolution();
		function.findSolution();

	}
}