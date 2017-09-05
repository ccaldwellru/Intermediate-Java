package firstreality.entity.statics;

import java.awt.Graphics;
import firstreality.game.Handler;
import firstreality.graphics.Assets;
import firstreality.tiles.Tile;

/**
 * The Class Entrance.
 */
public class Entrance extends StaticEntity {

	/**
	 * Instantiates a new entrance.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Entrance(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 3);
		bounds.x = 0;
		bounds.y = 30;
		bounds.width = 192;
		bounds.height = 162;
		this.setHealth(1000000);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.entrance, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {

	}

}
