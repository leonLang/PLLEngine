package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics2D;

public class Shot {
	private int x, y;
	private int counterAttack;
	private int timerAttack = 0;
	private boolean fromUpToDown;

	public Shot(int x, int y) {
		// System.out.println("nicht da");
		this.x = x;
		this.y = y;
	}

	public void drawShot(Graphics2D g, int px, int py) {
		timerAttack++;
		if (counterAttack >= 10) {
			fromUpToDown = true;
		}
		if (counterAttack <= 0) {
			fromUpToDown = false;
		}
		if (fromUpToDown == true) {
			if (timerAttack >= 100) {
				counterAttack--;
				timerAttack = 0;
			}
			g.drawRect(px + 30 + counterAttack, py + 40 - counterAttack * 2, 2, 2);
		} else {
			if (timerAttack >= 100) {
				counterAttack++;
				timerAttack = 0;
			}
			g.drawRect(px + 30 + counterAttack, py + counterAttack * 2, 2, 2);
		}

	}
}
