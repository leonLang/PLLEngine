package com.PLLEngine.Scene.layerComponents;


import javax.swing.JButton;

public class Button extends JButton{
	private String text;
	private int x, y,width,height;
	public Button(int x,int y,int width,int height,String text) {
		this.setBounds(x, y, width, height);
		this.setText(text);
	}
	
}
