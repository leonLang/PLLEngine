package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class LayerComponent extends JComponent{
	public abstract void draw(Graphics g,int dx,int dy);
}
