/*
 * This project simulates the growth of the Clostridium Perfringens on meat left out. There is a 25x25 grid
 * that gets a random number between 0-250 and then doubles each lifetime or iteration of the program. 
 * The grid changes color based on the number of bacteria on a cell. 
 * 
 * author: Corey Caldwell
 * date: 9/30/2016
 * 
 * The driver contains the main method to start the program and calls the controller class to start the game loop.
 */
public class Driver {

	public static void main(String[] args) throws java.lang.InterruptedException {
		// game loop surrounded in a try catch statement

		Controller gameLoop = new Controller();
		gameLoop.start();
	}

}
