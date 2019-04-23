package com.PLLEngine.Scene;

import java.awt.Graphics2D;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.collision.CollThread;

public class Player extends Entitie {
	
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private int x, y;
	private int width,height;

	public Player() {
		x = 0;
		y = 0;
	}

	@Override
	public void draw(Graphics2D g) {
		//synchronize();
		g.drawRect(x, y, width, height);

	}

	/* private void synchronize() {
		if (Entitie.synchronize[entityNumberOwn]) {
			Entitie.synchronize[entityNumberOwn] = false;
			if (CollThread.collLeft[entityNumberOwn]) {

			} else if (CollThread.collRight[entityNumberOwn]) {

			} else {
				// enemyMovement();
			}

		}
	}*/
	//wird im späteren Verlauf gebraucht


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
