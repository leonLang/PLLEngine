package com.PLLEngine.Scene;

import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel implements SceneComponentInterface{
	
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private int x, y;
	private int width,height;

	public Player() {
		this.x = 200;
		this.y = 200;
	}
	public void draw(Graphics2D g) {
		g.drawRect(x, y, width, height);
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
