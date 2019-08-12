package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics2D;

public class Shot extends Entitie {
	private int x,y;
	public Shot(int x,int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics2D g) {
		cameraMovement(x, y, dx, dy);
		g.drawRect(100, 50, 300, 300);
	}
}
