package com.PLLEngine.collision;
//Leon
import com.PLLEngine.Scene.layerComponents.entity.Entitie;

public class CollThread extends Thread {

	public static boolean[] collLeft = new boolean[100000];
	public static boolean[] collRight = new boolean[100000];
	public static boolean[] collUp = new boolean[100000];
	public static boolean[] collDown = new boolean[100000];

	public void run() {
		stopForPerformance(1000);
		runAlways();
	}

	private void runAlways() {
		while (0 == 0) {
			// playerVSEnemy();
			enemyVSEnemy();
			stopForPerformance(10);
		}
	}

	private void stopForPerformance(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void enemyVSEnemy() {
		int cntr = 0; // counter starts with 1 because 0 is the player
		int counterPL = 0;
		int amntObjcts = Entitie.arrX.length;
		int arrX[] = Entitie.arrX;
		int arrY[] = Entitie.arrY;

		compareAllObjekts(cntr, amntObjcts, arrX, arrY);

	}

	/*
	 * private void playerVSEnemy() { int counterPL = 0; int amntObjcts =
	 * Entitie.arrX.length; int arrX[] = Entitie.arrX; int arrY[] = Entitie.arrY;
	 * 
	 * comparePlayerToEnemy(counterPL, amntObjcts, arrX, arrY);
	 * 
	 * }
	 */

	/*
	 * private void comparePlayerToEnemy(int counterPL, int amountObjects, int
	 * arrX[], int arrY[]) { for (int i = counterPL; i < amountObjects; i++) {
	 * checkEnmyPlyrCollision(i, arrX, arrY); } }
	 * 
	 * private void checkEnmyPlyrCollision(int forI, int arrX[], int arrY[]) {
	 * Collision cl = new Collision(400, 400, 32, 32, arrX[forI], arrY[forI], 32,
	 * 32); if (cl.CollRechtsP()) { collRight[forI] = true; } else {
	 * 
	 * } }
	 */

	private void compareAllObjekts(int counter, int amountObjects, int arrX[], int arrY[]) {
		// combines two for to check each avaible option if there is any Collision.
		for (int i = counter; i < amountObjects; i++) {
			for (int j = counter + 1; j < amountObjects; j++) {
				whatToDoBetweenComparison(counter, j, amountObjects, arrX, arrY);
			}
			setSynchronization(counter);
			counter++;
		}
	}

	private void whatToDoBetweenComparison(int counter, int j, int amountObjekts, int arrX[], int arrY[]) {
		Collision cl = new Collision(arrX[counter], arrY[counter], 20, 20, arrX[j], arrY[j], 20, 20);
		if (cl.CollRechtsP()) {
			// j is the right and counter is the opposite
			collLeft[counter] = true;
			collRight[j] = true;
		} else {
		}
		if (cl.CollLinksP()) {
			// j is the right and counter is the opposite
			collRight[counter] = true;
			collLeft[j] = true;
		} else {
		}
		if (cl.CollUntenP()) {
			// j is the right and counter is the opposite
			collDown[counter] = true;
			collUp[j] = true;
		} else {
		}
		if (cl.CollObenP()) {
			// j is the right and counter is the opposite
			collUp[counter] = true;
			collDown[j] = true;
		} else {
		}
	}

	private void setSynchronization(int counter) {
		Entitie.synchronize[counter] = true;
		// if the collision check is ready the enemys can move
	}

}
