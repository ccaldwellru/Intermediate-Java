
/* 
 * The cell class has the getBacteriaCount and the updateBacteria count methods to help 
 * correctly calculate the amount of bacteria in a cell
 * 
 */
import java.util.Random;

public class Cell {
	private int bacteriaCount;

	// The cell constructor that is called when creating a new cell. This will
	// put a random
	// number between 0 and 250
	public Cell() {
		Random rand = new Random();
		this.bacteriaCount = rand.nextInt(250);
	}

	/*
	 * returns the value of the current cell's bacteria count
	 * 
	 * @return the int value of a cell
	 */
	public int getBacteriaCount() {
		return bacteriaCount;
	}

	/*
	 * calculates the next value of the cells bacteria count
	 * 
	 * @param int value is the bacteria count of a cell
	 */
	public void updateBacteriaCount(int value) {
		this.bacteriaCount = value * 2;
	}
}
