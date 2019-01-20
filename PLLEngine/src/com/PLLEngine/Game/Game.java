package com.PLLEngine.Game;

import java.util.HashMap;
import java.util.Map;

import com.PLLEngine.Basic.Basic;
import com.PLLEngine.Control.Control;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Window.Window;

public class Game extends Basic implements GameBase {

	public static GameWindow gwindow;
	public Map<String, Scene> SceneMap;
	public static Scene currenScene;
	public static double deltaX, deltaY;

	public Game() {
		setup();
		preinit();
	}

	@Override
	public void run() {
		init();

	}

	@Override
	public void setup() {
		SceneMap = new HashMap<String, Scene>();

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void preinit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Deprecated
	@Override
	public void lateupdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public void createGameWindow(String name) {
		gwindow = new GameWindow(name);
	}

	public void addScene(String sceneName, Scene scene) {
		SceneMap.put(sceneName, scene);
	}

	public Scene getScene(String sceneName) {
		return SceneMap.get(sceneName);
	}

	public void loadScene(String scene) {
		try {
		gwindow.remove(currenScene);
		} catch(Exception e) {
			System.err.println("There is not Scene loaded at the moment to replace,\n ignore this message if printed at the start of execution\n");
		}
		currenScene = SceneMap.get(scene);
		if (currenScene != null) {
			try {
				gwindow.add(currenScene);
				gwindow.revalidate();
			} catch (NullPointerException e) {
				System.err.println("Cant add scene too GameWindow because: \n" + e);
			}
		} else {
			System.err.println("No Scene found with name of: \n" + scene);
		}
	}

	public void addKeyListener(Control controler) {
		try {
			gwindow.addKeyListener(controler);
		} catch (NullPointerException e) {
			System.err.println("You cant add a control component without createing a Window first");
		}

	}

	public class GameWindow extends Window {

		private static final long serialVersionUID = 1L;

		public GameWindow(String name) {
			WindowName = name;
			this.setTitle(name);
		}
	}
	//adds the scene with layer
	public void CScene(String SceneName, int LayerCount, Layer layer, String LayerName, int Layerindex) {
		addScene(SceneName, new Scene());
		getScene(SceneName).LayerCount(LayerCount);
		getScene(SceneName).addLayer(LayerName, layer, Layerindex);
	}
}
