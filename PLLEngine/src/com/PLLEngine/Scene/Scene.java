package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Scene extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<String, Layer> Scenelayers;
	public String[] LayerOrder;

	public Scene() {
		Scenelayers = new HashMap<String, Layer>();

	}

	public void LayerCount(int i) {
		LayerOrder = new String[i];
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawLayer(g);

	}

	public void addLayer(String componentName, Layer layer, int index) {
		Scenelayers.put(componentName, layer);
		relocateLayer(componentName,index);
	}

	public void relocateLayer(String componentName, int index) {
		try {
		LayerOrder[index] = componentName;
		} catch(Exception e) {
			System.err.println(new ArrayIndexOutOfBoundsException());
		}
	}

	public void drawLayer(Graphics g) {
		try {
			for (int i = 0; i < LayerOrder.length; i++) {
				Scenelayers.get(LayerOrder[i]).draw(g);
			}
		} catch (NullPointerException e) {
			System.err.println("can not find layer with index");

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
