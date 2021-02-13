package objectOrientedProgramming;

public class Message {

	String textString;
	
	void setText(String newText) //method to set the text
	{
		textString = newText;
	}
	void showMessage() //method to display the text in the console
	{
		System.out.println(textString);
	}
}
