package firstreality.game;

import firstreality.graphics.GameCamera;
import firstreality.input.KeyManager;
import firstreality.input.MouseManager;
import firstreality.maps.Map;

/**
 * The Class Handler.
 */
public class Handler {

	/** The game. */
	private Game game;
	
	/** The map. */
	private Map map;

	/**
	 * Instantiates a new handler.
	 *
	 * @param game the game
	 */
	public Handler(Game game) {
		this.game = game;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return game.getWidth();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return game.getHeight();
	}

	/**
	 * Gets the key manager.
	 *
	 * @return the key manager
	 */
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	/**
	 * Gets the mouse manager.
	 *
	 * @return the mouse manager
	 */
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	/**
	 * Gets the game camera.
	 *
	 * @return the game camera
	 */
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public void setMap(Map map) {
		this.map = map;
	}
}
