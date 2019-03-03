package com.PLLEngine.Scene.Map;

public class EventMap {
	private int[][] eventCoordinates;
	public EventMap(int[][] cArray) {
		this.eventCoordinates = cArray;
	}
	
	public int[][] getEventCoordinates() {
		return this.eventCoordinates;
	}
}
