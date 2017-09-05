package firstreality.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import firstreality.game.Handler;

/**
 * The Class EntityManager.
 */
public class EntityManager {

	/** The handler. */
	private Handler handler;

	/** The player. */
	private Player player;

	/** The entities. */
	private ArrayList<Entity> entities;

	/** The render order. */
	private Comparator<Entity> renderOrder = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}
	};

	/**
	 * Instantiates a new entity manager.
	 *
	 * @param handler
	 *            the handler
	 * @param player
	 *            the player
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}

	/**
	 * Updates entity methods.
	 */
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.update();
			if (!e.isActive())
				entities.remove(e);
		}
		entities.sort(renderOrder);
	}

	/**
	 * Renders the graphics to the screen.
	 *
	 * @param render
	 *            the g
	 */
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}

	/**
	 * Adds the entity.
	 *
	 * @param e
	 *            the e
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}

	/**
	 * Gets the handler.
	 *
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Sets the handler.
	 *
	 * @param handler
	 *            the new handler
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player
	 *            the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * Sets the entities.
	 *
	 * @param entities
	 *            the new entities
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
