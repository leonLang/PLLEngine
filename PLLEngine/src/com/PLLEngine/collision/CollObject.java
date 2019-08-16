package com.PLLEngine.collision;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;

public class CollObject {
	public static int startX[] = new int[0];
	public static int startY[] = new int[0];
	public static int x[] = new int[0];
	public static int y[] = new int[0];
	private int width = 64;
	private int heigth = 64;
	private int counter = 0;
	private int entityWidth;
	private int entityHeigth;

	public CollObject(int entityWidth, int entityHeight) {
		this.entityWidth = entityWidth;
		this.entityHeigth = entityHeight;
	}

	public void setDatas(boolean collision, int rowX, int rowY, int dcx, int dcy) {
		// dx and dy isn't needed
		if (collision) {
			changeAllArraySize();
			CollObject.startX[CollObject.startX.length - 1] = rowX * 64 - dcx * 64;
			CollObject.startY[CollObject.startY.length - 1] = rowY * 64 - dcy * 64;

		}
	}

	public void updateDatas(int dx, int dy) {
		for (int i = 0; i < CollObject.x.length; i++) {
			CollObject.x[i] = CollObject.startX[i] + dx - 30;
			CollObject.y[i] = CollObject.startY[i] + dy - 20;
		}
	}

	private void changeAllArraySize() {
		CollObject.startX = changeOneArraySize(CollObject.startX);
		CollObject.startY = changeOneArraySize(CollObject.startY);
		CollObject.x = changeOneArraySize(CollObject.x);
		CollObject.y = changeOneArraySize(CollObject.y);
	}

	private int[] changeOneArraySize(int arrayO[]) {
		int temp[] = new int[arrayO.length + 1];
		for (int i = 0; i < arrayO.length; i++) {
			temp[i] = arrayO[i];
		}
		arrayO = temp;
		return arrayO;
	}

	public boolean checkCollisionFromObjectsRight(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 64, 64, entityX, entityY, entityWidth,
					entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollRechtsP()) {
				return true;

			}
		}
		return false;
	}

	public boolean checkCollisionFromObjectsLeft(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 64, 64, entityX, entityY, entityWidth,
					entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollLinksP()) {
				return true;

			}
		}
		return false;
	}

	public boolean checkCollisionFromObjectsUp(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 64, 64, entityX, entityY, entityWidth,
					entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollObenP()) {
				return true;

			}
		}
		return false;
	}

	public boolean checkCollisionFromObjectsDown(int entityX, int entityY) {

		for (int i = 0; i < CollObject.x.length; i++) {
			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], 64, 64, entityX, entityY, entityWidth,
					entityHeigth);
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollUntenP()) {
				return true;
			}
		}
		return false;
	}

	public int checkCollisionFromObjects(int entityX, int entityY) {
		// You can't use this for the Player because there can be two states where he
		// has a collision left and down
		// if return == 0 then there is no collision
		// if return == 1 then the collision is right
		// if return == 2 then the collision is left
		// if return == 3 then the collision is up
		// if return == 4 then the collision is down

		for (int i = 0; i < CollObject.x.length; i++) {

			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], width, heigth, entityX, entityY, entityWidth,
					entityHeigth);
			if (cl.Coll1()) {
				// return 5; // for the player because he doesn't need to know if he is right
				// left up or down
				System.out.println("jetzt");
			}
			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollRechtsP()) {
				System.out.println(1);
				return 1;

			} else if (cl.CollLinksP()) {
				System.out.println(2);
				return 2;
			} else if (cl.CollObenP()) {
				System.out.println(3);
				return 3;
			} else if (cl.CollUntenP()) {
				System.out.println(4);
				return 4;
			} else {
			}
		}

		return 0;
	}

}
