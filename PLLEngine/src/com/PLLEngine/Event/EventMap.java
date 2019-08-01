package com.PLLEngine.Event;

public class EventMap {
	private int[][] eventCoordinates;
	private int yArray;
	private int index;
	public EventMap(int[][] cArray) {
		this.eventCoordinates = cArray;
		this.index= 0;
		/**
		 * lenght of event array
		 */
		this.yArray = this.eventCoordinates.length;
		}
	
	public int[][] getEventCoordinates() {
		return this.eventCoordinates;
	}
	public int getEventTrigger(int x,int y) {
		for(int i = 0;i < yArray;i++) {
			if(this.eventCoordinates[i][0]== x) {
				if(this.eventCoordinates[i][1]== y) {
					this.index = i;
					return this.eventCoordinates[i][2];
				}
			}
		}
	return -1;	
	}
	public int getMapID() {
		return this.eventCoordinates[index][3];
	}
	//same but with a range within the target
	public int getEventTrigger(int x,int y,int r) {
		for(int i = 0;i < yArray;i++) {
			if(this.eventCoordinates[i][0] > x+r && this.eventCoordinates[i][0] < x-r) {
				if(this.eventCoordinates[i][1] > y+r && this.eventCoordinates[i][1] < y-r) {
					return this.eventCoordinates[i][2];
				}
			}
		}
	return -1;	
	}
	public void triggerEvent(int i) {
		switch(i) {
		default:
			
		}
	}
}
