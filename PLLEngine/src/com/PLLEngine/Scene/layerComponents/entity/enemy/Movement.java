package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.util.Random;

import com.PLLEngine.collision.CollThread;

public class Movement {
	private int nCounter = 0;
	private int direction;
	private int x = 0;
	private int y = 0;
	private boolean richtungOwn;
	private Random rn = new Random();

	public Movement(boolean richtungOwn) {
		this.richtungOwn = richtungOwn;
	}

	public void moveHim() {
		if (!richtungOwn) {
			x--;
		} else {
			x++;
		}
	}

	public void normalMovement(int entityNumberOwn) {
		direction = moveInDirectionSpecificTimes();
		switch (direction) {
		case 0:
			x = x + moveRight(entityNumberOwn);
			break;

		case 1:
			x = x + moveLeft(entityNumberOwn);
			break;

		case 2:
			y = y + moveUp(entityNumberOwn);
			break;

		case 3:
			y = y + moveDown(entityNumberOwn);
			break;

		default:
			System.out.println("hi");
			break;
		}
	}

	private int moveInDirectionSpecificTimes() {
		nCounter--;
		if (nCounter <= 0) {
			nCounter = rn.nextInt(100);
			direction = rn.nextInt(4);

		}
		return direction;
	}

	private int moveRight(int entityNumberOwn) {
		if (CollThread.collRight[entityNumberOwn]) {
			CollThread.collRight[entityNumberOwn] = false;
			direction = 1; // Enemie moves now in the opposite direction
			return 1; // this prevents that two Enemies Stick together
		} else {
			return -1;
		}
	}

	private int moveLeft(int entityNumberOwn) {
		if (CollThread.collLeft[entityNumberOwn]) {
			CollThread.collLeft[entityNumberOwn] = false;
			direction = 0;
			return -1;
		} else {
			return 1;
		}
	}

	private int moveDown(int entityNumberOwn) {
		if (CollThread.collDown[entityNumberOwn]) {
			CollThread.collDown[entityNumberOwn] = false;
			direction = 2;
			return -1;
		} else {
			return 1;
		}
	}

	
	private int moveUp(int entityNumberOwn) {
		if (CollThread.collUp[entityNumberOwn]) {
			CollThread.collUp[entityNumberOwn] = false;
			direction = 3;
			return 1;
		} else {
			return -1;
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;

	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}
}
