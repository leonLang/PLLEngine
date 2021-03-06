//peter
package com.PLLEngine.Scene;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import com.PLLEngine.Control.Control;
import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.layerComponents.entity.Entitie;

import com.PLLEngine.collision.CollObject;
import com.PLLEngine.collision.CollWorld;
import com.PLLEngine.Scene.layerComponents.entity.Shot;
import com.PLLEngine.Scene.layerComponents.entity.enemy.Health;
import com.PLLEngine.srcLoader.SrcLoader;

public class Player extends Entitie {

	private Game game;
	private Control controller;

	private int xOnScreen, yOnScreen;
	private int width, height;

	public int speed;

	private int x, y;
	private boolean up, down, right, left;
	private BufferedImage img;
	private String charSprite;
	private boolean animationState;
	private Thread movement;
	private int movementstate;
	private int attackState;

	// Leon Code Start
	private CollObject cO = new CollObject(58, 58);
	private CollWorld cW = new CollWorld(58, 58);
	private int playerX = 560;
	private int playerY = 364;
	private Health health = new Health(10);
	private Shot[] shot = new Shot[10];
	private static int lives;
	// Leon Code End

	public Player() {
		img = SrcLoader.Image("char00.png");
		animationState = true;

		this.speed = 4; // don't change it to 5 this will couse errors with collision

		this.controller = new Control(this);

		for (int i = 0; i < shot.length; i++) {
			shot[i] = new Shot(200);
		}
	}

	public void init(Game game) {
		this.game = game;
		this.xOnScreen = game.getWindow().getWidth() / 2;
		this.yOnScreen = game.getWindow().getHeight() / 2;
		this.game.getWindow().getWindow().addKeyListener(this.controller);
		this.game.getWindow().getWindow().requestFocusInWindow();
		this.attackState = 1;
		lives = health.getLives(); // Leon

	}

	@Override
	public void draw(Graphics2D g) {
		// synchronize();
		for (int i = 0; i < shot.length; i++) {
			shot[i].drawShot(g, 560 - Entitie.getDxAll(), 364 - Entitie.getDyAll());
		}
		g.setColor(Color.gray);
		//g.drawRect(xOnScreen - width / 2, yOnScreen - height / 2, width, height);
		g.drawImage(img, xOnScreen - width / 2, yOnScreen - height / 2, width, height, null);

		// Start Code Leon
		g.drawRect(568, 360, 64, 4);
		if (lives <= 0) {

		} else {
			g.fillRect(568, 360, 64 * lives / health.getStartLives(), 4);
		}
		// End Code Leon

	}

	public void update() {
		if (up) {
			this.moveUp();
		}
		if (down) {
			this.moveDown();
		}
		if (left) {
			this.moveLeft();
		}
		if (right) {
			this.moveRight();
		}
	}

	/*
	 * private void synchronize() { if (Entitie.synchronize[entityNumberOwn]) {
	 * Entitie.synchronize[entityNumberOwn] = false; if
	 * (CollThread.collLeft[entityNumberOwn]) {
	 * 
	 * } else if (CollThread.collRight[entityNumberOwn]) {
	 * 
	 * } else { // enemyMovement(); }
	 * 
	 * } }
	 */
	// wird im sp�teren Verlauf gebraucht

	private void moveUp() {
		for (int i = 0; i <= speed; i++) {
			if (cO.checkCollisionFromObjectsDown(playerX + i, playerY + i)) { // Leon

			} else {
				this.y += 1;
				this.game.getScene().getWorld().moveUp(1);
				this.movementstate = 0;
			} // Leon
		}
	}

	private void moveDown() {
		for (int i = 0; i <= speed; i++) {
			if (cO.checkCollisionFromObjectsUp(playerX + i, playerY + i)) { // Leon

			} else {
				this.y -= 1;
				this.game.getScene().getWorld().moveDown(1);
				this.movementstate = 1;
			}
		}
	}

	private void moveRight() {
		for (int i = 0; i <= speed; i++) {
			if (cO.checkCollisionFromObjectsRight(playerX + i, playerY + i)) { // Leon

			} else {
				this.x += 1;
				this.game.getScene().getWorld().moveRight(1);
				this.movementstate = 2;
			}
		}
	}

	private void moveLeft() {
		for (int i = 0; i <= speed; i++) {
			if (cO.checkCollisionFromObjectsLeft(playerX + i, playerY + i)) { // Leon
			} else {
				this.x -= 1;
				this.game.getScene().getWorld().moveLeft(1);
				this.movementstate = 3;
			}
		}
	}

	/**
	 * millis is 100 by default but can/should be changed to 1Second/Spritenumber
	 * 
	 * @param img
	 * @param millis
	 */
	public void move(BufferedImage img[], int millis) {
		if (animationState) {
			movement = new Thread(() -> {
				animationState = false;

				for (int i = 0; i < img.length; i++) {
					this.img = img[i];
					try {
						Thread.sleep(millis);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				animationState = true;

			});
			movement.start();
		}
	}

	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_0) {
			System.out.println("X: " + -this.x / this.game.getScene().getWorld().getSpriteSize());
			System.out.println("Y: " + -this.y / this.game.getScene().getWorld().getSpriteSize());
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (this.attackState == 0) {
					meleAttack();
				} else if (this.attackState == 1) {
					rangeAttack();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
				if (this.attackState == 1) {
					this.attackState = 0;
				} else if (this.attackState == 0) {
					this.attackState = 1;
				}
				System.out.println("Attack state of player changed to:" + this.attackState);
			}
		}
	}

	public void KeyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.right = false;
		}
		// Leon Code Start
		if (e.getKeyCode() == KeyEvent.VK_A) {
			for (int i = 0; i < shot.length; i++) {
				if (!shot[i].getShotIsFired()) {
					shot[i].addShot(0);
					i = shot.length + 1;
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			for (int i = 0; i < shot.length; i++) {
				if (!shot[i].getShotIsFired()) {
					shot[i].addShot(2);
					i = shot.length + 1;
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			for (int i = 0; i < shot.length; i++) {
				if (!shot[i].getShotIsFired()) {
					shot[i].addShot(3);
					i = shot.length + 1;
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			for (int i = 0; i < shot.length; i++) {
				if (!shot[i].getShotIsFired()) {
					shot[i].addShot(1);
					i = shot.length + 1;
				}
			}
		}

		// Leon Code End
	}

	public void KeyTyped(KeyEvent e) {

	}

	public void meleAttack() {

	}

	public void rangeAttack() {

		System.out.println("say hello");
		new Shot(100);
	}

	public int getxOnScreen() {
		return xOnScreen;
	}

	public void setxOnScreen(int xOnScreen) {
		this.xOnScreen = xOnScreen;
	}

	public int getyOnScreen() {
		return yOnScreen;
	}

	public void setyOnScreen(int yOnScreen) {
		this.yOnScreen = yOnScreen;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCharSprite() {
		return charSprite;
	}

	public void setCharSprite(String charSprite) {
		this.charSprite = charSprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		System.out.println(this.x);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Control getController() {
		return controller;
	}

	public static int getLives() {
		return lives;
	}

	public static void setLives(int lives) {
		Player.lives = lives;
	}

}
