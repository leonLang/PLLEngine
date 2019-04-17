package com.PLLEngine.Scene;

import java.awt.Graphics;


import javax.swing.JPanel;

import com.PLLEngine.Scene.layerComponents.LayerComponent;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Layer extends JPanel implements SceneComponentInterface{

	private int dx, dy;
	private LayerComponent[] components;

	public Layer() {
	}
	
	public void draw(Graphics g) {
		//for(int i = 0;i < components.length;i++) {
			//components[i].draw(g, 0, 0);
		//}
	}
//	 @JsonIgnore
//		public LayerComponent[] getComponents() {
//			return components;
//		}
//	@JsonIgnore
//		public void setComponents(LayerComponent[] components) {
//			this.components = components;
//		}

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
