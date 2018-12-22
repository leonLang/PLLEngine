package com.PLLEngine.Scene.layerComponents.entity.collision;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class CollThread extends Thread {
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
				for (int i = 0; i < Entitiy.entityNumberAll; i++) {
					for (int j = counter+1; j < Entitiy.entityNumberAll; j++) {
						Collision cl = new Collision(Entitiy.arrX[counter], Entitiy.arrY[counter], 300, 300, Entitiy.arrX[j], Entitiy.arrY[j], 300,
								300);
						if (cl.Coll1()) {
							System.out.println("Collision");
						}
					}

					counter++;
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
