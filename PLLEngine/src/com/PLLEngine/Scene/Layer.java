package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import com.PLLEngine.Scene.layerComponents.LayerComponent;


public class Layer {
	private Map<String, LayerComponent> LayerComponents;

	public Layer() {
		LayerComponents = new HashMap<String, LayerComponent>();
	}
	public void addLayerComponents(String name,LayerComponent lComponent) {
		LayerComponents.put(name, lComponent);
	}
	public void draw(Graphics g) {
		for(LayerComponent value : LayerComponents.values()) {
			value.draw(g);
		}
	}
}
