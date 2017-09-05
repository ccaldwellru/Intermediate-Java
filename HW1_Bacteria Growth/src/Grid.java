/*
 * The Grid class creates the 2d array of cells that actual hold the values that is counted.
 * In this class are multiple methods to update the bacteria, count the total bacteria, and 
 * return a 2d array of ints that will be used to help determine the color of the cell.
 */
public class Grid {

	// creates the 2d array variable
	private Cell[][] grid;

	// the constructor that actually makes a 25x25 2d array of cells once called
	public Grid() {
		grid = new Cell[25][25];
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++) {
				grid[rows][cols] = new Cell();
			}
		}
	}

	// updates all cells bacteria count once called. uses a nested for loop to
	// traverse all cells
	// in the array
	public void updateBacteriaCount() {
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++) {
				grid[rows][cols].updateBacteriaCount(grid[rows][cols].getBacteriaCount());
			}
		}
	}

	// counts all of the bacteria in all 625 cells and sets the bacteriaCount
	// variable to that values
	// uses a nested for loop to traverse all cells in the grid
	// @return int bacteriaCount
	public int totalBacteriaCount() {
		int bacteriaCount = 0;
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++) {
				bacteriaCount += grid[rows][cols].getBacteriaCount();
			}
		}
		return bacteriaCount;
	}

	// toArray takes all of the values from the 2d array of cells and puts it
	// into a
	// 2d int array. uses a nested for loop to take the values from all of the
	// cells
	// and initializes each array position of result
	public int[][] toArray() {
		int result[][] = new int[25][25];
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++)
				result[rows][cols] = grid[rows][cols].getBacteriaCount();
		}
		return result;
	}
}
