package firstreality.graphics;

import firstreality.entity.Entity;
import firstreality.game.Handler;
import firstreality.tiles.Tile;

/**
 * The Class GameCamera.
 */
public class GameCamera {

	/** The handler. */
	private Handler handler;

	/** The y offset. */
	private float xOffset, yOffset;

	/**
	 * Instantiates a new game camera.
	 *
	 * @param handler
	 *            the handler
	 * @param xOffset
	 *            the x offset
	 * @param yOffset
	 *            the y offset
	 */
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	/**
	 * Check blank space to create each tile.
	 */
	public void checkBlankSpace() {
		int bottomY = handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
		int bottomX = handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
			xOffset = bottomX;
		}
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = bottomY;
		}
	}

	/**
	 * Center on entity.
	 *
	 * @param e
	 *            the entity to be focused on
	 */
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight();
		checkBlankSpace();
	}

	/**
	 * Move.
	 *
	 * @param move
	 *            the offset by the x amount
	 * @param move
	 *            the offset by the y amount
	 */
	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
		checkBlankSpace();
	}

	/**
	 * Gets the x offset.
	 *
	 * @return the x offset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * Sets the x offset.
	 *
	 * @param xOffset
	 *            the new x offset
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * Gets the y offset.
	 *
	 * @return the y offset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * Sets the y offset.
	 *
	 * @param yOffset
	 *            the new y offset
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
