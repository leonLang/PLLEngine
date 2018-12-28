package com.PLLEngine.collision;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class CollThread extends Thread {

	public static boolean[] collLeft = new boolean[100000];
	public static boolean[] collRight = new boolean[100000];
	public static boolean[] collUp = new boolean[100000];
	public static boolean[] collDown = new boolean[100000];

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (0 == 0) {
			try {
				int counter = 0;
				// combines two for to check each avaible option if there is any Collision.
				for (int i = 0; i < Entitiy.entityNumberAll; i++) {
					for (int j = counter + 1; j < Entitiy.entityNumberAll; j++) {
						Collision cl = new Collision(Entitiy.arrX[counter], Entitiy.arrY[counter], 20, 20,
								Entitiy.arrX[j], Entitiy.arrY[j], 20, 20);
						if (cl.CollLinks()) {
							// j is the right and counter is the opposite
							collLeft[counter] = true;
							collRight[j] = true;
						} else {

						}
					}
					Entitiy.synchronize[counter] = true;
					// if the collision check is ready the enemys can move
					counter++;
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
