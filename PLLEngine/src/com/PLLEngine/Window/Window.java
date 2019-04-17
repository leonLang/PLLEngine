package com.PLLEngine.Window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String WindowName;
	private Dimension screenSize;
	private int x, y;
	private GameWindow window;
	// script data
	private int width, height;

	//init is needed cause data first has to be loaded to act as paremeter
	public void init() {
		relocateWindow();
		window = new GameWindow();
	}
	// Default size is 3/4 of screen size
	//Methode is essential to center window
	private void initDefaultWindowSize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if(width == 0) {
		width = (int) (screenSize.getWidth() * 0.75);
		height = (int) (screenSize.getHeight() * 0.75);
		}

	}

	// essential to create window dimensions
	public void relocateWindow() {
		initDefaultWindowSize();
		try {
			x = (int) (screenSize.getWidth() - width) / 2;
			y = (int) (screenSize.getHeight() - height) / 2;
		} catch (NullPointerException e) {
			System.err.println("screenSize has not been initialisiert");
		}
	}

//GameWindow inherted in Window class to be able to use Json scripts(NOTE:issue with parent's class)
	public class GameWindow extends JFrame {
		public GameWindow() {
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// x, y, y,width, height of mainclass (Window)
			this.setBounds(x, y, width, height);
		}
	}

	// script getter and setter
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@JsonIgnore
	public GameWindow getWindow() {
		return window;
	}

	@JsonIgnore
	public void setWindow(GameWindow window) {
		this.window = window;
	}
	@JsonIgnore
	public void setTitel(String titel) {
		this.window.setTitle(titel);
	}

}
