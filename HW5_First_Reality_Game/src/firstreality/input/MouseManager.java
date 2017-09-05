package firstreality.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import firstreality.ui.UIManager;

/**
 * The Class MouseManager.
 */
public class MouseManager implements MouseListener, MouseMotionListener {

	/** The right pressed or left pressed. */
	private boolean leftPressed, rightPressed;

	/** The mouse Y and X. */
	private int mouseX, mouseY;

	/** The ui manager. */
	private UIManager uiManager;

	/**
	 * Instantiates a new mouse manager.
	 */
	public MouseManager() {

	}

	/**
	 * Sets the UI manager.
	 *
	 * @param uiManager
	 *            the new UI manager
	 */
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	/**
	 * Checks if is left pressed.
	 *
	 * @return true, if is left pressed
	 */
	public boolean isLeftPressed() {
		return leftPressed;
	}

	/**
	 * Checks if is right pressed.
	 *
	 * @return true, if is right pressed
	 */
	public boolean isRightPressed() {
		return rightPressed;
	}

	/**
	 * Gets the mouse X.
	 *
	 * @return the mouse X
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * Gets the mouse Y.
	 *
	 * @return the mouse Y
	 */
	public int getMouseY() {
		return mouseY;
	}

	/*
	 * checks if the right or left mouse buttons is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	/*
	 * checks if the right or left mouse buttons is released
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		if (uiManager != null)
			uiManager.onMouseRelease(e);
	}

	/*
	 * checks to see if the mouse is over a graphic and get the x and y position
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (uiManager != null)
			uiManager.onMouseMove(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
