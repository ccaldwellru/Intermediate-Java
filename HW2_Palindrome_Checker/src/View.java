
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.*;

/*
 * the view class is what creates the user interface. this class has multiple
 * methods to create and change what the user sees
 */
public class View {

	/*
	 * variables for the two panels I used to make the gridlayout work correctly
	 * including the buttons and labels.
	 */

	private JPanel mainPanel;
	private JButton goButton;
	private JTextField palindromeField;
	private JLabel palindromeLabel;

	// this method actually creates the window that is seen once the program
	// starts running
	public void mainWindow() {
		// mainPanel is the panel that contains the a button, a text field, and a label
		mainPanel = new JPanel();
		goButton = new JButton("Go");
		palindromeField = new JTextField(20);
		palindromeLabel = new JLabel("");
		mainPanel.setLayout(new GridLayout(3, 2));
		mainPanel.add(new Label("USER INPUT: "));
		palindromeField.setSize(1, 1);
		mainPanel.add(palindromeField);
		mainPanel.add(new Label("RESULT: "));
		mainPanel.add(palindromeLabel);
		mainPanel.add(new Label(" "));
		goButton.setSize(1, 1);
		mainPanel.add(goButton);
		goButton.addActionListener(new goButtonHandler());
		/*
		 * creates the actual frame and adds both panels to it, sets what
		 * happens when the program is closed, the size, packs the components
		 * closely together, and sets the frame to be visible.
		 */
		JFrame frame = new JFrame("Palindrome");
		frame.add(mainPanel, BorderLayout.NORTH);
		frame.setSize(150, 150);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	//this action handler and the action performed when the go button is pressed.
	public class goButtonHandler implements ActionListener {
		//the variables that will be used in this class
		private String palindrome;
		private Stack<Character> stack;
		private Queue<Character> queue;
		private int count;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//instantiating the values of the variables
			count = 0;
			palindrome = palindromeField.getText();
			stack = new Stack<Character>();
			queue = new LinkedList<Character>();
			
			if (palindrome.length() > 0) {
				//checks the value of each character in a string and makes sure it is a letter
				//and pushes/adds it to the stack and queue. also updates the count
				for (int i = 0; i < palindrome.length(); i++) {
					if ((palindrome.charAt(i) >= 'a' && palindrome.charAt(i) <= 'z')
							|| (palindrome.charAt(i) >= 'A' && palindrome.charAt(i) <= 'Z')) {
						stack.push(palindrome.charAt(i));
						queue.add(palindrome.charAt(i));
						count++;
					}
				}
				//pops/removes a character from the stack and queue and compares them
				//if they aren't equal then the loop stops and gives the user output.
				for (int i = 0; i < count; i++) {
					if (!stack.pop().equals(queue.remove())) {
						palindromeLabel.setText("This is not a palindrome");
						break;
					}
					else{
						palindromeLabel.setText("This is a palindrome");
					}
				}
			}
		}
	}
}
