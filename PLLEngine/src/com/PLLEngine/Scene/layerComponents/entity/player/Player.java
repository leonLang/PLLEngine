package com.PLLEngine.Scene.layerComponents.entity.player;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.collision.CollThread;

public class Player extends Entitie {
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private int x, y;
	private int width = 32;
	private int height = 32;

	public Player() {
		x = 200;
		y = 200;

		System.out.println(px);
		if (!richtungAll) {
			richtungAll = true;
			richtungOwn = true;
			once = true;
		} else if (richtungAll) {
			richtungAll = false;
			once = true;
		}

	}

	@Override
	public void draw(Graphics g, int dx, int dy) {
		// Initialize kamera Movement first or there could be problems
		cameraMovement(x, y, dx, dy);
		synchronize();
		setEntitiyNumber();
		g.drawRect(x, y, width, height);

	}

	private void enemyMovement() {

		if (richtungOwn) {
			x++;
		} else {
			x--;
		}
	}

	private void synchronize() {
		if (Entitie.synchronize[entityNumberOwn]) {
			Entitie.synchronize[entityNumberOwn] = false;
			if (CollThread.collLeft[entityNumberOwn]) {

			} else if (CollThread.collRight[entityNumberOwn]) {

			} else {
				// enemyMovement();
			}

		}
	}

	private void setEntitiyNumber() {
		arrX[entityNumberOwn] = px;
		arrY[entityNumberOwn] = py;
		// Player don't need this
	}
}
