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
	private AttackCollision aC;
	private int randomNumber, randomBall;

	public ShotEn() {

	}

	public void drawShots(Graphics2D g, int enemieX, int enemieY) {
		Date dt = new Date();
		if (this.enemieX == 0) {
			// I only need the enemieX in the beginning because if I use it afterwards it
			// uses the Enemie Movement aswell which looks kinda bad.

			this.enemieX = enemieX - Entitie.getDxAll();
			this.enemieY = enemieY - Entitie.getDyAll();
			// And I can use it to calculate the direction in the beginning of the Shot;
			this.direction(enemieX, enemieY);
			Random rn = new Random();
			this.randomNumber = rn.nextInt(500);
			this.randomBall = rn.nextInt(5);
			this.currentDate = dt.getTime();
		}
		if (this.reduceSpeed + this.currentDate <= dt.getTime()) {

			this.currentDate = dt.getTime();
			this.shotMoveX = this.shotMoveX + this.shotMoveXSpeed;
			this.shotMoveY = this.shotMoveY + this.shotMoveYSpeed;
			this.reset++;
		}
		int widthShot = 13;
		int heightShot = 13;
		int xShot = this.enemieX + this.shotMoveX / 100 + Entitie.getDxAll();
		int yShot = this.enemieY + this.shotMoveY / 100 + Entitie.getDyAll();

		switch (this.randomBall) {
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
		this.aC = new AttackCollision(xShot, yShot, widthShot, heightShot);

		if (this.aC.seeIfCollisionWithPlayer()) {
			this.enemieX = 0;
			this.enemieY = 0;
			this.shotMoveX = 0;
			this.shotMoveY = 0;

			Player.setLives(Player.getLives() - 1);
		}
		this.resetShot(this.randomNumber);

	}

	public void resetShot(int resetTimer) {
		if (this.reset >= resetTimer) {
			this.enemieX = 0;
			this.enemieY = 0;
			this.shotMoveX = 0;
			this.shotMoveY = 0;
			this.reset = 0;
		}
	}

	public void direction(int enemieX, int enemieY) {

		float xByYDivided = (float) this.directionX(enemieX) / (float) this.directionY(enemieY);
		float yByXDivided = (float) this.directionY(enemieY) / (float) this.directionX(enemieX);
		float xFloat;
		float yFloat;
		if (xByYDivided >= 1 || xByYDivided <= -1) {
			this.shotMoveYSpeed = 100;
			xFloat = 100 * yByXDivided;
			this.shotMoveXSpeed = (int) xFloat;
		} else {
			this.shotMoveXSpeed = 100;
			yFloat = 100 * xByYDivided;
			this.shotMoveYSpeed = (int) yFloat;
		}
	}

	public int directionX(int enemieX) {
		// the direction is placed so that the Enemie shoots in the direction of the
		// Player
		int playerX = 590;
		return enemieX - playerX;
	}

	public int directionY(int enemieY) {
		int playerY = 390;
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
