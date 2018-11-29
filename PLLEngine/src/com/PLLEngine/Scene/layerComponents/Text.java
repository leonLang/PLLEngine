package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;

public class Text extends LayerComponent {
	private String message;
	private int x, y;

	public Text(String message, int x, int y) {
		this.message = message;
		this.x = x;
		this.y = y;

	}

	@Override
	public void draw(Graphics g) {
		g.drawString(message, x, y);
	}

}
