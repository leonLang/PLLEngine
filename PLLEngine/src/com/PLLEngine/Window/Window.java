package com.PLLEngine.Window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
	protected String WindowName;
	private Dimension screenSize;

	private int width;
	private int height;
	private int x, y;

	public Window() {
		// set default values for JFrame aka GameWindow
		initDefaultWindowSize();

		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initDefaultWindowSize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		width = (int) (screenSize.getWidth() * 0.75);
		height = (int) (screenSize.getHeight() * 0.75);
		relocateWindow();

	}

	public void relocateWindow() {
		try {
			x = (int) (screenSize.getWidth() - width) / 2;
			y = (int) (screenSize.getHeight() - height) / 2;
		} catch (NullPointerException e) {
			System.err.println("screenSize has not been initialisiert");
		}
	}
}
