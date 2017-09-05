import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

/*
 * the view class is what creates the user interface. this class has multiple
 * methods to create and change what the user sees
 */
public class View extends JPanel {

	/*
	 * variables for the two panels I used to make the gridlayout work correctly
	 * including the buttons, jlabels, generations, and time.
	 */
	private JPanel mainPanel;
	private JPanel subPanel;
	private JButton[][] mainButtonArray;
	private JButton littleInfect = new JButton();
	private JButton lightInfect = new JButton();
	private JButton moderateInfect = new JButton();
	private JButton moderateHighInfect = new JButton();
	private JButton highInfect = new JButton();
	private int generations = 0;
	private double time = generations * 6.3;
	private JLabel timeLabel = new JLabel(" ");
	private JLabel genLabel = new JLabel(" ");

	// this method actually creates the window that is seen once the program
	// starts running
	public void mainWindow() {
		// mainPanel is the panel that contains the 2d array of buttons that
		// change colors
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(25, 25));
		mainPanel.setSize(500, 300);
		// used a nested for loop to create the 625 buttons
		mainButtonArray = new JButton[25][25];
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++) {
				mainButtonArray[rows][cols] = new JButton();
				mainButtonArray[rows][cols].setSize(10, 10);
				// adds each button to the main panel
				mainPanel.add(mainButtonArray[rows][cols]);
			}
		}

		// subPanel is the panel that contains the legend, the time it took to
		// become infectious,
		// and the number of generations it took to become infectious.
		subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(5, 4));
		subPanel.setSize(100, 100);

		// this takes the jbutton that was created and sets the size and color
		// and adds it to the panel.
		littleInfect.setSize(1, 1);
		littleInfect.setBackground(Color.blue);
		// the setborderpainted and setfocuspainted turns off the black border
		// around the buttons
		littleInfect.setBorderPainted(false);
		littleInfect.setFocusPainted(false);
		subPanel.add(littleInfect);
		// adding labels to the panel to keep the user interface clean
		subPanel.add(new Label("Little or no infection"));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));

		// repeated the above steps 5 times for the different colors and levels
		// of infection
		lightInfect = new JButton();
		lightInfect.setSize(1, 1);
		lightInfect.setBackground(Color.green);
		lightInfect.setBorderPainted(false);
		lightInfect.setFocusPainted(false);
		subPanel.add(lightInfect);
		subPanel.add(new Label("Light infection"));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));

		moderateInfect = new JButton();
		moderateInfect.setSize(1, 1);
		moderateInfect.setBackground(Color.yellow);
		moderateInfect.setBorderPainted(false);
		moderateInfect.setFocusPainted(false);
		subPanel.add(moderateInfect);
		subPanel.add(new Label("Moderate infection"));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));
		subPanel.add(new Label(" "));

		moderateHighInfect = new JButton();
		moderateHighInfect.setSize(1, 1);
		moderateHighInfect.setBackground(Color.orange);
		moderateHighInfect.setBorderPainted(false);
		moderateHighInfect.setFocusPainted(false);
		subPanel.add(moderateHighInfect);
		subPanel.add(new Label("Moderately-high infection"));
		subPanel.add(new Label(" "));
		subPanel.add(new Label("Time (Minutes)"));
		subPanel.add(new Label("Generations"));

		highInfect = new JButton();
		highInfect.setSize(1, 1);
		highInfect.setBackground(Color.red);
		highInfect.setBorderPainted(false);
		highInfect.setFocusPainted(false);
		subPanel.add(highInfect);
		subPanel.add(new Label("High infection"));
		subPanel.add(new Label(" "));
		subPanel.add(timeLabel);
		subPanel.add(genLabel);

		/*
		 * creates the actual frame and adds both panels to it, sets what
		 * happens when the program is closed, the size, packs the components
		 * closely together, and sets the frame to be visible.
		 */
		JFrame frame = new JFrame("Bacteria Growth");
		frame.add(mainPanel, BorderLayout.NORTH);
		frame.add(subPanel, BorderLayout.SOUTH);
		frame.setSize(750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	/*
	 * this method is what actually updates the colors of the buttons and
	 * changes the colors based on the value inside each cell. it gets the value
	 * from the 2d array that was created in the grid class and goes through
	 * multiple if statements to check for the right ammount. it also changes
	 * the time and generations label's text
	 */
	public void updateButtons(int[][] infectionLevels) {
		generations++;
		time += generations * 6.3;
		for (int rows = 0; rows < 25; rows++) {
			for (int cols = 0; cols < 25; cols++) {
				if (infectionLevels[rows][cols] < 100) {
					//mainButtonArray[rows][cols].setText("" + infectionLevels[rows][cols]);
					mainButtonArray[rows][cols].setForeground(Color.blue);
					mainButtonArray[rows][cols].setBackground(Color.blue);
				} else if (infectionLevels[rows][cols] >= 100 && infectionLevels[rows][cols] < 1500) {
					//mainButtonArray[rows][cols].setText("" + infectionLevels[rows][cols]);
					mainButtonArray[rows][cols].setForeground(Color.green);
					mainButtonArray[rows][cols].setBackground(Color.green);
				} else if (infectionLevels[rows][cols] >= 1500 && infectionLevels[rows][cols] < 3500) {
					//mainButtonArray[rows][cols].setText("" + infectionLevels[rows][cols]);
					mainButtonArray[rows][cols].setForeground(Color.yellow);
					mainButtonArray[rows][cols].setBackground(Color.yellow);
				} else if (infectionLevels[rows][cols] >= 3500 && infectionLevels[rows][cols] < 7250) {
					//mainButtonArray[rows][cols].setText("" + infectionLevels[rows][cols]);
					mainButtonArray[rows][cols].setForeground(Color.orange);
					mainButtonArray[rows][cols].setBackground(Color.orange);
				} else if (infectionLevels[rows][cols] >= 7250) {
					//mainButtonArray[rows][cols].setText("" + infectionLevels[rows][cols]);
					mainButtonArray[rows][cols].setForeground(Color.red);
					mainButtonArray[rows][cols].setBackground(Color.red);
				}

			}
			genLabel.setText("          " + generations);
			timeLabel.setText("          " + time);
		}
		// paint immediately paints each cell immediately instead of painting
		// when it gets the chance.
		this.paintImmediately(new Rectangle(300, 300));
	}
}
