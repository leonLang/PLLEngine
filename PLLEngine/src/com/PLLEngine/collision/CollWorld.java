package com.PLLEngine.collision;

public class CollWorld {

	// The World has 48 Blocks in X Direction with size 64
	private int worldSizeX = 48 * 64;
	// The World has 27 Blocks in Y direction with size 64
	private int worldSizeY = 27 * 64;

	private int entityWidth;
	private int entityHeigth;

	public CollWorld(int entityWidth, int entityHeigth) {

		this.entityWidth = entityWidth;
		this.entityHeigth = entityHeigth;
		// for this I need the collision around the block
		// 4 Borders are needed

	}

	public boolean collisionRight(int dx, int dy, int entityX, int entityY) {
		int startX = dx + worldSizeX; // I need the WorldSize to move he box to the end of the Border
		int startY = dy;
		Collision cl = new Collision(startX, startY, worldSizeX, worldSizeY, entityX, entityY, entityWidth,
				entityHeigth);
		if (cl.CollRechtsP()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collisionLeft(int dx, int dy, int entityX, int entityY) {
		int startX = dx - worldSizeX;
		// The WorldSize needs to be Subtracted because the Box is created into the
		// right direction
		int startY = dy;
		Collision cl = new Collision(startX, startY, worldSizeX, worldSizeY, entityX, entityY, entityWidth,
				entityHeigth);
		if (cl.CollLinksP()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collisionUp(int dx, int dy, int entityX, int entityY) {
		int startX = dx;
		int startY = dy - worldSizeY;
		Collision cl = new Collision(startX, startY, worldSizeX, worldSizeY, entityX, entityY, entityWidth,
				entityHeigth);

		if (cl.CollUntenP()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collisionDown(int dx, int dy, int entityX, int entityY) {

		int startX = dx;
		int startY = worldSizeY + dy;
		Collision cl = new Collision(startX, startY, worldSizeX, worldSizeY, entityX, entityY, entityWidth,
				entityHeigth);
		if (cl.CollObenP()) {
			return true;
		} else {
			return false;
		}
	}
}
