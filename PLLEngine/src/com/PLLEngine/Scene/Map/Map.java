package com.PLLEngine.Scene.Map;

import java.io.IOException;

import com.PLLEngine.srcLoader.JsonLoader;
import com.PLLEngine.srcLoader.RefrenceJson;
import com.PLLEngine.srcLoader.SrcLoader;

public class Map {
	private String refrencePath;
	private RefrenceJson[] loadedsrc;
	private int[][] map;
	private int entryX, entryY;

	public void loadMap() {
		// Load all images for the refrecnes
		new Thread(() -> {
			try {
				loadedsrc = JsonLoader.loadRefrence(refrencePath);
				for (int i = 0; i < loadedsrc.length; i++) {
					loadedsrc[i].setImg(SrcLoader.Image(loadedsrc[i].getPath()));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

	public String getRefrencePath() {
		return refrencePath;
	}

	public void setRefrencePath(String refrencePath) {
		this.refrencePath = refrencePath;
	}

	public RefrenceJson[] getLoadedsrc() {
		return loadedsrc;
	}

	public void setLoadedsrc(RefrenceJson[] loadedsrc) {
		this.loadedsrc = loadedsrc;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getEntryX() {
		return entryX;
	}

	public void setEntryX(int entryX) {
		this.entryX = entryX;
	}

	public int getEntryY() {
		return entryY;
	}

	public void setEntryY(int entryY) {
		this.entryY = entryY;
	}

}
