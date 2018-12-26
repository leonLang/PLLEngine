package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class Enemy extends Entitiy {
	int x = 0, y = 0;
	public static boolean richtungAll;
	private boolean richtungOwn, once;
	int width = 20;
	int height = 20;

	public Enemy(int startX, int startY) {
		dx = startX;
		dy = startY;
		System.out.println(dx);
		if (!richtungAll) {
			richtungAll = true;
			richtungOwn = true;
			once = true;
		} else if (richtungAll) {
			richtungAll = false;
			once = true;
		}

	}

	@Override
	public void draw(Graphics g,int dx,int dy) {
		// Initialize kamera Movement first or there could be problems
		cameraMovement();
		enemyMovement();
		arrX[entityNumberOwn] = dx;
		arrY[entityNumberOwn] = dy;

		g.drawRect(dx, dy, width, height);

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private void enemyMovement() {

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
