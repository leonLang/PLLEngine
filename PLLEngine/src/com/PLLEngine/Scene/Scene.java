package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Scene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<String, Layer> Scenelayers;
	public String[] LayerOrder;

	public Scene() {
		Scenelayers = new HashMap<String, Layer>();
		LayerOrder = new String[0];
		this.setVisible(true);
	}

	public void LayerCount(int i) {
		LayerOrder = new String[i];
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//repaint of window effects Scene as well
		
		drawLayer(g);

	}

	public void addLayer(String componentName, Layer layer, int index) {
		Scenelayers.put(componentName, layer);
		relocateLayer(componentName, index);
	}

	public void relocateLayer(String componentName, int index) {
		try {
			LayerOrder[index] = componentName;
		} catch (Exception e) {
			System.err.println(new ArrayIndexOutOfBoundsException());
		}
	}
	public void addJSceneComponents(JComponent component) {
		add(component);
	}
	

	public void drawLayer(Graphics g) {
		try {
			for (int i = 0; i < LayerOrder.length; i++) {
				Scenelayers.get(LayerOrder[i]).draw(g);
			}
		} catch (NullPointerException e) {

		}
	}
}
