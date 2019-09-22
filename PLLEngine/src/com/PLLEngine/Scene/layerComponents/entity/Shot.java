package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Color;
//Leon
import java.awt.Graphics2D;
import java.util.Date;
import com.PLLEngine.collision.ShotCollision;

/** Written by Leon **/
/** used for the Player Shots **/
public class Shot {

	private static long timeToWait;
	private int shotTime;
	private boolean shotIsFired; // The number of shots specifie the number of avaible shots in the field
	private int shotMoveLeft, shotMoveRight, shotMoveUp, shotMoveDown;
	private int useX;
	private int useY;
	private int xShot, yShot, widthShot, heightShot;
	private int direction;
	private ShotCollision sC = new ShotCollision();

	/**
	 * define how long it should be after you can fire another shot. Use
	 * milliseconds for the shotTime
	 **/
	public Shot(int shotTime) {
		this.shotTime = shotTime;
	}

	/** draws and manages the Shot **/
	public void drawShot(Graphics2D g, int startX, int startY) {
		// Collision needs to be done by the enemie;
		if (this.shotIsFired == true) {
			OnceafterCreation(startX, startY);
			addVariablesAndremoveShotInClass();
			moveShot();

			g.setColor(Color.cyan);
			g.fillOval(xShot, yShot, widthShot, heightShot);
			g.drawOval(xShot, yShot, widthShot, heightShot);
			g.setColor(Color.black);
		}
		if (this.shotMoveUp <= -500 || this.shotMoveDown >= 500 || this.shotMoveLeft <= -500
				|| this.shotMoveRight >= 500) {
			this.useX = 0;
			this.useY = 0;
			this.shotIsFired = false;
			this.shotMoveDown = 0;
			this.shotMoveUp = 0;
			this.shotMoveLeft = 0;
			this.shotMoveRight = 0;
		}
	}

	/**
	 * this is needed because startX and startY mustn't change after the shot is
	 * created
	 **/
	private void OnceafterCreation(int startX, int startY) {
		if (this.useX == 0 && this.useY == 0) {
			this.useX = startX;
			this.useY = startY;
		}
	}

	private void addVariablesAndremoveShotInClass() {
		xShot = this.useX + this.shotMoveLeft + this.shotMoveRight + Entitie.getDxAll();
		yShot = this.useY + this.shotMoveDown + this.shotMoveUp + Entitie.getDyAll();
		widthShot = 13;
		heightShot = 13;
		int enemieShotNumber = this.sC.shotFromPlayer(xShot, yShot, widthShot, heightShot, 32, 32);
		if (enemieShotNumber != -1) {
			Entitie.setArrHealth(Entitie.getArrHealth(enemieShotNumber) - 1, enemieShotNumber);
			this.shotMoveLeft = 1000;
			this.shotMoveRight = 1000;
			this.shotMoveUp = 1000;
			this.shotMoveDown = 1000;
		}
	}

	private void moveShot() {
		switch (this.direction) {
		case 0:
			this.shotMoveLeft = this.shotMoveLeft - 4;
			break;
		case 1:
			this.shotMoveRight = this.shotMoveRight + 4;
			break;
		case 2:
			this.shotMoveUp = this.shotMoveUp - 4;
			break;
		case 3:
			this.shotMoveDown = this.shotMoveDown + 4;
			break;

		default:
			break;
		}
	}

	/** adds a new Shot to the drawer **/
	public void addShot(int direction) {
		// direction 0 == left
		// direction 1 == right
		// direction 2 == up
		// direction 3 == down
		Date dt = new Date();
		this.direction = direction;
		if (dt.getTime() > Shot.timeToWait) {
			Shot.timeToWait = dt.getTime() + this.shotTime;
			this.shotIsFired = true;
		}
	}

	/** removes an existing Shot **/
	public boolean removeShot() {
		// remove the Shot as true after an specific time
		return false;
	}

	/** if you want to know if the shot is fired or not **/
	public boolean getShotIsFired() {
		return shotIsFired;
	}

}
