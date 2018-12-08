package com.PLLEngine.Scene.Map;

import java.io.IOException;

import com.PLLEngine.srcLoader.JsonLoader;
import com.PLLEngine.srcLoader.RefrenceJson;
import com.PLLEngine.srcLoader.SrcLoader;

public class Map {
	private String refrencePath;
	public RefrenceJson[] loadedsrc;
	private int[][] map;

	public void loadMap() {
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

}
