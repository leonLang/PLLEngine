package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;

public class Text extends LayerComponents {
	private String message;
	private int x, y;

	public Text(String message, int x, int y) {
		this.message = message;
		this.x = x;
		this.y = y;

	}

	@Override
	public void draw(Graphics g,int dx,int dy) {
		g.drawString(message, x, y);
	}

}
