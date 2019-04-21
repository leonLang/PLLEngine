package com.PLLEngine.Scene;

import java.awt.Graphics2D;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.collision.CollThread;

public class Player extends Entitie {
	
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private int x, y;
	private int width,height;

	public Player() {
		x = 0;
		y = 0;

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
	public void draw(Graphics2D g) {
		// Initialize kamera Movement first or there could be problems
		//Denk das cam Movment kann man auch anders noch machen ohne die dx,dy wwerte von graphics weil es ja auch 
		//eher selten zum einssatz kommt wir wollten dem player ja zentral halten, oder?
		//cameraMovement(x, y, dx, dy);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
