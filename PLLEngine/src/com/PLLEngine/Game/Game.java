//peter
package com.PLLEngine.Game;

import com.PLLEngine.Control.Control;
import com.PLLEngine.Scene.Player;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Scene.World;
import com.PLLEngine.Window.Window;
import com.PLLEngine.srcLoader.JsonLoader;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * default Game class
 * 
 * @author tromp
 * 
 */
public class Game implements GameBase {
	/*
	 * this Class normaly get's open with game start. Parameter's and data are
	 * coming from "entry.json"
	 */
	private String _comment, titel, version;
	private String loadingScene;

	@JsonView(Window.class)
	private Window window;
	private Scene scene;
	private GameLoop loop;

	private Control controller;
	private CoordinateSystem cs;

	public Game() {
		setup();
	}

	@Override
	public void setup() {
		// default setup
		// this.controller = new Control(this);
		// this.cs = new CoordinateSystem(this);
		this.loop = new GameLoop(this);
		this.loop.start();

	}

	@Override
	public void init() {
		// init GameWindow with given properties
		// NOTE: window is just the "class above". The JFrame itself is a subclass of
		// window ->
		// getWindow()
		this.window.init(this);
		this.scene.init(this);
		this.loop.paused = false;
		this.window.afterInit();
	}

	@Override
	public void preinit() {

	}

	// Look down to Key methodes for more information
	// TODO CHANGE
	@Override
	public void update() {
		if (this.scene.getWorld() != null) {
			this.scene.getPlayer().update();
//			if (up) {
//				this.scene.getWorld().moveUp(5);
//				this.scene.getPlayer().moveUp();
//			} else if (down) {
//				this.scene.getWorld().moveDown(5);
//				this.scene.getPlayer().moveDown();
//			}
//			if (right) {
//				this.scene.getWorld().moveRight(5);
//				this.scene.getPlayer().moveRight();
//			} else if (left) {
//				this.scene.getWorld().moveLeft(5);
//				this.scene.getPlayer().moveLeft();
//			}
			int i = this.scene.getWorld().eMap.getEventTrigger(
					-this.scene.getPlayer().getX() / this.scene.getWorld().getSpriteSize(),
					-this.scene.getPlayer().getY() / this.scene.getWorld().getSpriteSize());
			if (i != -1) {
				int[][] offset = this.scene.getWorld().eMap.getEventCoordinates();
				System.out.println("Event triggered\nEvent ID: " + i);
				switch (i) {
				case 0:
					/*
					 * Working -> Coordinate class transfer
					 */
					this.scene.getWorld().setDcx(this.scene.getWorld().getDcx() + offset[this.scene.getWorld().eMap.getMapID()][3]);
					this.scene.getWorld().setDcy(this.scene.getWorld().getDcy() + offset[this.scene.getWorld().eMap.getMapID()][4]);

					this.scene.getWorld()
							.setDex(this.scene.getWorld().getDex() - offset[this.scene.getWorld().eMap.getMapID()][3] * this.scene.getWorld().getSpriteSize());
					this.scene.getWorld()
							.setDey(this.scene.getWorld().getDey() - offset[this.scene.getWorld().eMap.getMapID()][4] * this.scene.getWorld().getSpriteSize());

					this.scene.getPlayer()
							.setX(this.scene.getPlayer().getX() - offset[this.scene.getWorld().eMap.getMapID()][3] * this.scene.getWorld().getSpriteSize());
					this.scene.getPlayer()
							.setY(this.scene.getPlayer().getY() - offset[this.scene.getWorld().eMap.getMapID()][4] * this.scene.getWorld().getSpriteSize());
					break;
				case 1:
					this.loop.paused = true;
					this.window.getWindow().remove(this.scene);
					this.scene.sceneDel();
					System.out.println("ID Check: " + offset[this.scene.getWorld().eMap.getMapID()][3]);
					System.out.println("World with ID:" + offset[this.scene.getWorld().eMap.getMapID()][3] + "loaded");
					this.setLoadingScene("scene" + offset[this.scene.getWorld().eMap.getMapID()][3] + ".json");
					this.init();
					this.loop.paused = false;
					break;
				default:

				}
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

	private final class CoordinateSystem {
		private Game g;
		private Player p;
		private World w;

		public CoordinateSystem(Game g) {
			this.g = g;
			this.p = g.getScene().getPlayer();
			this.w = g.getScene().getWorld();
		}
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

	public Control getController() {
		return controller;
	}

	public void setController(Control controller) {
		this.controller = controller;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
