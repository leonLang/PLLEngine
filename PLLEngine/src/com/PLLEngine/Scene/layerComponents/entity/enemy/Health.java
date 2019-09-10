package com.PLLEngine.Scene.layerComponents.entity.enemy;
//Leon
public class Health {
	private int startLives;
	private int lives;
	private boolean deathStat;

	public Health(int lives) {
		this.startLives = lives;
		this.lives = lives;
	}

	private void death() {
		if (this.lives >= 0) {
			this.deathStat = true;
		}
	}

	public void removeOneHeart() {
		if (this.lives >0) {
			this.lives--;
		}
		
	}

	public void instantKill() {
		this.lives = 0;
	}

	public boolean isDeath() {
		this.death();
		return this.deathStat;
	}

	public int getLives() {
		return this.lives;
	}
	
	public int getStartLives() {
		return this.startLives;
	}
}
