package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.PLLEngine.srcLoader.JsonLoader;

public class Scene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stringWorld;
	private World world;

	// TODO Namen �ndern ... vllt zu StringPlayer und player ist ja sosnst furchtbar

	private String[] stringPlayer; // multiplayer?!
	private Player[] player;

	private String[] stringLayers;
	private Layer[] layers;

	private String stringGui;
	private GUI gui;

	public Scene() {
		this.setVisible(true);
	}
/**
 * innit scene by loading map and setting dimensions for player position
 * @throws NullpointerException
 */
	public void initScene() {
		try {
			this.world.loadMap();
			for(int i = 0;i < this.player.length;i++) {
				this.player[i].setX(SwingUtilities.getWindowAncestor(this).getWidth()/2);
			    this.player[i].setY(SwingUtilities.getWindowAncestor(this).getHeight()/2);
			}
		} catch (NullPointerException e) {
			System.err.println("No World loaded -> NullPointerException");
		}
	}

	public String getStringWorld() {
		return stringWorld;
	}

	// actually loads the World
	public void setStringWorld(String world) {
		this.stringWorld = world;
		try {
			this.world = JsonLoader.loadWorld(world);
			this.add(this.world);
		} catch (IOException e) {
			System.err.println("error while loading world as layer into scene:");
			e.printStackTrace();
		}

	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Player getPlayer() {
		return this.player[0];
	}
	
	public String[] getStringPlayer() {
		return stringPlayer;
	}

	public void setStringPlayer(String[] stringPlayer) {
		this.stringPlayer = stringPlayer;
		this.player = new Player[stringPlayer.length];
		for (int i = 0; i < stringPlayer.length; i++) {
			try {
				this.player[i] = JsonLoader.playerLoader(stringPlayer[i]);

			} catch (Exception e) {
				System.err.println("error while loading player: " + stringPlayer[i]);
				e.printStackTrace();
			}
		}

	}

	/*
	 * Layer's note wokring at the moment NOTE: Java.swing exception
	 * (this.add(JComponent);)#
	 * 
	 * NOTE: fix by init array^^
	 * 
	 */
	public String[] getStringLayers() {
		return stringLayers;
	}

	public void setStringLayers(String[] stringLayers) {
		this.stringLayers = stringLayers;
		this.layers = new Layer[stringLayers.length];
		for (int i = 0; i < stringLayers.length; i++) {
			try {
				layers[i] = JsonLoader.LayerLoader(stringLayers[i]);

			} catch (Exception e) {
				System.err.println("error while loading layer: " + stringLayers[i]);
				e.printStackTrace();
			}
		}
	}

	public String getStringGui() {
		return stringGui;
	}

	public void setStringGui(String stringGui) {
		this.stringGui = stringGui;
		try {
			this.gui = JsonLoader.InterfaceLoader(stringGui);
			this.add(this.gui);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// repaint of window effects Scene as well

		draw((Graphics2D) g);

	}

	public void draw(Graphics2D g) {
		try {
			this.world.draw(g);
			for (int i = 0; i < stringPlayer.length; i++) {
				this.player[i].draw(g);
			}
			for (int i = 0; i < stringLayers.length; i++) {
				layers[i].draw(g);
			}
			this.gui.draw(g);

		} catch (NullPointerException e) {

		}
	}
}
