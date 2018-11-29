package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.LayerComponent;

public class Entitiy extends LayerComponent{

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(100, 50, 300, 300);
	}

}
