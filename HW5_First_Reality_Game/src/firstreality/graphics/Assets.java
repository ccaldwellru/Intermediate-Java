package firstreality.graphics;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The Class Assets.
 */
public class Assets {

	/** The Constant HEIGHT. */
	private static final int WIDTH = 32, HEIGHT = 32;
	
	/** The random num. */
	private static int randomNum;
	
	/** The enemies. */
	public static BufferedImage player, dirt, dirt2, grass, stoneWall, stoneFloor, entrance, sword, enemies[];

	/**
	 * Initializes the images used in the map.
	 */
	public static void init() {
		Random rand = new Random();
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		sword = sheet.crop((5 * 32), (28 * 32), WIDTH, HEIGHT);
		player = sheet.crop(224, 96, WIDTH, HEIGHT);
		dirt = sheet.crop((13 * 32), 480, WIDTH, HEIGHT);
		dirt2 = sheet.crop((12 * 32), 480, WIDTH, HEIGHT);
		grass = sheet.crop((5 * 32), 480, WIDTH, HEIGHT);
		randomNum = rand.nextInt(12) + 39;
		stoneFloor = sheet.crop((randomNum * 32), 384, WIDTH, HEIGHT);
		randomNum = rand.nextInt(4) + 22;
		stoneWall = sheet.crop((randomNum * 32), 416, WIDTH, HEIGHT);
		entrance = sheet.crop(704, 480, WIDTH, HEIGHT);
		enemies = new BufferedImage[] { sheet.crop(rand.nextInt(63) * 32, 96, WIDTH, HEIGHT),
				sheet.crop(rand.nextInt(63) * 32, 96, WIDTH, HEIGHT),
				sheet.crop(rand.nextInt(63) * 32, 96, WIDTH, HEIGHT),
				sheet.crop(rand.nextInt(63) * 32, 96, WIDTH, HEIGHT),
				sheet.crop(rand.nextInt(63) * 32, 96, WIDTH, HEIGHT) };
	}
}
