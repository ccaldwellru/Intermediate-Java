package firstreality.states;

import java.awt.Graphics;

import firstreality.game.Handler;
import firstreality.maps.Map;

/**
 * The Class GameState.
 */
public class GameState extends State {

	/** The map. */
	private Map map;

	/**
	 * Instantiates a new game state.
	 *
	 * @param handler
	 *            the handler
	 */
	public GameState(Handler handler) {
		super(handler);
		map = new Map(handler, "res/Maps/Overworld.txt");
		handler.setMap(map);
	}

	@Override
	public void update() {
		map.update();
	}

	@Override
	public void render(Graphics g) {
		map.render(g);
	}

}
