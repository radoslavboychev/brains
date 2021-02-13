package objectOrientedProgramming;

public class Main {

	public static void main(String[] args) {

//		Message myMessage = new Message(); //create object Message
////		myMessage.textString = "HelloWorld"; //set the default text
//		myMessage.setText("New text"); //set the new text via method
//		myMessage.showMessage(); //print the text
//
//		Message secondMessage = new Message(); //create another object
////		secondMessage.textString = "HelloAgain"; //set the default text
//		secondMessage.setText("Yeaaosdayaysayydas"); //set the new text via method
//		secondMessage.showMessage(); //print the text
		
		Student myStudent = new Student();
		Student secondStudent = new Student();
		
		myStudent.setLastName("Nick", "McDick");
		myStudent.setPoints(45, 83);
		myStudent.calculateAverage();
		myStudent.printPoints();
		
		secondStudent.setLastName("John", "McJohn");
		secondStudent.setPoints(77, 95);
		secondStudent.calculateAverage();
		secondStudent.printPoints();
		
	}

}
