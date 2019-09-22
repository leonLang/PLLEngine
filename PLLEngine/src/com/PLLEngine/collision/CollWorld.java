package com.PLLEngine.collision;

/**
 * Written by Leon. This Class prevents the Enemie from fleeing outside the Map
 **/
public class CollWorld {

	private int worldSizeX = 48 * 64; // The World has 48 Blocks in X Direction with size 64
	private int worldSizeY = 27 * 64; // The World has 27 Blocks in Y direction with size 64
	private int entityWidth;
	private int entityHeigth;

	public CollWorld(int entityWidth, int entityHeigth) {

		this.entityWidth = entityWidth;
		this.entityHeigth = entityHeigth;
		// for this I need the collision around the block
		// 4 Borders are needed

	}

	/** Checks if the Enemie has a Collision with the Border from the right **/
	public boolean collisionRight(int dx, int dy, int entityX, int entityY) {
		int startX = dx + this.worldSizeX; // I need the WorldSize to move he box to the end of the Border
		int startY = dy;
		Collision cl = new Collision(startX, startY, this.worldSizeX, this.worldSizeY, entityX, entityY,
				this.entityWidth, this.entityHeigth);
		if (cl.CollRechtsP()) {
			return true;
		} else {
			return false;
		}
	}

	/** Checks if the Enemie has a Collision with the Border from the left **/
	public boolean collisionLeft(int dx, int dy, int entityX, int entityY) {
		int startX = dx - this.worldSizeX;
		// The WorldSize needs to be Subtracted because the Box is created into the
		// right direction
		int startY = dy;
		Collision cl = new Collision(startX, startY, this.worldSizeX, this.worldSizeY, entityX, entityY,
				this.entityWidth, this.entityHeigth);
		if (cl.CollLinksP()) {
			return true;
		} else {
			return false;
		}
	}

	/** Checks if the Enemie has a Collision with the Border from up **/
	public boolean collisionUp(int dx, int dy, int entityX, int entityY) {
		int startX = dx;
		int startY = dy - this.worldSizeY;
		Collision cl = new Collision(startX, startY, this.worldSizeX, this.worldSizeY, entityX, entityY,
				this.entityWidth, this.entityHeigth);

		if (cl.CollUntenP()) {
			return true;
		} else {
			return false;
		}
	}

	/** Checks if the Enemie has a Collision with the Border from down **/
	public boolean collisionDown(int dx, int dy, int entityX, int entityY) {

		int startX = dx;
		int startY = this.worldSizeY + dy;
		Collision cl = new Collision(startX, startY, this.worldSizeX, this.worldSizeY, entityX, entityY,
				this.entityWidth, this.entityHeigth);
		if (cl.CollObenP()) {
			return true;
		} else {
			return false;
		}
	}
}
