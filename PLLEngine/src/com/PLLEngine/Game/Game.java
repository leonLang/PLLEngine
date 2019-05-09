package com.PLLEngine.Game;

import java.awt.event.KeyEvent;

import com.PLLEngine.Control.Control;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Window.Window;
import com.PLLEngine.srcLoader.JsonLoader;
import com.fasterxml.jackson.annotation.JsonView;
/**
 * default Game class
 * @author tromp
 * 
 */
public class Game implements GameBase {
	/*
	 * this Class normaly get's open with game start. Parameter's and data are
	 * coming from "entry.json"
	 */
	private String _comment, titel, version;
	@JsonView(Window.class)
	private Window window;
	private Scene scene;
	private String loadingScene;
	private GameLoop loop;

	private Control controller;
	private boolean up, down, right, left;

	public Game() {
		setup();
		up = false;
		down = false;
		left = false;
		right = false;
	}

	public String get_comment() {
		return _comment;
	}

	public void set_comment(String _comment) {
		this._comment = _comment;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public String getLoadingScene() {
		return loadingScene;
	}

	public void setLoadingScene(String loadingScene) {
		this.loadingScene = loadingScene;
		try {
			this.scene = JsonLoader.SceneLoader(loadingScene);
		} catch (Exception e) {
			System.err.println("error while loading scene");
			e.printStackTrace();
		}
	}

	@Override
	public void setup() {
		// default setup
		this.controller = new Control(this);
		this.loop = new GameLoop(this);

	}

	@Override
	public void init() {
		// init GameWindow with given properties
		// NOTE: window is just the "class above" the JFrame is a subclass of window ->
		// getWindow()
		window.init();
		window.setTitel(this.titel + " - " + this.version);
		window.getWindow().addKeyListener(controller);
		window.getWindow().requestFocus();
		if (this.scene != null) {
			window.getWindow().add(this.scene);
			this.scene.initScene();
		}

		window.getWindow().setVisible(true);
		this.loop.start();

	}

	@Override
	public void preinit() {
		// TODO Auto-generated method stub

	}

	// Look down to Key methodes for more information
	//TODO  CHANGE
	@Override
	public void update() {
		if (this.scene.getWorld() != null) {
			if (up) {
				this.scene.getWorld().moveUp(5);
			} else if (down) {
				this.scene.getWorld().moveDown(5);
			}
			if (right) {
				this.scene.getWorld().moveRight(5);
			} else if (left) {
				this.scene.getWorld().moveLeft(5);
			}
		}
	}

	@Override
	public void lateupdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		this.window.getWindow().repaint();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public void fluentKeying() {

	}

	// Default Key settings for fluent keypressing
	// TODO vllt ändern und alle keys verfügbar machen
	@Override
	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_F12) {
			// this.init();
		}

	}

	@Override
	public void KeyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.right = false;
		}

	}

	@Override
	public void KeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
