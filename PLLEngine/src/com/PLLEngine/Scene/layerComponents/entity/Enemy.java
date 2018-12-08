package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

public class Enemy extends Entitiy{
	int x,y;
	public Enemy(int x, int y) {
		x = this.x;
		y = this.y;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		x++;
		g.drawRect(x, y, 300, 300);
	}
}

