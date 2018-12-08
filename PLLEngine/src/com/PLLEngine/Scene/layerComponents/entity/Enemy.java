package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

public class Enemy extends Entitiy{
	int x = 0,y = 0,dx,dy;
	int startX,startY;
	public Enemy(int startX, int startY) {
		startX = this.startX;
		startY = this.startY;
		dx = startX;
		dy = startY;
	}
	@Override
	public void draw(Graphics g) {
		dx = dx - x;
		dy = dy - y;
		x = 0;
		y = 0;
		
		dx++;
		g.drawRect(dx, dy, x12, 300);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}

