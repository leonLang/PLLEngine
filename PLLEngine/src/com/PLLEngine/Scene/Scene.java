//peter
package com.PLLEngine.Scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import com.PLLEngine.Game.Game;
import com.PLLEngine.srcLoader.JsonLoader;

public class Scene extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game game;

	private String stringWorld;
	private World world;

	// TODO Namen ändern ... vllt zu StringPlayer und player ist ja sosnst furchtbar

	private String stringPlayer; // multiplayer?!
	private Player player;

	private String stringGui;
	private GUI gui;
	
	private boolean menue = false;

	public Scene() {
		this.setVisible(true);
	}

	public void init(Game game) {
		try {
			this.game = game;
			this.setBackground(Color.black);
			if(!menue) {
			this.loadPlayer();
			this.loadWorld();
			}
			this.loadGui();
			if(!menue) {
			this.player.init(game);
			this.world.init(game);
			this.player.setX(this.world.offsetX);
			this.player.setY(this.world.offsetY);
			}
		} catch (Exception e) {
			System.err.println("Error in scene init");
			e.printStackTrace();
		}
	}

	public void afterInit() {

	}

	public void draw(Graphics2D g) {
		try {
			this.world.draw(g);
			this.player.draw(g);

			this.gui.draw(g);

		} catch (NullPointerException e) {

		}
	}
	public void sceneDel() {
		this.game.getWindow().getWindow().removeKeyListener(this.player.getController());
	}

	private void loadPlayer() throws IOException {
		this.player = JsonLoader.playerLoader(this.stringPlayer);
	}

	private void loadWorld() throws IOException {
		this.world = JsonLoader.loadWorld(this.stringWorld);
		this.add(this.world);
	}

	private void loadGui() throws IOException {
		this.gui = JsonLoader.InterfaceLoader(this.stringGui);
		this.add(this.gui);
	}

	public String getStringWorld() {
		return stringWorld;
	}

	public void setStringWorld(String world) {
		this.stringWorld = world;

	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Player getPlayer() {
		return this.player;
	}

	public String getStringPlayer() {
		return stringPlayer;
	}

	public void setStringPlayer(String stringPlayer) {
		this.stringPlayer = stringPlayer;
	}

	public String getStringGui() {
		return stringGui;
	}

	public void setStringGui(String stringGui) {
		this.stringGui = stringGui;

	}
	

	public boolean isMenue() {
		return menue;
	}

	public void setMenue(boolean menue) {
		this.menue = menue;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// repaint of window effects Scene as well

		draw((Graphics2D) g);

	}
}
