package firstreality.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public class Tile {

	/** The tiles. */
	public static Tile[] tiles = new Tile[256];

	/** The grass tile. */
	public static Tile grassTile = new GrassTile(0);

	/** The wall tile. */
	public static Tile wallTile = new WallTile(1);

	/** The dirt tile 1. */
	public static Tile dirtTile1 = new DirtTile(2);

	/** The dirt tile 2. */
	public static Tile dirtTile2 = new DirtTileTwo(3);

	/** The Constant TILE_HEIGHT. */
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

	/** The texture. */
	protected BufferedImage texture;

	/** The id. */
	protected final int id;

	/**
	 * Instantiates a new tile.
	 *
	 * @param texture
	 *            the texture
	 * @param id
	 *            the id
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}

	/**
	 * Update.
	 */
	public void update() {

	}

	/**
	 * Render.
	 *
	 * @param g
	 *            the graphics
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	public boolean isSolid() {
		return false;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
