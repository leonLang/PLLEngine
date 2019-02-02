package com.PLLEngine.collision;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

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
			playerVSEnemy();
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
		int cntr = 1; // counter starts with 1 because 0 is the player
		int counterPL = 0;
		int amntObjcts = Entitiy.entityNumberAll;
		int arrX[] = Entitiy.arrX;
		int arrY[] = Entitiy.arrY;

		compareAllObjekts(cntr, amntObjcts, arrX, arrY);

	}

	private void playerVSEnemy() {
		int counterPL = 0;
		int amntObjcts = Entitiy.entityNumberAll;
		int arrX[] = Entitiy.arrX;
		int arrY[] = Entitiy.arrY;

		comparePlayerToEnemy(counterPL, amntObjcts, arrX, arrY);

	}

	private void comparePlayerToEnemy(int counterPL, int amountObjects, int arrX[], int arrY[]) {
		for (int i = counterPL; i < amountObjects; i++) {
			checkEnmyPlyrCollision(i, arrX, arrY);
		}
	}

	private void checkEnmyPlyrCollision(int forI, int arrX[], int arrY[]) {
		Collision cl = new Collision(500, 300, 50, 50, arrX[forI], arrY[forI], 20, 20);
		if (cl.CollRechtsP()) {
			collRight[forI] = true;
		} else {

		}
	}

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
	}

	private void setSynchronization(int counter) {
		Entitiy.synchronize[counter] = true;
		// if the collision check is ready the enemys can move
	}

}