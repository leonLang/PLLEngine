package com.PLLEngine.Scene;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.collision.CollThread;
import com.PLLEngine.srcLoader.SrcLoader;

public class Player extends Entitie {

	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private int x, y;
	private int width, height;
	private BufferedImage img;
	private String[] sRight, sLeft, sUp, sDown;
	private String charSprite;
	private BufferedImage[] right, left, up, down;
	private boolean animationState;
	private Thread movement;
	private int movementstate;

	public Player() {
		x = 0;
		y = 0;
		img = SrcLoader.Image("char00.png");
		animationState = true;
	}

	public void initPlayer() {
		right = new BufferedImage[this.sRight.length];
		left = new BufferedImage[this.sLeft.length];
		up = new BufferedImage[this.sUp.length];
		down = new BufferedImage[this.sDown.length];
		for (int i = 0; i < this.sRight.length; i++) {
			this.right[i] = SrcLoader.Image(this.sRight[i]);
		}
		for (int i = 0; i < sLeft.length; i++) {
			this.left[i] = SrcLoader.Image(sLeft[i]);
		}
		for (int i = 0; i < sUp.length; i++) {
			this.up[i] = SrcLoader.Image(sUp[i]);
		}
		for (int i = 0; i < sDown.length; i++) {
			this.down[i] = SrcLoader.Image(sDown[i]);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// synchronize();
		g.drawRect(x, y, width, height);
		g.drawImage(img, x, y, width, height, null);

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

	public void moveUp() {
		this.movementstate = 0;
		move(this.up, 100);
	}

	public void moveDown() {
		this.movementstate = 1;

		move(this.down, 100);

	}

	public void moveRight() {
		this.movementstate = 2;

		move(this.right, 100);
	}

	public void moveLeft() {
		this.movementstate = 3;

		move(this.left, 100);
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

	public String[] getsRight() {
		return sRight;
	}

	public void setsRight(String[] sRight) {
		this.sRight = sRight;
	}

	public String[] getsLeft() {
		return sLeft;
	}

	public void setsLeft(String[] sLeft) {
		this.sLeft = sLeft;

	}

	public String[] getsUp() {
		return sUp;
	}

	public void setsUp(String[] sUp) {
		this.sUp = sUp;
	}

	public String[] getsDown() {
		return sDown;
	}

	public void setsDown(String[] sDown) {
		this.sDown = sDown;
	}

	public String getCharSprite() {
		return charSprite;
	}

	public void setCharSprite(String charSprite) {
		this.charSprite = charSprite;
	}
	
}
