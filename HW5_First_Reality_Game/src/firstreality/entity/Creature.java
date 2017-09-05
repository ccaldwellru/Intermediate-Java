package firstreality.entity;

import firstreality.game.Handler;
import firstreality.tiles.Tile;

/**
 * The Class Creature.
 */
public abstract class Creature extends Entity {

	/** The Constant DEFAULT_CREAUTE_HEIGHT/WIDTH. */
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREAUTE_HEIGHT = 64;

	/** The Constant DEFAULT_SPEED. */
	public static final float DEFAULT_SPEED = 4.0f;

	/** The speed. */
	protected float speed;

	/** The y move. */
	protected float xMove, yMove;

	/**
	 * Instantiates a new creature.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	/**
	 * Move if there is no collision with a tile.
	 */
	public void move() {
		if (!checkEntityCollisions(xMove, 0f))
			moveX();
		if (!checkEntityCollisions(0f, yMove))
			moveY();

	}

	/**
	 * Move in the X direction.
	 */
	public void moveX() {
		if (xMove > 0) {
			int tempx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tempx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tempx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}

		} else if (xMove < 0) {
			int tempx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tempx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tempx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}
		}
	}

	/**
	 * Move in the Y direction.
	 */
	public void moveY() {
		if (yMove < 0) {
			int tempy = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tempy)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_HEIGHT, tempy)) {
				y += yMove;
			}

		} else if (yMove > 0) {
			int tempy = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tempy)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_HEIGHT, tempy)) {
				y += yMove;
			}
		}
	}

	/**
	 * Collision with tile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return true, if successful
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getMap().getTile(x, y).isSolid();
	}

	/**
	 * Gets the x move.
	 *
	 * @return the x move
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * Sets the x move.
	 *
	 * @param xMove
	 *            the new x move
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * Gets the y move.
	 *
	 * @return the y move
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * Sets the y move.
	 *
	 * @param yMove
	 *            the new y move
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see firstreality.entity.Entity#getHealth()
	 */
	public int getHealth() {
		return health;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see firstreality.entity.Entity#setHealth(int)
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public int getExperience() {
		return points;
	}

	/**
	 * Sets the experience.
	 *
	 * @param points
	 *            the new experience
	 */
	public void setExperience(int points) {
		this.points += points;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed.
	 *
	 * @param speed
	 *            the new speed
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
