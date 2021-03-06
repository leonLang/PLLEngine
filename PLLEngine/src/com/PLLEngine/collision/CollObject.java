package com.PLLEngine.collision;

/** Written by Leon **/
public class CollObject {
	private static int x[] = new int[0];
	private static int y[] = new int[0];
	private static int startX[] = new int[0];
	private static int startY[] = new int[0];
	private int width = 64;
	private int heigth = 64;
	private int entityWidth;
	private int entityHeigth;

	/** This Class Checks the Collision with Objects **/
	public CollObject(int entityWidth, int entityHeight) {
		this.entityWidth = entityWidth;
		this.entityHeigth = entityHeight;
	}

	/** this should be called when the Objects are created **/
	public void setDatas(boolean collision, int rowX, int rowY, int dcx, int dcy) {
		// dx and dy isn't needed
		if (collision) {
			this.changeAllArraySize();
			CollObject.startX[CollObject.startX.length - 1] = rowX * 64 - dcx * 64;
			CollObject.startY[CollObject.startY.length - 1] = rowY * 64 - dcy * 64;

		}
	}

	/** If a new Game is started all Arrays should reset **/
	public void resetDatas() {
		startX = new int[0];
		startY = new int[0];
		x = new int[0];
		y = new int[0];
	}

	/**
	 * To Update the Datas it needs the changed x and y. This Method should be used
	 * every update
	 **/
	public void updateDatas(int dx, int dy) {
		for (int i = 0; i < CollObject.x.length; i++) {
			CollObject.x[i] = CollObject.startX[i] + dx - 30;
			CollObject.y[i] = CollObject.startY[i] + dy - 20;
		}
	}

	private void changeAllArraySize() {
		CollObject.startX = this.changeOneArraySize(CollObject.startX);
		CollObject.startY = this.changeOneArraySize(CollObject.startY);
		CollObject.x = this.changeOneArraySize(CollObject.x);
		CollObject.y = this.changeOneArraySize(CollObject.y);
	}

	private int[] changeOneArraySize(int arrayO[]) {
		int temp[] = new int[arrayO.length + 1];
		for (int i = 0; i < arrayO.length; i++) {
			temp[i] = arrayO[i];
		}
		arrayO = temp;
		return arrayO;
	}

	/**
	 * Returns True, if any Object has a Collision with the Enemie from the Right
	 **/
	public boolean checkCollisionFromObjectsRight(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 62, 62, entityX, entityY, this.entityWidth,
					this.entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollRechtsP()) {
				return true;

			}
		}
		return false;
	}

	/**
	 * Returns True, if any Object has a Collision with the Enemie from the Left
	 **/
	public boolean checkCollisionFromObjectsLeft(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 62, 62, entityX, entityY, this.entityWidth,
					this.entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollLinksP()) {
				return true;

			}
		}
		return false;
	}

	/**
	 * Returns True, if any Object has a Collision with the Enemie from Above
	 **/
	public boolean checkCollisionFromObjectsUp(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 62, 62, entityX, entityY, this.entityWidth,
					this.entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollObenP()) {
				return true;

			}
		}
		return false;
	}

	/**
	 * Returns True, if any Object has a Collision with the Enemie from Under
	 **/
	public boolean checkCollisionFromObjectsDown(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 62, 62, entityX, entityY, this.entityWidth,
					this.entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollUntenP()) {
				return true;
			}
		}
		return false;
	}

	/** Not longer usable because of Errors in some cases **/
	public int checkCollisionFromObjects(int entityX, int entityY) {
		// You can't use this for the Player because there can be two states where he
		// has a collision left and down
		// if return == 0 then there is no collision
		// if return == 1 then the collision is right
		// if return == 2 then the collision is left
		// if return == 3 then the collision is up
		// if return == 4 then the collision is down

		for (int i = 0; i < CollObject.x.length; i++) {

			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], this.width, this.heigth, entityX, entityY,
					this.entityWidth, this.entityHeigth);
			if (cl.Coll1()) {
				// return 5; // for the player because he doesn't need to know if he is right
				// left up or down
			}
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollRechtsP()) {
				return 1;

			} else if (cl.CollLinksP()) {
				return 2;
			} else if (cl.CollObenP()) {
				return 3;
			} else if (cl.CollUntenP()) {
				return 4;
			} else {
			}
		}

		return 0;
	}

}
