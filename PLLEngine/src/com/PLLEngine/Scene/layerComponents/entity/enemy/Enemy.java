package com.PLLEngine.Scene.layerComponents.entity.enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import com.PLLEngine.Scene.layerComponents.entity.Entitie;
import com.PLLEngine.Scene.layerComponents.entity.ShotEn;

public class Enemy extends Entitie {
	private Movement mv;
	private static boolean richtungAll;
	private boolean richtungOwn;
	private int x, y;
	private int width = 20;
	private int height = 20;
	private Health health;
	private ShotEn sE = new ShotEn();
	private int xSmile, ySmile;
	private int randomColor;

	public Enemy(int startX, int startY, int healthE) {
		Random random = new Random();
		randomColor = random.nextInt(3);
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

			this.cameraMovement(this.x, this.y, this.dx, this.dy);
			this.synchronize();
			this.setEntitiyPosition();
			this.controlHealth(g);
			drawBody(g);
			drawEyes(g);

			if (health.getStartLives() / 2 < Entitie.getArrHealth(entityNumberOwn)) {
				drawSmile(g);
			} else {
				drawUnhappySmile(g);
			}

			this.sE.drawShots(g, Entitie.getArrX(this.entityNumberOwn), Entitie.getArrY(this.entityNumberOwn));
		} else {
			Entitie.setArrX(-10000, this.entityNumberOwn); // teleport the player offscreen to remove it
			Entitie.setArrY(-10000, this.entityNumberOwn);
		}

	}

	private void drawBody(Graphics2D g) {

		switch (randomColor) {
		case 0:
			g.setColor(Color.LIGHT_GRAY);
			break;
		case 1:
			g.setColor(Color.GRAY);
			break;
		case 2:
			g.setColor(Color.WHITE);
			break;

		default:
			break;
		}

		g.drawRect(this.px, this.py, this.width, this.height);
		g.fillRect(this.px, this.py, this.width, this.height);
	}

	private void drawEyes(Graphics2D g) {

		if (health.getStartLives() / 2 < Entitie.getArrHealth(entityNumberOwn)) {
			g.setColor(Color.orange);
		} else {
			g.setColor(Color.RED);
		}

		// Left eye
		g.drawOval(this.px + 2, this.py + 2, 5, 5);
		g.fillOval(this.px + 2, this.py + 2, 5, 5);

		// Right eye
		g.drawOval(this.px + 12, this.py + 2, 5, 5);
		g.fillOval(this.px + 12, this.py + 2, 5, 5);
		g.setColor(Color.black);
	}

	private void drawSmile(Graphics2D g) {
		for (int i = 0; i < 11; i++) {
			if (ySmile < 6) {
				g.drawRect(this.px + 3 + xSmile, this.py + 11 + ySmile, 2, 2);
			}
			xSmile++;
			ySmile++;
			if (ySmile >= 6) {
				g.drawRect(this.px + 2 + xSmile, this.py + 8 - ySmile + 14, 2, 2);
			}
		}
		xSmile = 0;
		ySmile = 0;
	}

	private void drawUnhappySmile(Graphics2D g) {
		for (int i = 0; i < 11; i++) {
			if (ySmile < 6) {
				g.drawRect(this.px + 3 + xSmile, this.py + 16 - ySmile, 2, 2);
			}
			xSmile++;
			ySmile++;
			if (ySmile >= 6) {
				g.drawRect(this.px + 2 + xSmile, this.py + 8 + ySmile - 3, 2, 2);
			}
		}
		xSmile = 0;
		ySmile = 0;
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

}
