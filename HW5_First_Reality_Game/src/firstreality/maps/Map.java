package firstreality.maps;

import java.awt.Graphics;

import firstreality.entity.EntityManager;
import firstreality.entity.Player;
import firstreality.entity.statics.Entrance;
import firstreality.game.Handler;
import firstreality.tiles.Tile;
import firstreality.utils.Utils;

/**
 * The Class Map.
 */
public class Map {

	/** The handler. */
	private Handler handler;

	/** The spawn Y. */
	private int width, height, spawnX, spawnY;

	/** The tiles. */
	private int[][] tiles;

	/** The entity manager. */
	private EntityManager entityManager;

	/**
	 * Instantiates a new map.
	 *
	 * @param handler
	 *            the handler used for helped functions
	 * @param path
	 *            the path used to create the map
	 */
	public Map(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 165, 165));
		entityManager.addEntity(new Entrance(handler, 995, 130));
		loadMap(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	/**
	 * Update.
	 */
	public void update() {
		entityManager.update();
	}

	/**
	 * Render.
	 *
	 * @param render
	 *            the graphics
	 */
	public void render(Graphics g) {

		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}

	/**
	 * Gets the tile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the tile
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.tiles[0];
		return t;
	}

	/**
	 * Load map.
	 *
	 * @param load
	 *            the path
	 */
	private void loadMap(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

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
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
