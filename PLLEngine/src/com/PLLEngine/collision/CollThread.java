package com.PLLEngine.collision;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;

/** Written by Leon. **/
/** Uses another Thread for extra Performance **/

public class CollThread extends Thread {

	private static boolean[] collLeft = new boolean[100000];
	private static boolean[] collRight = new boolean[100000];
	private static boolean[] collUp = new boolean[100000];
	private static boolean[] collDown = new boolean[100000];

	/** this let's the Thread run forever but with stops between for performance **/
	@Override
	public void run() {
		this.stopForPerformance(1000);
		this.runAlways();
	}

	private void runAlways() {
		int schleife = 1;
		while (schleife == 1) {
			// playerVSEnemy();
			this.enemyVSEnemy();
			this.stopForPerformance(10);
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
		int amntObjcts = Entitie.getArrXLength();
		int arrX[] = Entitie.getArrXArray();
		int arrY[] = Entitie.getArrYArray();

		this.compareAllObjekts(cntr, amntObjcts, arrX, arrY);

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

	/** Compares all Enemies against each other **/
	private void compareAllObjekts(int counter, int amountObjects, int arrX[], int arrY[]) {
		// combines two for to check each avaible option if there is any Collision.
		for (int i = counter; i < amountObjects; i++) {
			for (int j = counter + 1; j < amountObjects; j++) {
				this.whatToDoBetweenComparison(counter, j, amountObjects, arrX, arrY);
			}
			this.setSynchronization(counter);
			counter++;
		}
	}

	/** sets the Collision for later usage **/
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

	/**
	 * because I use another Thread I need to synchronise it with the main Thread or
	 * else there can be Errors
	 **/
	private void setSynchronization(int counter) {
		Entitie.setSynchronize(true, counter);
		// if the collision check is ready the enemys can move
	}

	/** see if a specific Enemie has a Collision left **/
	public static boolean getCollLeft(int number) {
		return collLeft[number];
	}

	/** see if a specific Enemie has a Collision right **/
	public static boolean getCollRight(int number) {
		return collRight[number];
	}

	/** see if a specific Enemie has a Collision up **/
	public static boolean getCollUp(int number) {
		return collUp[number];
	}

	/** see if a specific Enemie has a Collision down **/
	public static boolean getCollDown(int number) {
		return collDown[number];
	}

	/** set Collision left for a specific enemie **/
	public static void setCollLeft(boolean collLeft, int number) {
		CollThread.collLeft[number] = collLeft;
	}

	/** set Collision right for a specific enemie **/
	public static void setCollRight(boolean collRight, int number) {
		CollThread.collRight[number] = collRight;
	}

	/** set Collision up for a specific enemie **/
	public static void setCollUp(boolean collUp, int number) {
		CollThread.collUp[number] = collUp;
	}

	/** set Collision down for a specific enemie **/
	public static void setCollDown(boolean collDown, int number) {
		CollThread.collDown[number] = collDown;
	}

}
