package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.Scene.layerComponents.entity.PassiveEntitie;
import com.PLLEngine.Scene.layerComponents.entity.ShotEn;
import com.PLLEngine.collision.CollEnemVSPlay;

public class Enemy extends Entitie {
	private Movement mv;
	private static boolean richtungAll;
	private boolean richtungOwn;
	private BufferedImage sprite;
	private int x, y;
	private int width = 20;
	private int height = 20;
	private Health health;
	private PassiveEntitie pV;
	private ShotEn sE = new ShotEn();

	public Enemy(int startX, int startY, int healthE) {
		this.health = new Health(healthE);
		Entitie.setArrHealth(healthE, this.entityNumberOwn);
		this.x = startX;
		this.y = startY;

		if (!richtungAll) {
			richtungAll = true;
			this.richtungOwn = true;
		} else if (richtungAll) {
			richtungAll = false;
		}
		this.mv = new Movement(this.richtungOwn, this.dx, this.dy);

	}

	@Override
	public void draw(Graphics2D g) {
		/*
		 * for (int i = 0; i < CollObject.x.length; i++) {
		 * System.out.println(CollObject.x[i]); }
		 */
		// shot.drawShot(g, px, py);
		if (Entitie.getArrHealth(this.entityNumberOwn) > 0) {
			this.controlHealth(g);
			this.cameraMovement(this.x, this.y, this.dx, this.dy);
			this.collisionCheck();
			this.synchronize();
			this.setEntitiyPosition();
			if (this.sprite != null)
				g.drawImage(this.sprite, this.px, this.py, null);
			g.drawRect(this.px, this.py, this.width, this.height);
			g.drawOval(this.px + 6, this.py + 2, 7, 7);

			/*
			 * for (int i = 0; i < 5; i++) { g.drawRect(6, 15, 3, 3); xSmile++; ySmile++; }
			 */
			this.sE.drawShots(g, Entitie.getArrX(this.entityNumberOwn), Entitie.getArrY(this.entityNumberOwn));
		} else {
			Entitie.setArrX(-10000, this.entityNumberOwn); // teleport the player offscreen to remove it
			Entitie.setArrY(-10000, this.entityNumberOwn);
		}

	}

	private void enemyMovement() {
		this.mv.setX(this.x);
		this.mv.setY(this.y);
		this.mv.setDx(this.dx);
		this.mv.setDy(this.dy);
		this.mv.normalMovement(this.entityNumberOwn);
		this.x = this.mv.getX();
		this.y = this.mv.getY();

	}

	private void controlHealth(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.drawRect(this.px, this.py - 4, this.width, 2);
		g.fillRect(this.px, this.py - 4,
				this.width * Entitie.getArrHealth(this.entityNumberOwn) / this.health.getStartLives(), 2);
		g.setColor(Color.black);
		// If I don't do it with the ( the Rect wont be full because of rounding
		// differences
	}

	private void collisionCheck() {
		// here you can define what should happen after Collision with Player is
		// triggered
		CollEnemVSPlay cl = new CollEnemVSPlay(this.px, this.py, 20, 20);
		if (cl.getCollLinks()) {
			this.health.removeOneHeart();
		} else if (cl.getCollRechts()) {
		} else {

		}
	}

	private void synchronize() {

		if (Entitie.getSynchronize(this.entityNumberOwn)) {
			Entitie.setSynchronize(false, this.entityNumberOwn);
			this.enemyMovement();
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
		setArrX(this.px, this.entityNumberOwn);
		setArrY(this.py, this.entityNumberOwn);
	}

	public void setSprite(BufferedImage br) {
		this.sprite = br;
	}

}
