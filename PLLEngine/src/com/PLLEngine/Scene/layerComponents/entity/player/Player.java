package com.PLLEngine.Scene.layerComponents.entity.player;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.entity.Entitiy;
import com.PLLEngine.collision.CollThread;

public class Player extends Entitiy {
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	int x, y;
	int width = 50;
	int height = 50;

	public Player(int startX, int startY) {
		x = startX;
		y = startY;
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
		if (Entitiy.synchronize[entityNumberOwn]) {
			Entitiy.synchronize[entityNumberOwn] = false;
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
