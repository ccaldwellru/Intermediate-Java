//Methods to help get and set the user's input from the text field
public class Palindrome {

	private String userInput;

	//Palindrome constructor to give the user input a value
	public Palindrome(String userText) {
		this.userInput = userText;
	}
	/*
	 * returns the value of the user's input
	 * 
	 * @return the String value of the user input
	 */
	public String getUserInput() {
		return this.userInput;
	}
	/*
	 * sets the value of the user input
	 * 
	 * @param String value of the text field the user filled out
	 */
	public void setUserInput(String userText) {
		this.userInput = userText;
	}
}
