package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

public class Enemy extends Entitiy {
	int x = 0, y = 0, dx, dy;

	public Enemy(int startX, int startY) {
		dx = startX;
		dy = startY;
		System.out.println(dx);
	}

	@Override
	public void draw(Graphics g) {
		//Initialize kamera Movement first or there could be problems
		cameraMovement();
		enemyMovement();

		g.drawRect(dx, dy, 300, 300);

	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	private void enemyMovement(){
		dx++;
	}

	private void cameraMovement() {
		dx = dx - x;
		dy = dy - y;
		x = 0;
		y = 0;
	}
}
