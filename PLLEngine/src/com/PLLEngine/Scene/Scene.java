package com.PLLEngine.Scene;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.PLLEngine.Scene.SceneComponents.SceneComponent;

public class Scene extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Scene() {
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		
	}
	public void addSceneComponent(JComponent component) {
		this.add(component);
	}
}
