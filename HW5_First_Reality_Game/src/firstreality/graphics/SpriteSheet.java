package firstreality.graphics;

import java.awt.image.BufferedImage;

/**
 * The Class SpriteSheet.
 */
public class SpriteSheet {

	/** The sheet. */
	private BufferedImage sheet;

	/**
	 * Instantiates a new sprite sheet.
	 *
	 * @param sheet the sheet
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	/**
	 * Crop from the sprite sheet.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @return the buffered image
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

}
