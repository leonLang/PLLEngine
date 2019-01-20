package com.PLLEngine.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.PLLEngine.Scene.Scene;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String WindowName;
	private Dimension screenSize;

	public  int width;
	public  int height;
	private int x, y;

	public Window() {
		// set default values for JFrame aka GameWindow
		initDefaultWindowSize();

		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//defaultWindowScene causes issues with the layer
		//this.add(new defaultWindowScene());
	}

	private void initDefaultWindowSize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		width = (int) (screenSize.getWidth() * 0.75);
		height = (int) (screenSize.getHeight() * 0.75);
		relocateWindow();

	}

	public void relocateWindow() {
		try {
			x = (int) (screenSize.getWidth() -  width)  / 2;
			y = (int) (screenSize.getHeight() - height) / 2;
		} catch (NullPointerException e) {
			System.err.println("screenSize has not been initialisiert");
		}
	}

	
	
	@Deprecated
	protected class defaultWindowScene extends Scene{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public defaultWindowScene() {
			this.setBackground(Color.WHITE);
			this.add(new JLabel("This is the default WindowScene"));
		}
		
	}
}
