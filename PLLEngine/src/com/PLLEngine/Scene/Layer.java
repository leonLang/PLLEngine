package com.PLLEngine.Scene;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.PLLEngine.Scene.layerComponents.LayerComponents;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class Layer extends JPanel implements SceneComponentInterface{


	private int dx, dy;
	private LayerComponents[] component;

	public Layer() {
	}
	
	public void draw(Graphics2D g) {
		//for(int i = 0;i < components.length;i++) {
			//components[i].draw(g, 0, 0);
		//}
	}
	public LayerComponents[] getComponent() {
		return component;
	}
	public void setComponents(LayerComponents[] components) {
		this.component = components;
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
