package com.PLLEngine.Scene.layerComponents.entity.enemy;

public class Health {
	private int lives;
	private boolean deathStat;

	public Health(int lives) {
		this.lives = lives;
	}

	private void death() {
		if (lives >= 0) {
			deathStat = true;
		}
	}

	public void removeOneHeart() {
		lives--;
	}

	public void instantKill() {
		lives = 0;
	}

	public boolean isDeath() {
		death();
		return deathStat;
	}

	public int getLives() {
		return lives;
	}
}
