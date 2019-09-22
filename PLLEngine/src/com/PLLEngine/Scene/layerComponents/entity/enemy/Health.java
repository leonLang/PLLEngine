package com.PLLEngine.Scene.layerComponents.entity.enemy;

/** Written by Leon **/
public class Health {
	private int startLives;
	private int lives;
	private boolean deathStat;

	/** set startLives **/
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
		if (this.lives > 0) {
			this.lives--;
		}

	}

	/** Kill the Enemie instantly **/
	public void instantKill() {
		this.lives = 0;
	}

	/** Check if the Enemie is death **/
	public boolean isDeath() {
		this.death();
		return this.deathStat;
	}

	/** get Current Lives **/
	public int getLives() {
		return this.lives;
	}

	/** get his beginning lives **/
	public int getStartLives() {
		return this.startLives;
	}
}
