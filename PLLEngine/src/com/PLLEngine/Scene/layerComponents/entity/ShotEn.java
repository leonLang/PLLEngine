package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.Random;

import com.PLLEngine.Scene.Player;
import com.PLLEngine.collision.AttackCollision;

public class ShotEn {
	private int shotMoveXSpeed, shotMoveYSpeed; // has to be divided by 100
	private int shotMoveX, shotMoveY;
	private long reduceSpeed = 3;
	private long currentDate;
	private int enemieX = 0, enemieY = 0;
	private int reset;
	AttackCollision aC;
	int randomNumber, randomBall;

	public ShotEn() {

	}

	public void drawShots(Graphics2D g, int enemieX, int enemieY) {
		Date dt = new Date();
		if (this.enemieX == 0) {
			// I only need the enemieX in the beginning because if I use it afterwards it
			// uses the Enemie Movement aswell which looks kinda bad.

			this.enemieX = enemieX - Entitie.dxAll;
			this.enemieY = enemieY - Entitie.dyAll;
			// And I can use it to calculate the direction in the beginning of the Shot;
			direction(enemieX, enemieY);
			Random rn = new Random();
			randomNumber = rn.nextInt(500);
			randomBall = rn.nextInt(5);
			currentDate = dt.getTime();
		}
		if (reduceSpeed + currentDate <= dt.getTime()) {

			currentDate = dt.getTime();
			shotMoveX = shotMoveX + shotMoveXSpeed;
			shotMoveY = shotMoveY + shotMoveYSpeed;
			reset++;
		}
		int widthShot = 13;
		int heightShot = 13;
		int xShot = this.enemieX + shotMoveX / 100 + Entitie.dxAll;
		int yShot = this.enemieY + shotMoveY / 100 + Entitie.dyAll;

		switch (randomBall) {
		case 0:
			g.setColor(Color.black);
			break;
		case 1:
			g.setColor(Color.blue);
			break;
		case 2:
			g.setColor(Color.orange);
			break;
		case 3:
			g.setColor(Color.red);
			break;
		case 4:
			g.setColor(Color.green);
			break;

		default:
			break;
		}

		g.drawOval(xShot, yShot, widthShot, heightShot);
		g.fillOval(xShot, yShot, widthShot, heightShot);
		g.setColor(Color.black);
		aC = new AttackCollision(xShot, yShot, widthShot, heightShot);

		if (aC.seeIfCollisionWithPlayer()) {
			this.enemieX = 0;
			this.enemieY = 0;
			this.shotMoveX = 0;
			this.shotMoveY = 0;

			Player.lives--;
		}
		resetShot(randomNumber);

	}

	public void resetShot(int resetTimer) {
		if (reset >= resetTimer) {
			this.enemieX = 0;
			this.enemieY = 0;
			this.shotMoveX = 0;
			this.shotMoveY = 0;
			reset = 0;
		}
	}

	public void direction(int enemieX, int enemieY) {

		float xByYDivided = (float) directionX(enemieX) / (float) directionY(enemieY);
		float yByXDivided = (float) directionY(enemieY) / (float) directionX(enemieX);
		float xFloat;
		float yFloat;
		if (xByYDivided >= 1 || xByYDivided <= -1) {
			shotMoveYSpeed = 100;
			xFloat = 100 * yByXDivided;
			shotMoveXSpeed = (int) xFloat;
		} else {
			shotMoveXSpeed = 100;
			yFloat = 100 * xByYDivided;
			shotMoveYSpeed = (int) yFloat;
		}
	}

	public int directionX(int enemieX) {
		// the direction is placed so that the Enemie shoots in the direction of the
		// Player
		int playerX = 560;
		return enemieX - playerX;
	}

	public int directionY(int enemieY) {
		int playerY = 340;
		return enemieY - playerY;
	}
}

/*
 * public void direction(int enemieX, int enemieY) { // I need to check if the
 * direction is - or + if (directionX(enemieX) >= 1 && directionY(enemieY) >= 1)
 * { // because different rules apply if (directionX(enemieX) >
 * directionY(enemieY)) { shotMoveXSpeed = 100; shotMoveYSpeed = 100 *
 * directionY(enemieY) / directionX(enemieX); } else { shotMoveYSpeed = 100;
 * shotMoveXSpeed = 100 * directionX(enemieX) / directionY(enemieY);
 * 
 * }
 * 
 * } if (directionX(enemieX) <= -1 && directionY(enemieY) <= -1) { // because
 * different rules apply if (directionX(enemieX) < directionY(enemieY)) {
 * shotMoveXSpeed = 100; shotMoveYSpeed = 100 * directionY(enemieY) /
 * directionX(enemieX);
 * 
 * } else { shotMoveYSpeed = 100; shotMoveXSpeed = 100 * directionX(enemieX) /
 * directionY(enemieY); }
 * 
 * }
 * 
 * if (directionX(enemieX) <= -1 && directionY(enemieY) >= 1) { // I need to
 * check if the direction is - or // + because different rules apply if
 * (directionX(enemieX) < directionY(enemieY)) { shotMoveYSpeed = 100;
 * shotMoveXSpeed = 100 * directionX(enemieX) / directionY(enemieY); } else {
 * shotMoveXSpeed = 100; shotMoveYSpeed = 100 * directionY(enemieY) /
 * directionX(enemieX); } }
 * 
 * if (directionX(enemieX) >= 1 && directionY(enemieY) <= -1) { // I need to
 * check if the direction is - or // + because different rules apply if
 * (directionX(enemieX) > directionY(enemieY)) { shotMoveYSpeed = 100;
 * shotMoveXSpeed = 100 * directionX(enemieX) / directionY(enemieY);
 * 
 * } else { shotMoveXSpeed = 100; shotMoveYSpeed = 100 * directionY(enemieY) /
 * directionX(enemieX);
 * 
 * } } }
 */
