package firstreality.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class KeyManager.
 */
public class KeyManager implements KeyListener {

	/** The keys. */
	private boolean[] keys;

	/** The move/attack right/up/down/left. */
	public boolean up, down, left, right, attUp, attDown, attLeft, attRight;

	/**
	 * Instantiates a new key manager.
	 */
	public KeyManager() {
		keys = new boolean[256];
	}

	/**
	 * Update.
	 */
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		attUp = keys[KeyEvent.VK_UP];
		attDown = keys[KeyEvent.VK_DOWN];
		attLeft = keys[KeyEvent.VK_LEFT];
		attRight = keys[KeyEvent.VK_RIGHT];
	}

	/*
	 * grabs the keycode of the pressed keyboard button
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	/*
	 * grabs the keycode of the released keyboard button
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
