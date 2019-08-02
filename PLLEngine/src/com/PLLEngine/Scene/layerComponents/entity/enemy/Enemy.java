package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.collision.CollEnemVSPlay;
import com.PLLEngine.collision.CollObject;
import com.PLLEngine.collision.CollThread;

public class Enemy extends Entitie {
	Movement mv;
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private BufferedImage sprite;
	private int x, y;
	private int width = 20;
	private int height = 20;
	private int wait = 0;
	private boolean collision;
	private Health health;

	public Enemy(int startX, int startY) {
		health = new Health(3);
		x = startX;
		y = startY;

		if (!richtungAll) {
			richtungAll = true;
			richtungOwn = true;
			once = true;
		} else if (richtungAll) {
			richtungAll = false;
			once = true;
		}
		mv = new Movement(richtungOwn);

	}

	@Override
	public void draw(Graphics2D g) {
		/*for (int i = 0; i < CollObject.x.length; i++) {
			System.out.println(CollObject.x[i]);
		}*/
		// ich würd das ganze dann aber von der world aus steuern
		controlHealth(g);
		cameraMovement(x, y, dx, dy);
		collisionCheck();
		synchronize();
		setEntitiyNumber();
		if (sprite != null)
			g.drawImage(sprite, px, py, null);
		g.drawRect(px, py, width, height);

	}

	private void enemyMovement() {
		mv.setX(x);
		mv.setY(y);
		mv.normalMovement(entityNumberOwn);
		x = mv.getX();
		y = mv.getY();

	}

	private void controlHealth(Graphics2D g) {
		g.drawRect(px, py - 8, width, 5);
		g.fillRect(px, py - 8, width * (health.getLives() / health.getStartLives()), 5);
		// If I don't do it with the ( the Rect wont be full because of rounding
		// differences
	}

	private void collisionCheck() {
		// here you can define what should happen after Collision with Player is
		// triggered
		CollEnemVSPlay cl = new CollEnemVSPlay(px, py, 20, 20);
		if (cl.getCollLinks()) {
			health.removeOneHeart();
			collision = true;
		} else if (cl.getCollRechts()) {
			collision = true;
		} else {

		}
	}

	private void synchronize() {

		if (Entitie.synchronize[entityNumberOwn]) {
			Entitie.synchronize[entityNumberOwn] = false;
			enemyMovement();
			/*
			 * if (CollThread.collLeft[entityNumberOwn]) {
			 * 
			 * } else if (CollThread.collRight[entityNumberOwn]) {
			 * 
			 * } else { if (!collision) { //enemyMovement(); } }
			 */

		}
	}

	private void setEntitiyNumber() {
		arrX[entityNumberOwn] = px;
		arrY[entityNumberOwn] = py;
	}

	public void setSprite(BufferedImage br) {
		this.sprite = br;
	}

}
