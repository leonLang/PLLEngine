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

	public CollObject() {

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
			CollObject.x[i] = CollObject.startX[i] + dx;
			CollObject.y[i] = CollObject.startY[i];
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

	public int checkCollisionFromObjectsWithEnemie(int enemieNumber) {
		// if return == 0 then there is no collision
		// if return == 1 then the collision is right
		// if return == 2 then the collision is left
		// if return == 3 then the collision is up
		// if return == 4 then the collision is down

		int enemieWidth = 32;
		int enemieHeight = 32;
		// System.out.println(CollObject.x[0]);
		for (int i = 0; i < CollObject.x.length; i++) {

			Collision cl = new Collision(CollObject.x[i], CollObject.y[i], width, heigth, Entitie.arrX[enemieNumber],
					Entitie.arrY[enemieNumber], enemieWidth, enemieHeight);

			// System.out.println(Entitie.arrX[enemieNumber]);
			if (cl.CollRechts()) {
				System.out.println("Heii");
				return 1;
			} else if (cl.CollLinks()) {
				return 2;
			} else if (cl.CollOben()) {
				return 3;
			} else if (cl.CollUnten()) {
				return 4;
			} else {
			}
		}

		return 0;
	}

}
