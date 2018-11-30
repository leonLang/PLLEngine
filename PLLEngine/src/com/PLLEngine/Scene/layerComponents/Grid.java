package com.PLLEngine.Scene.layerComponents;

import java.awt.Graphics;
import java.io.IOException;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.Map.Map;
import com.PLLEngine.srcLoader.JsonLoader;

public class Grid extends LayerComponent {
	private int cellX, cellY;
	private int cellCountX, cellCountY;
	private Map map;

	public Grid(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;

		cellCountX = Game.gwindow.width / cellX + 1;
		cellCountY = Game.gwindow.height / cellY + 1;
	}

	@Override
	public void draw(Graphics g) {
		for (int x = 0; x < cellCountX; x++) {
			for (int y = 0; y < cellCountY; y++) {
				g.drawRect(x * cellX - cellX / 2, y * cellY - cellY / 2, cellX, cellY);

			}
		}

	}

	public void addMap(String path) {
		try {
			this.map = JsonLoader.loadMap(path);
		} catch (IOException e) {
			System.err.println("Can not load map because of: " + e);
			e.printStackTrace();
		}
	}

}
