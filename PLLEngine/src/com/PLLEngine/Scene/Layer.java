package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.PLLEngine.Scene.layerComponents.LayerComponent;


public class Layer {
	
	private int dx,dy;
	
	
	private Map<String, LayerComponent> LayerComponents;

	public Layer() {
		LayerComponents = new HashMap<String, LayerComponent>();
	}
	public void addLayerComponents(String name,LayerComponent lComponent) {
		LayerComponents.put(name, lComponent);
	}
	public void draw(Graphics g) {
		for(LayerComponent value : LayerComponents.values()) {
			value.draw(g,dx,dy);
		}
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	
}
