package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class Enemy extends Entitiy {
	int x = 0, y = 0;
	public static boolean richtungAll;
	private boolean richtungOwn;

	public Enemy(int startX, int startY) {
		dx = startX;
		dy = startY;
		System.out.println(dx);

	}

	@Override
	public void draw(Graphics g) {
		// Initialize kamera Movement first or there could be problems
		cameraMovement();
		enemyMovement();
		arrX[entityNumberOwn] = dx;
		arrY[entityNumberOwn] = dy;

		g.drawRect(dx, dy, 300, 300);

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private void enemyMovement() {
		if (!richtungAll) {
			richtungAll = true;
			richtungOwn = true;
		}
		if (richtungOwn) {
			dx++;
		} else {
			dx--;
		}
	}

	private void cameraMovement() {
		dx = dx - x;
		dy = dy - y;
		x = 0;
		y = 0;
	}
}
