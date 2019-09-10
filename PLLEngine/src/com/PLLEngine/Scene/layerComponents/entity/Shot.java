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

		if (shotIsFired == true) {
			if (useX == 0 && useY == 0) {
				useX = startX; // this is needed because startX and startY mustn't change after the shot is
								// created
				useY = startY;
			}
			int xShot = useX + shotMoveLeft + shotMoveRight + Entitie.dxAll;
			int yShot = useY + shotMoveDown + shotMoveUp + Entitie.dyAll;
			int widthShot = 13;
			int heightShot = 13;
			int enemieShotNumber = sC.shotFromPlayer(xShot, yShot, widthShot, heightShot, 32, 32);
			if (enemieShotNumber != -1) {
				Entitie.arrHealth[enemieShotNumber]--;
				shotMoveLeft = 1000;
				shotMoveRight = 1000;
				shotMoveUp = 1000;
				shotMoveDown = 1000;
			}
			switch (direction) {
			case 0:
				shotMoveLeft = shotMoveLeft - 4;
				break;
			case 1:
				shotMoveRight = shotMoveRight + 4;
				break;
			case 2:
				shotMoveUp = shotMoveUp - 4;
				break;
			case 3:
				shotMoveDown = shotMoveDown + 4;
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
		if (shotMoveUp <= -500 || shotMoveDown >= 500 || shotMoveLeft <= -500 || shotMoveRight >= 500) {
			useX = 0;
			useY = 0;
			shotIsFired = false;
			shotMoveDown = 0;
			shotMoveUp = 0;
			shotMoveLeft = 0;
			shotMoveRight = 0;
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
			Shot.timeToWait = dt.getTime() + shotTime;
			shotIsFired = true;
		}
	}

	public boolean removeShot() {
		// remove the Shot as true after an specific time
		return false;
	}

}
