package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import com.PLLEngine.Window.Window;
import com.PLLEngine.srcLoader.SrcLoader;

public class Background extends LayerComponents {
	private SrcLoader loader;
	private String src;
	private BufferedImage bImage;
	private JFrame w;

	public Background(String src) {
		loader = new SrcLoader();
		this.src = src;
		bImage = loader.Image(src);
	}

	public void draw(Graphics g, int dx, int dy) {
		g.drawImage(bImage, 0, 0, w.getWidth(), w.getHeight(), null);
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public BufferedImage getbImage() {
		return bImage;
	}

	public void setbImage(BufferedImage bImage) {
		this.bImage = bImage;
	}

}
