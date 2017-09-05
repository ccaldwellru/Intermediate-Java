package firstreality.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import firstreality.game.Handler;

/**
 * The Class Entity.
 */
public abstract class Entity {

	/** The Constant DEFAULT_POINTS and DEFAULT_HEALTH. */
	public static final int DEFAULT_HEALTH = 5, DEFAULT_POINTS = 0;

	/** The bounds of all entities. */
	protected Rectangle bounds;

	/** The handler. */
	protected Handler handler;

	/** The x and y coordinates. */
	protected float x, y;

	/** The width and height of the entity. */
	protected int width, height;

	/** The health, points, and difficulty for the entity. */
	protected int health, points, difficulty;

	/** If the entity is active it can be displayed. */
	protected boolean active = true;

	/** The random. */
	private Random rand;

	/**
	 * Instantiates a new entity.
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
	public Entity(Handler handler, float x, float y, int width, int height) {
		rand = new Random();
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = rand.nextInt(4) + 1;
		difficulty = health;
		points = DEFAULT_POINTS;
		bounds = new Rectangle(0, 0, width, height);
	}

	/**
	 * Update.
	 */
	public abstract void update();

	/**
	 * Render.
	 *
	 * @param render
	 *            the g
	 */
	public abstract void render(Graphics g);

	/**
	 * Die.
	 */
	public abstract void die();

	/**
	 * Hurt.
	 *
	 * @param subtract
	 *            the amount
	 */
	public void hurt(int amount) {
		health -= amount;
		if (health <= 0) {
			active = false;
			die();
		}
	}

	/**
	 * Gets the collision bounds.
	 *
	 * @param xOffset
	 *            the x offset
	 * @param yOffset
	 *            the y offset
	 * @return the collision bounds
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}

	/**
	 * Check entity collisions.
	 *
	 * @param xOffset
	 *            the x offset
	 * @param yOffset
	 *            the y offset
	 * @return true, if successful
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getMap().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
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
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health
	 *            the new health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points
	 *            the new points
	 */
	public void setPoints(int points) {
		this.points += points;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active
	 *            the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
