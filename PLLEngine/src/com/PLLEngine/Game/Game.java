package com.PLLEngine.Game;

import com.PLLEngine.Basic.Basic;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Window.Window;

public class Game extends Basic implements GameBase, Runnable {

	public static GameWindow gwindow;

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
		// TODO Auto-generated method stub
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

	@Override
	public void lateupdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public void createGameWindow(String name) {
		gwindow = new GameWindow(name);
	}

	public void addScene(Scene scene) {
		try {
			gwindow.add(scene);
		} catch (NullPointerException e) {
			System.err.println("Cant add scene too GameWindow because: \n" + e);
		}
	}

	public class GameWindow extends Window {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GameWindow(String name) {
			WindowName = name;
		}
	}
}
