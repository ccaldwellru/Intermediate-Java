package firstreality.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * The Class UIObject.
 */
public abstract class UIObject {

	/** The y. */
	protected float x, y;

	/** The height. */
	protected int width, height;

	/** The bounds. */
	protected Rectangle bounds;

	/** The hovering. */
	protected boolean hovering = false;

	/**
	 * Instantiates a new UI object.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	/**
	 * Update.
	 */
	public abstract void update();

	/**
	 * Render.
	 *
	 * @param g
	 *            the graphics
	 */
	public abstract void render(Graphics g);

	/**
	 * On click.
	 */
	public abstract void onClick();

	/**
	 * On mouse move.
	 *
	 * @param e
	 *            the event
	 */
	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	}

	/**
	 * On mouse release.
	 *
	 * @param e
	 *            the event
	 */
	public void onMouseRelease(MouseEvent e) {
		if (hovering)
			onClick();
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the new x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the new y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Checks if is hovering.
	 *
	 * @return true, if is hovering
	 */
	public boolean isHovering() {
		return hovering;
	}

	/**
	 * Sets the hovering.
	 *
	 * @param hovering
	 *            the new hovering
	 */
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}

}
