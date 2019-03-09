package com.PLLEngine.Game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import com.PLLEngine.Basic.Basic;
import com.PLLEngine.Control.Control;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Window.Window;

public class Game extends Basic implements GameBase {

	public static Window gwindow;
	public static Scene currenScene;
	public static double deltaX, deltaY;
	private Map<String, Scene> SceneMap;
	private Control controler;
	//Script data
	private String _comment,titel,version;
	private int spriteSize;
	private Window window;
	//////////

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
		controler = new Control(this);
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
		gwindow = new Window();
	}
	//add = set
	public void addScene(String sceneName, Scene scene) {
		SceneMap.put(sceneName, scene);
	}

	public Scene getScene(String sceneName) {
		return SceneMap.get(sceneName);
	}
	
	public void addDefaultController() {
		try {
			this.gwindow.addKeyListener(controler);
		} catch(NullPointerException e) {
			System.err.println("Could not add default controller because no window \n  is loaded yet");
		}
	}
	public void loadScene(String scene) {
		//try catch to avoid error when no scene is loading. Always fired when game starts
		try {
		gwindow.remove(currenScene);		
		} catch(Exception e) {
			System.err.println("There is not Scene loaded at the moment to replace,\n ignore this message if printed at the start of execution\n");
		}
		currenScene = SceneMap.get(scene);
		if (currenScene != null) {
			try {
				gwindow.add(currenScene);
				gwindow.revalidate();	//without layout errors may appear
				gwindow.requestFocus();	//without focus controll maynot work
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

	//adds the scene with layer
	public void CScene(String SceneName, int LayerCount, Layer layer, String LayerName, int Layerindex) {
		addScene(SceneName, new Scene());
		getScene(SceneName).LayerCount(LayerCount);
		getScene(SceneName).addLayer(LayerName, layer, Layerindex);
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//getter and setter for script data (JSON)
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

	public int getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
	
}
