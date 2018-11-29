package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;


public class Scene extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<String, Layer> Scenelayers;

	public Scene() {
		Scenelayers = new HashMap<String, Layer>();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("hello darknes smile friend", 300, 300);
		drawgComponents(g);

	}

	public void addLayer(String componentName, Layer layer) {
		Scenelayers.put(componentName, layer);
	}

	public void drawgComponents(Graphics g) {
		for (Entry<String, Layer> value : Scenelayers.entrySet()) {
			value.getValue().draw(g);
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
