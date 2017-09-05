package firstreality.tiles;

import firstreality.graphics.Assets;

/**
 * The Class WallTile.
 */
public class WallTile extends Tile {

	/**
	 * Instantiates a new wall tile.
	 *
	 * @param id
	 *            the id
	 */
	public WallTile(int id) {
		super(Assets.stoneWall, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
