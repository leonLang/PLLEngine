package com.PLLEngine.Game;

import java.util.ArrayList;
import java.util.List;

import com.PLLEngine.Basic.Basic;
import com.PLLEngine.Window.Window;

public class Game extends Basic implements GameBase,Runnable {
	
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
