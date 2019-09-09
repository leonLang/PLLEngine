package com.PLLEngine.Scene.layerComponents.entity;
//Leon
import java.awt.Graphics2D;

import java.util.Date;

import com.PLLEngine.collision.ShotCollision;

public class Shot {
	private int x, y;

	public static long timeToWait;
	private int shotTime;
	public boolean shotIsFired; // The number of shots specifie the number of avaible shots in the field
	private int shotMove;
	private int useX;
	private int useY;
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
				System.out.println("once");
				useX = startX; // this is needed because startX and startY mustn't change after the shot is
								// created
				useY = startY;
			}
			int xShot = useX + shotMove + Entitie.dxAll;
			int yShot = useY + Entitie.dyAll;
			int widthShot = 13;
			int heightShot = 13;
			int enemieShotNumber = sC.shotFromPlayer(xShot, yShot, widthShot, heightShot, 32, 32);
			if (enemieShotNumber != -1) {
				Entitie.arrHealth[enemieShotNumber]--;
				shotMove = 1000;
			}
			shotMove = shotMove + 4;
			g.drawRect(xShot, yShot, widthShot, heightShot);
		}
		if (shotMove >= 500) {
			useX = 0;
			useY = 0;
			shotIsFired = false;
			shotMove = 0;
		}
	}

	public void addShot() {
		Date dt = new Date();
		System.out.println(Shot.timeToWait);
		System.out.println(dt.getTime());
		if (dt.getTime() > Shot.timeToWait) {
			Shot.timeToWait = dt.getTime() + shotTime;
			System.out.println(shotTime);
			shotIsFired = true;
			System.out.println("klappt");
		}
	}

	public boolean removeShot() {
		// remove the Shot as true after an specific time
		return false;
	}

}
