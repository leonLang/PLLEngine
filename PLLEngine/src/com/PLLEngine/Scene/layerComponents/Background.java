package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.PLLEngine.Game.Game;
import com.PLLEngine.srcLoader.SrcLoader;

public class Background extends LayerComponent {
	private SrcLoader loader;
	private String src;
	private BufferedImage bImage;
	public Background(String src) {
		 loader = new SrcLoader();
		 this.src = src;
		try {
			bImage=  loader.Image(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics g,int dx,int dy) {
			g.drawImage(bImage, 0, 0, Game.gwindow.width,Game.gwindow.height, null);
	}

}
