package firstreality.entity.statics;

import java.awt.Graphics;
import firstreality.entity.Creature;
import firstreality.game.Handler;
import firstreality.graphics.Assets;

/**
 * The Class Enemies.
 */
public class Enemies extends Creature {

	/** The monster ID. */
	private int monsterID;

	/**
	 * Instantiates a new enemies.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param monsterID
	 *            the monster ID
	 */
	public Enemies(Handler handler, float x, float y, int monsterID) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH + 16, Creature.DEFAULT_CREAUTE_HEIGHT + 16);

		this.monsterID = monsterID;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;

	}

	/*
	 * stud
	 */
	@Override
	public void update() {

	}

	/*
	 * renders the enemies on the screen
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemies[monsterID], (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	/*
	 * kills the enemies if they are at 0 health
	 */
	@Override
	public void die() {
		handler.getMap().getEntityManager().getPlayer().setPoints(100 * difficulty);
		System.out.println(difficulty * 10);
	}

}
