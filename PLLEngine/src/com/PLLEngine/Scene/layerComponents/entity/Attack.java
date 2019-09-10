package com.PLLEngine.Scene.layerComponents.entity;
//Leon
import java.awt.Graphics2D;

public class Attack {
	private int counterAttack;
	private int timerAttack = 0;
	private boolean fromUpToDown;

	public Attack() {
	}

	public void attackFromPlayer() {

	}

	public void attackFromEnemie() {

	}

	public void drawAttack(Graphics2D g, int px, int py) {
		this.timerAttack++;
		if (this.counterAttack >= 10) {
			this.fromUpToDown = true;
		}
		if (this.counterAttack <= 0) {
			this.fromUpToDown = false;
		}
		if (this.fromUpToDown == true) {
			if (this.timerAttack >= 100) {
				this.counterAttack--;
				this.timerAttack = 0;
			}
			g.drawRect(px + 30 + this.counterAttack, py + 40 - this.counterAttack * 2, 2, 2);
		} else {
			if (this.timerAttack >= 100) {
				this.counterAttack++;
				this.timerAttack = 0;
			}
			g.drawRect(px + 30 + this.counterAttack, py + this.counterAttack * 2, 2, 2);
		}

	}
}
