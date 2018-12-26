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
	public int dx,dy;
	public int dcx,dcy;

	public Grid(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;
		this.dcx = 0;
		this.dcy = 0;
		try {
			cellCountX = Game.gwindow.width / cellX + 1;
			cellCountY = Game.gwindow.height / cellY + 1;
		} catch (NullPointerException e) {
			System.err.println("You cant create a Window component without createing a Window first");
		}
	}

	@Override
	public void draw(Graphics g,int dx, int dy) {
		for (int x = 0; x < cellCountX; x++) {
			for (int y = 0; y < cellCountY; y++) {
				try {
					// for some reason x and y have to be switched
					g.drawImage(map.getLoadedsrc()[map.getMap()[y + dcy][x + dcx]].getImg(), x * cellX - cellX / 2 + dx,
							y * cellY - cellY / 2 + dy, cellX, cellY, null);
					// g.drawRect(x * cellX - cellX / 2, y * cellY - cellY / 2, cellX, cellY);
				} catch (Exception e) {				}
			}
		}
	}

	public void addMap(String path) {
		new Thread(() -> {

			try {
				map = JsonLoader.loadMap(path);
				map.loadMap();
			} catch (IOException e) {
				System.err.println("Can not load map because of: " + e);
				e.printStackTrace();
			}
		}).start();
	}

	public void loadMap() {
		try {
		map.loadMap();
		} catch( Exception e) {
			System.err.println("Map has not been loaded yet");
		}
	}
	public void update() {
		if(true) {
			//add update to optimized map movment
		}
	}

}
