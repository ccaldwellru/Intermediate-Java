/*
 * The Controller class controls the entire game. It has the loop that continues to run
 * until the bacteria count has reached an infectious dose.
 */
public class Controller {

	// The start method is what runs the game. Creates instances of the view and
	// grid class
	// to call the methodsthey contain
	public void start() throws java.lang.InterruptedException {
		View view = new View();
		Grid grid = new Grid();
		// creates the boolean that will determine if the loop runs
		boolean done = false;
		// calls the mainWindow method in the view to show the user the
		// interface
		view.mainWindow();
		// the loop the will update bacteria until there is an infecctious dose
		while (!(done)) {
			grid.updateBacteriaCount();
			// updates the user interface by changing the colors of the buttons
			view.updateButtons(grid.toArray());
			// slows the program down
			Thread.sleep(2000);
			// tests to see if the total bacteria count has reached the
			// infectious dose.
			if (grid.totalBacteriaCount() > 10000000) {
				done = true;
			}

		}
	}
}
