package firstreality.view;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * The Class View.
 */
public class View {

	/** The frame. */
	private JFrame frame;
	
	/** The canvas. */
	private Canvas canvas;

	/** The title. */
	private String title;
	
	/** The height. */
	private int width, height;

	/**
	 * Instantiates a new view.
	 *
	 * @param title the title of the frame
	 * @param width the width of the frame
	 * @param height the height of the frame
	 */
	public View(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		mainFrame();
	}

	/**
	 * Main frame.
	 */
	private void mainFrame() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}

	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
