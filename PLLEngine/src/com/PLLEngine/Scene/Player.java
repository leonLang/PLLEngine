package com.PLLEngine.Scene;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.PLLEngine.Control.Control;
import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.srcLoader.SrcLoader;

public class Player extends Entitie {

	private Game game;
	private Control controller;

	private static boolean richtungAll;
	private boolean richtungOwn, once;
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

	public Player() {
		img = SrcLoader.Image("char00.png");
		animationState = true;
		
		this.speed = 5;

		this.controller = new Control(this);
	}

	public void init(Game game) {
		this.game = game;
		this.xOnScreen = game.getWindow().getWidth() / 2;
		this.yOnScreen = game.getWindow().getHeight() / 2;
		this.game.getWindow().getWindow().addKeyListener(this.controller);
		this.game.getWindow().getWindow().requestFocusInWindow();

	}

	@Override
	public void draw(Graphics2D g) {
		// synchronize();
		g.drawRect(xOnScreen - width / 2, yOnScreen - height / 2, width, height);
		g.drawImage(img, xOnScreen - width / 2, yOnScreen - height / 2, width, height, null);

	}
	public void update() {
		if(up) {
			this.moveUp();
		}
		if(down) {
			this.moveDown();
		}
		if(left) {
			this.moveLeft();
		}
		if(right) {
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
		this.y += speed;
		this.game.getScene().getWorld().moveUp(speed);
		this.movementstate = 0;
	}

	private void moveDown() {
		this.y -= speed;
		this.game.getScene().getWorld().moveDown(speed);
		this.movementstate = 1;

	}

	private void moveRight() {
		this.x += speed;
		this.game.getScene().getWorld().moveRight(speed);
		this.movementstate = 2;

	}

	private void moveLeft() {
		this.x -= speed;
		this.game.getScene().getWorld().moveLeft(speed);
		this.movementstate = 3;

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
		if(e.getKeyCode()== KeyEvent.VK_0) {
			System.out.println("X: " + -this.x/this.game.getScene().getWorld().getSpriteSize());
			System.out.println("Y: " + -this.y/this.game.getScene().getWorld().getSpriteSize());
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
	}

	public void KeyTyped(KeyEvent e) {

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
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
