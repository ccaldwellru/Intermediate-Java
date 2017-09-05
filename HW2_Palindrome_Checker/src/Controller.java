//controller starts the view which is the gui for the program
public class Controller {
	//method to create an instance of the view object
	public void start() {
		View view = new View();
		//calls the method from the view class in order to show the gui
		view.mainWindow();
	}
}
