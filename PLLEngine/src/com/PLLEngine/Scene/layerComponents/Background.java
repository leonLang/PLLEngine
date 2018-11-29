package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;
import java.io.IOException;

import com.PLLEngine.Game.Game;
import com.PLLEngine.srcLoader.SrcLoader;

public class Background extends LayerComponent {
	private SrcLoader loader;
	private String src;
	public Background(String src) {
		 loader = new SrcLoader();
		 this.src = src;
	}

	@Override
	public void draw(Graphics g) {
		try {
			g.drawImage(loader.Image(src), 0, 0, Game.gwindow.width,Game.gwindow.height, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
