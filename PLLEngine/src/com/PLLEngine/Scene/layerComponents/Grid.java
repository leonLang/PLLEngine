package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.SwingUtilities;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.Map.Map;
import com.PLLEngine.srcLoader.JsonLoader;

public class Grid extends LayerComponent {
	private int cellX, cellY;
	private int cellCountX, cellCountY;
	private Map map;
	private int testx;

	public Grid(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;
		testx = 0;
		try {
			cellCountX = Game.gwindow.width / cellX + 1;
			cellCountY = Game.gwindow.height / cellY + 1;
		} catch (NullPointerException e) {
			System.err.println("You cant create a Window component without createing a Window first");
		}
	}

	@Override
	public void draw(Graphics g) {
		for (int x = 0; x < cellCountX; x++) {
			for (int y = 0; y < cellCountY; y++) {
				try {
					g.drawImage(map.getLoadedsrc()[map.getMap()[x][y]].getImg(), x * cellX - cellX / 2,
							y * cellY - cellY / 2, cellX, cellY, null);
					// g.drawRect(x * cellX - cellX / 2, y * cellY - cellY / 2, cellX, cellY);
				} catch (Exception e) {
					
				}
			}
		}
	}

	public void addMap(String path) {

		try {
			map = JsonLoader.loadMap(path);
		} catch (IOException e) {
			System.err.println("Can not load map because of: " + e);
			e.printStackTrace();
		}

	}

	public void loadMap() {
		map.loadMap();
	}

}
