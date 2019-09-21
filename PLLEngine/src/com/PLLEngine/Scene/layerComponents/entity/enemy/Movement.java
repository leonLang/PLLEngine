package com.PLLEngine.Scene.layerComponents.entity.enemy;

//Leon
import java.util.Random;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
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
		if (!this.richtungOwn) {
			this.x--;
		} else {
			this.x++;
		}
	}

	public void normalMovement(int entityNumberOwn) {
		this.direction = this.moveInDirectionSpecificTimes();
		switch (this.direction) {
		case 0:
			this.x = this.x + this.moveRight(entityNumberOwn);
			break;

		case 1:
			this.x = this.x + this.moveLeft(entityNumberOwn);
			break;

		case 2:
			this.y = this.y + this.moveUp(entityNumberOwn);
			break;

		case 3:
			this.y = this.y + this.moveDown(entityNumberOwn);
			break;

		default:
			break;
		}
	}

	private int moveInDirectionSpecificTimes() {
		this.nCounter--;
		if (this.nCounter <= 0) {
			this.nCounter = this.rn.nextInt(100);
			this.direction = this.rn.nextInt(4);

		}
		return this.direction;
	}

	private int moveRight(int entityNumberOwn) {
		int xE = Entitie.getArrX(entityNumberOwn);
		int yE = Entitie.getArrY(entityNumberOwn);
		if (CollThread.getCollRight(entityNumberOwn) || this.cO.checkCollisionFromObjects(xE, yE) == 1
				|| this.cW.collisionRight(this.dx, this.dy, xE, yE)) {
			CollThread.setCollRight(false, entityNumberOwn);
			this.direction = 1; // Enemie moves now in the opposite direction
			return 1; // this prevents that two Enemies Stick together
		} else {
			return -1;
		}
	}

	private int moveLeft(int entityNumberOwn) {
		int xE = Entitie.getArrX(entityNumberOwn);
		int yE = Entitie.getArrY(entityNumberOwn);
		if (CollThread.getCollLeft(entityNumberOwn) || this.cO.checkCollisionFromObjects(xE, yE) == 2
				|| this.cW.collisionLeft(this.dx, this.dy, xE, yE)) {
			CollThread.setCollLeft(false, entityNumberOwn);
			this.direction = 0;
			return -1;
		} else {
			return 1;
		}
	}

	private int moveDown(int entityNumberOwn) {
		int xE = Entitie.getArrX(entityNumberOwn);
		int yE = Entitie.getArrY(entityNumberOwn);
		if (CollThread.getCollDown(entityNumberOwn) || this.cO.checkCollisionFromObjects(xE, yE) == 3
				|| this.cW.collisionDown(this.dx, this.dy, xE, yE)) {
			CollThread.setCollDown(false, entityNumberOwn);
			this.direction = 2;
			return -1;
		} else {
			return 1;
		}
	}

	private int moveUp(int entityNumberOwn) {
		int xE = Entitie.getArrX(entityNumberOwn);
		int yE = Entitie.getArrY(entityNumberOwn);
		if (CollThread.getCollUp(entityNumberOwn) || this.cO.checkCollisionFromObjects(xE, yE) == 4
				|| this.cW.collisionUp(this.dx, this.dy, xE, yE)) {
			CollThread.setCollUp(false, entityNumberOwn);
			this.direction = 3;
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
		return this.x;

	}

	public int getY() {
		return this.y;

	}

	public int getDx() {
		return this.dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return this.dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
}
