package com.PLLEngine.Scene.layerComponents.entity.enemy;

public class Movement {
	
	private int x = 0;
	private int y = 0;
	private boolean richtungOwn;
	public Movement(boolean  richtungOwn) {
		this.richtungOwn = richtungOwn;
	}
	public void moveHim() {
		if (!richtungOwn) {
			x--;
		}
		else {
			x++;
		}
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
		
	}
	public int getX() {
		return x;
		
	}
	public int getY() {
		return y;
		
	}
}
