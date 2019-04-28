package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.PLLEngine.collision.CollEnemVSPlay;
import com.PLLEngine.collision.CollThread;

public class Enemy extends Entitie {
	private static boolean richtungAll;
	private boolean richtungOwn, once;
	private BufferedImage sprite;
	private int x, y;
	private int width = 20;
	private int height = 20;
	private int wait = 0;
	private boolean collision;
	public Enemy(int startX, int startY) {
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

	}

	@Override
	public void draw(Graphics2D g) {
		//ich würd das ganze dann aber von der world aus steuern 
		cameraMovement(x, y, dx, dy);
		collisionCheck();
		synchronize();
		setEntitiyNumber();
		if(sprite != null)
		g.drawImage(sprite, px, py, null);
		g.drawRect(px, py, width, height);

	}

	private void enemyMovement() {

		if (richtungOwn) {
			x++;
		} else {
			x--;
		}
	}
	private void collisionCheck() {
		// here you can define what should happen after Collision with Player is triggered
		CollEnemVSPlay cl = new CollEnemVSPlay(px, py, 20, 20);
		if(cl.getCollLinks()) {
			collision = true;
		}
		else if (cl.getCollRechts()) {
			collision = true;
		}
		else {
			
			
		}
	}
	private void synchronize() {
		if (Entitie.synchronize[entityNumberOwn]) {
			Entitie.synchronize[entityNumberOwn] = false;
			if (CollThread.collLeft[entityNumberOwn]) {

			} else if (CollThread.collRight[entityNumberOwn]) {

			} else {
				if (!collision) {
				enemyMovement();
				}
			}

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
