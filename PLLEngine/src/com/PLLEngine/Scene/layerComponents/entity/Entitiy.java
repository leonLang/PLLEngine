package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.LayerComponent;

public class Entitiy extends LayerComponent{
	int x12 = 100;
	public Entitiy() {
		System.out.println("hi");
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(100, 50, 300, 300);
	}
	

}
