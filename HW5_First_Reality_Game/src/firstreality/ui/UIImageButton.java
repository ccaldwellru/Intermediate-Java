package firstreality.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class UIImageButton.
 */
public class UIImageButton extends UIObject {

	/** The image. */
	private BufferedImage image;

	/** The click. */
	private ClickListener click;

	/**
	 * Instantiates a new UI image button.
	 *
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param width
	 *            the image width
	 * @param height
	 *            the image height
	 * @param image
	 *            the image
	 * @param click
	 *            the click listener
	 */
	public UIImageButton(float x, float y, int width, int height, BufferedImage image, ClickListener click) {
		super(x, y, width, height);
		this.image = image;
		this.click = click;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		if (hovering)
			g.drawImage(image, (int) x, (int) y, null);
		else
			g.drawImage(image, (int) x, (int) y, null);
	}

	@Override
	public void onClick() {
		click.onClick();
	}

}
