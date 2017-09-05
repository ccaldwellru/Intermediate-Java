package firstreality.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import firstreality.entity.statics.Enemies;
import firstreality.entity.statics.Sword;
import firstreality.game.Handler;
import firstreality.graphics.Assets;

/**
 * The Class Player.
 */
public class Player extends Creature {

	/** The battle num 2. */
	private int battleNum1, battleNum2;

	/** The random int. */
	private Random rand;

	/** The attack timer. */
	private long lastAttackTimer, attackCooldown = 1200, attackTimer = attackCooldown;

	/** The sword. */
	public Sword sword;

	/**
	 * Instantiates a new player.
	 *
	 * @param handler
	 *            the handler
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH * 2, Creature.DEFAULT_CREAUTE_HEIGHT * 2);

		bounds.x = 38;
		bounds.y = 40;
		bounds.width = 64;
		bounds.height = 85;

		rand = new Random();
		battleNum1 = 0;
		battleNum2 = 0;
	}

	/*
	 * updates all the player methods
	 */
	@Override
	public void update() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		checkAttacks();
	}

	/**
	 * Check attacks direction and if the attack hit an entity
	 */
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();

		if (attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 30;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().attUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
			sword = new Sword(handler, ar.x, ar.y - 50);
			handler.getMap().getEntityManager().addEntity(sword);
		} else if (handler.getKeyManager().attDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
			sword = new Sword(handler, ar.x, ar.y);
			handler.getMap().getEntityManager().addEntity(sword);
		} else if (handler.getKeyManager().attLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			sword = new Sword(handler, ar.x - 50, ar.y);
			handler.getMap().getEntityManager().addEntity(sword);
		} else if (handler.getKeyManager().attRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			sword = new Sword(handler, ar.x + 25, ar.y);
			handler.getMap().getEntityManager().addEntity(sword);
		} else {
			return;
		}

		if (attackTimer > attackCooldown)
			sword.die();

		attackTimer = 0;

		for (Entity e : handler.getMap().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}

	/**
	 * Gets the input from the keyboard
	 *
	 * @return the input
	 */
	private void getInput() {
		xMove = 0;
		yMove = 0;

		battleNum1 = rand.nextInt(472);
		battleNum2 = rand.nextInt(472);
		if (battleNum1 == battleNum2) {
			handler.getMap().getEntityManager().addEntity(new Enemies(handler, battleNum1 + rand.nextInt(1000),
					battleNum2 + rand.nextInt(1000), rand.nextInt(5)));
		}

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	/*
	 * draws the player image and the score on the screen
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + this.getPoints(), 15, 50);
	}

	/*
	 * kills the character if they are at 0 health
	 */
	@Override
	public void die() {
		System.out.println("LOSE");
	}

}
