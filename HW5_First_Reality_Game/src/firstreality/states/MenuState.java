package firstreality.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import firstreality.game.Game;
import firstreality.game.Handler;
import firstreality.graphics.ImageLoader;
import firstreality.ui.ClickListener;
import firstreality.ui.UIImageButton;
import firstreality.ui.UIManager;

/**
 * The Class MenuState.
 */
public class MenuState extends State {

	/** The background. */
	private BufferedImage titleImage, startImage, background;
	
	/** The ui manager. */
	private UIManager uiManager;

	/**
	 * Instantiates a new menu state.
	 *
	 * @param handler the handler
	 */
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		startImage = ImageLoader.loadImage("/textures/start.png");
		background = ImageLoader.loadImage("/textures/background.png");
		titleImage = ImageLoader.loadImage("/textures/Title.png");
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(425, 600, 128, 64, startImage, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(Game.gameState);
			}
		}));

	}

	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(titleImage, 400, 85, null);
		uiManager.render(g);
	}
}
