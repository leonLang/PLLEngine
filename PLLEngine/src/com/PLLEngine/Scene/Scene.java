package com.PLLEngine.Scene;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import com.PLLEngine.srcLoader.JsonLoader;

public class Scene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stringWorld;
	private World world;

	// TODO Namen ändern ... vllt zu StringPlayer und player ist ja sosnst furchtbar

	private String[] stringPlayer; // multiplayer?!
	private Player[] player;

	private String[] stringLayers;
	private Layer[] layers;

	private String stringGui;
	private GUI gui;

	public Scene() {
		this.setVisible(true);
	}

	public void initScene() {
		try {
		this.world.loadMap();
		} catch(NullPointerException e) {
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

	public String[] getStringLayers() {
		return stringLayers;
	}
/*
 * Layer's note wokring at the moment
 * NOTE: Java.swing exception (this.add(JComponent);)
 * 
 */
	@Deprecated
	public void setStringLayers(String[] StringLayers) {
		this.stringLayers = StringLayers;
		for (int i = 0; i < StringLayers.length; i++) {
			try {
				Layer l = JsonLoader.LayerLoader(StringLayers[i]);
				//layers[i] = JsonLoader.LayerLoader(StringLayers[i]);
				//this.add(l);
				
			} catch (IOException e) {
				System.err.println("error while loading layer: " + StringLayers[i]);
				e.printStackTrace();
			}
		}
	}

	public String[] getStringPlayer() {
		return stringPlayer;
	}
	public void setPlayers(String[] stringPlayer) {
		this.stringPlayer = stringPlayer;
		for (int i = 0; i < stringLayers.length; i++) {
			try {
				this.player[i] = JsonLoader.playerLoader(stringPlayer[i]);
				this.add(player[i]);
			} catch (IOException e) {
				System.err.println("error while loading layer: " + stringLayers[i]);
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
		draw(g);

	}

	public void draw(Graphics g) {
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
