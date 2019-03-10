package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.PLLEngine.Scene.Map.World;
import com.PLLEngine.srcLoader.JsonLoader;

public class Scene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int layerLenght = 10;

	private String world;
	private World nonStrinWorld;
	private String[] layers;
	private Layer[] nonStringLayers;

	public Scene() {
		this.setVisible(true);
		nonStringLayers = new Layer[layerLenght];
	}

	public void initScene() {
		this.nonStrinWorld.loadMap();
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
		try {
			this.nonStrinWorld = JsonLoader.loadWorld(world);
			this.add(this.nonStrinWorld);
		} catch (IOException e) {
			System.err.println("error while loading world as layer into scene:");
			e.printStackTrace();
		}
		
	}
	

	public World getNonStrinWorld() {
		return nonStrinWorld;
	}

	public void setNonStrinWorld(World nonStrinWorld) {
		this.nonStrinWorld = nonStrinWorld;
	}

	public String[] getLayers() {
		return layers;
	}

	public void setLayers(String[] layers) {
		this.layers = layers;
		for (int i = 0; i < layers.length; i++) {
			try {
				nonStringLayers[i] = JsonLoader.LayerLoader(layers[i]);
				this.add(nonStringLayers[i]);
			} catch (IOException e) {
				System.err.println("error while loading layer: " + layers[i]);
			}
		}
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// repaint of window effects Scene as well

		draw(g);

	}

	public void draw(Graphics g) {
		try {
			this.nonStrinWorld.draw(g);
			for (int i = 0; i < layers.length; i++) {
				nonStringLayers[i].draw(g);
			}
		} catch (NullPointerException e) {

		}
	}
}
