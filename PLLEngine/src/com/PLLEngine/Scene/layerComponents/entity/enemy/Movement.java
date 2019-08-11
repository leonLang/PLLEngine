package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.util.Random;

import com.PLLEngine.collision.CollObject;
import com.PLLEngine.collision.CollThread;
import com.PLLEngine.collision.CollWorld;

public class Movement {
	private int nCounter = 0;
	private int direction;
	private int x = 0;
	private int y = 0;
	private boolean richtungOwn;
	private Random rn = new Random();
	private CollObject cO = new CollObject(32, 32);
	private CollWorld cW = new CollWorld(32, 32);
	private int dx;
	private int dy;

	public Movement(boolean richtungOwn, int dx, int dy) {
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
		int xE = Enemy.arrX[entityNumberOwn];
		int yE = Enemy.arrY[entityNumberOwn];
		if (CollThread.collRight[entityNumberOwn] || cO.checkCollisionFromObjects(xE, yE) == 1
				|| cW.collisionRight(dx, dy, xE, yE)) {
			CollThread.collRight[entityNumberOwn] = false;
			direction = 1; // Enemie moves now in the opposite direction
			return 1; // this prevents that two Enemies Stick together
		} else {
			return -1;
		}
	}

	private int moveLeft(int entityNumberOwn) {
		int xE = Enemy.arrX[entityNumberOwn];
		int yE = Enemy.arrY[entityNumberOwn];
		if (CollThread.collLeft[entityNumberOwn] || cO.checkCollisionFromObjects(xE, yE) == 2
				|| cW.collisionLeft(dx, dy, xE, yE)) {
			CollThread.collLeft[entityNumberOwn] = false;
			direction = 0;
			return -1;
		} else {
			return 1;
		}
	}

	private int moveDown(int entityNumberOwn) {
		int xE = Enemy.arrX[entityNumberOwn];
		int yE = Enemy.arrY[entityNumberOwn];
		if (CollThread.collDown[entityNumberOwn] || cO.checkCollisionFromObjects(xE, yE) == 3
				|| cW.collisionDown(dx, dy, xE, yE)) {
			CollThread.collDown[entityNumberOwn] = false;
			direction = 2;
			return -1;
		} else {
			return 1;
		}
	}

	private int moveUp(int entityNumberOwn) {
		int xE = Enemy.arrX[entityNumberOwn];
		int yE = Enemy.arrY[entityNumberOwn];
		if (CollThread.collUp[entityNumberOwn] || cO.checkCollisionFromObjects(xE, yE) == 4
				|| cW.collisionUp(dx, dy, xE, yE)) {
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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
}
