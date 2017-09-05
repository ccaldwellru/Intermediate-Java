package firstreality.entity.statics;

import firstreality.entity.Entity;
import firstreality.game.Handler;


/**
 * The Class StaticEntity for entities that don't move.
 */
public abstract class StaticEntity extends Entity {

	/**
	 * Instantiates a new static entity.
	 *
	 * @param handler the handler
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}
