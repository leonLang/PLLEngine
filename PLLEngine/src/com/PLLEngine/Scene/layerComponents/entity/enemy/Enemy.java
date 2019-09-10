package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Color;
//Leon
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.Scene.layerComponents.entity.PassiveEntitie;
import com.PLLEngine.Scene.layerComponents.entity.Shot;
import com.PLLEngine.Scene.layerComponents.entity.ShotEn;
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
	private Shot shot = new Shot(10, 10);
	PassiveEntitie pV;
	ShotEn sE = new ShotEn();
	private int xSmile, ySmile;
	public Enemy(int startX, int startY, int healthE) {
		health = new Health(healthE);
		Entitie.arrHealth[entityNumberOwn] = healthE;
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
		mv = new Movement(richtungOwn, dx, dy);

	}

	@Override
	public void draw(Graphics2D g) {
		/*
		 * for (int i = 0; i < CollObject.x.length; i++) {
		 * System.out.println(CollObject.x[i]); }
		 */
		// shot.drawShot(g, px, py);
		if (Entitie.arrHealth[entityNumberOwn] > 0) {
			controlHealth(g);
			cameraMovement(x, y, dx, dy);
			collisionCheck();
			synchronize();
			setEntitiyPosition();
			if (sprite != null)
				g.drawImage(sprite, px, py, null);
			g.drawRect(px, py, width, height);
			g.drawOval(px + 6, py + 2, 7, 7);
			
			
			/*for (int i = 0; i < 5; i++) {
				g.drawRect(6, 15, 3, 3);
				xSmile++;
				ySmile++;
			}*/

		} else {
			Entitie.arrX[entityNumberOwn] = -10000;
			Entitie.arrY[entityNumberOwn] = -10000;
		}
		
		sE.drawShots(g, Entitie.arrX[entityNumberOwn], Entitie.arrY[entityNumberOwn]);

	}

	private void enemyMovement() {
		mv.setX(x);
		mv.setY(y);
		mv.setDx(dx);
		mv.setDy(dy);
		mv.normalMovement(entityNumberOwn);
		x = mv.getX();
		y = mv.getY();

	}

	private void controlHealth(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.drawRect(px, py - 4, width, 2);
		g.fillRect(px, py - 4, width * Entitie.arrHealth[entityNumberOwn] / health.getStartLives(), 2);
		g.setColor(Color.black);
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

	private void setEntitiyPosition() {
		arrX[entityNumberOwn] = px;
		arrY[entityNumberOwn] = py;
	}

	public void setSprite(BufferedImage br) {
		this.sprite = br;
	}

}
