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
	private EventMap eMap;
	private int[][] eventCoordinates;

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
				System.err.println("Error while loading map.map");
			}
			try {
				loadEvents();
				
			} catch(Exception e) {
				System.err.println("Error while loading map.Event's");
			}
			
		}).start();
	}
	public void loadEvents() {
		this.eMap = new EventMap(eventCoordinates);
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

	public EventMap geteMap() {
		return eMap;
	}

	public void seteMap(EventMap eMap) {
		this.eMap = eMap;
	}
	public int[][] getEventCoordinates() {
		return eventCoordinates;
	}
	public void setEventCoordinates(int[][] eventCoordinates) {
		this.eventCoordinates = eventCoordinates;
	}
	

}
