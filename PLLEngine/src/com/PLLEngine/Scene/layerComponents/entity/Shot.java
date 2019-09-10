package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Color;
//Leon
import java.awt.Graphics2D;
import java.util.Date;
import com.PLLEngine.collision.ShotCollision;

public class Shot {
	private int x, y;

	public static long timeToWait;
	private int shotTime;
	public boolean shotIsFired; // The number of shots specifie the number of avaible shots in the field
	private int shotMoveLeft, shotMoveRight, shotMoveUp, shotMoveDown;
	private int useX;
	private int useY;
	private int direction;
	private ShotCollision sC = new ShotCollision();

	/**
	 * 
	 * @param shotTime Use milliseconds for the shotTime
	 */
	public Shot(int shotTime) {
		this.shotTime = shotTime;
		// Date dt = new Date();
		// timeToWait = dt.getTime();
		// This Shot is for the pressed Button
	}

	public Shot(int x, int y) {
		// System.out.println("nicht da");
		this.x = x;
		this.y = y;
	}

	public void drawShot(Graphics2D g, int startX, int startY) {
		// Collision needs to be done by the enemie;

		if (this.shotIsFired == true) {
			if (this.useX == 0 && this.useY == 0) {
				this.useX = startX; // this is needed because startX and startY mustn't change after the shot is
				// created
				this.useY = startY;
			}
			int xShot = this.useX + this.shotMoveLeft + this.shotMoveRight + Entitie.dxAll;
			int yShot = this.useY + this.shotMoveDown + this.shotMoveUp + Entitie.dyAll;
			int widthShot = 13;
			int heightShot = 13;
			int enemieShotNumber = this.sC.shotFromPlayer(xShot, yShot, widthShot, heightShot, 32, 32);
			if (enemieShotNumber != -1) {
				Entitie.arrHealth[enemieShotNumber]--;
				this.shotMoveLeft = 1000;
				this.shotMoveRight = 1000;
				this.shotMoveUp = 1000;
				this.shotMoveDown = 1000;
			}
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
			g.setColor(Color.cyan);
			g.fillOval(xShot, yShot, widthShot, heightShot);
			g.drawOval(xShot, yShot, widthShot, heightShot);
			g.setColor(Color.black);
			// g.drawRect(xShot, yShot, widthShot, heightShot);
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

	public boolean removeShot() {
		// remove the Shot as true after an specific time
		return false;
	}

}
