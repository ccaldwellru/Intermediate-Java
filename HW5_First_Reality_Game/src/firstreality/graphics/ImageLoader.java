package firstreality.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Class ImageLoader.
 */
public class ImageLoader {

	/**
	 * Load image.
	 *
	 * @param path the path to a file
	 * @return the buffered image
	 */
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
