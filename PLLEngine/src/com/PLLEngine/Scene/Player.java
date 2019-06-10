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
	private BufferedImage img, img1, img2;
	private boolean animationState;

	public Player() {
		x = 0;
		y = 0;
		img1 = SrcLoader.Image("char1.png");
		img2 = SrcLoader.Image("char2.png");
		img = SrcLoader.Image("char0.png");
		animationState = true;
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

	}

	public void moveDown() {
		if (animationState) {
			new Thread(() -> {
				animationState = false;
				img = img1;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				img = img2;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				animationState = true;

			}).start();
		}
	}

	public void moveRight() {

	}

	public void moveLeft() {

	}

	public void basicAnimation() {

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

}
