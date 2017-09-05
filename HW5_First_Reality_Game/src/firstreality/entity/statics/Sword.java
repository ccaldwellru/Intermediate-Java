package firstreality.entity.statics;

import java.awt.Graphics;
import firstreality.game.Handler;
import firstreality.graphics.Assets;
import firstreality.tiles.Tile;

/**
 * The Class Sword.
 */
public class Sword extends StaticEntity {

	/**
	 * Instantiates a new sword.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Sword(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;
		this.setHealth(1);
	}

	/* 
	 * 
	 */
	@Override
	public void update() {

	}

	/*
	 * render the sword to the screen
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sword, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	/*
	 * delete the sword if at 0 health
	 */
	@Override
	public void die() {
		this.setActive(false);
	}

}