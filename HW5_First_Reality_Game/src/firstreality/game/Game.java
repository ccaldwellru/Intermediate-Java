package firstreality.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import firstreality.graphics.Assets;
import firstreality.graphics.GameCamera;
import firstreality.input.KeyManager;
import firstreality.input.MouseManager;
import firstreality.states.GameState;
import firstreality.states.MenuState;
import firstreality.states.State;
import firstreality.view.View;

/**
 * The Class Game.
 */
public class Game implements Runnable {

	/** The view. */
	private View view;

	/** The title. */
	public String title;

	/** The height. */
	private int width, height;

	/** The key manager. */
	private KeyManager keyManager;

	/** The mouse manager. */
	private MouseManager mouseManager;

	/** The camera. */
	private GameCamera camera;

	/** The handler. */
	private Handler handler;

	/** The buff strat. */
	private BufferStrategy buffStrat;

	/** The graphics. */
	private Graphics g;

	/** The game state. */
	public static State gameState;

	/** The menu state. */
	public static State menuState;

	/** The thread. */
	private Thread thread;

	/** Boolean for if the program is running. */
	private boolean running = false;

	/**
	 * Instantiates a new game.
	 *
	 * @param title
	 *            the title
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	/**
	 * Initializes the view and assets.
	 */
	private void init() {
		view = new View(title, width, height);
		view.getFrame().addKeyListener(keyManager);
		view.getFrame().addMouseListener(mouseManager);
		view.getFrame().addMouseMotionListener(mouseManager);
		view.getCanvas().addMouseListener(mouseManager);
		view.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		camera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);

	}

	/**
	 * Update the first state and key manager.
	 */
	private void update() {
		keyManager.update();

		if (State.getState() != null)
			State.getState().update();
	}

	/**
	 * Render the view.
	 */
	private void render() {
		buffStrat = view.getCanvas().getBufferStrategy();
		if (buffStrat == null) {
			view.getCanvas().createBufferStrategy(3);
			return;
		}
		g = buffStrat.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		if (State.getState() != null)
			State.getState().render(g);

		buffStrat.show();
		g.dispose();
	}

	/*
	 * the main loop
	 */
	public void run() {
		init();

		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				// System.out.println("Updates and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	/**
	 * Gets the key manager.
	 *
	 * @return the key manager
	 */
	public KeyManager getKeyManager() {
		return keyManager;
	}

	/**
	 * Gets the mouse manager.
	 *
	 * @return the mouse manager
	 */
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	/**
	 * Gets the game camera.
	 *
	 * @return the game camera
	 */
	public GameCamera getGameCamera() {
		return camera;
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
	 * Start.
	 */
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Stop.
	 */
	public synchronized void stop() {
		if (!running)
			return;
		thread = new Thread(this);
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
