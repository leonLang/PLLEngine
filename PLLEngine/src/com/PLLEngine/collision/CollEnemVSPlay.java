package com.PLLEngine.collision;

//Leon
public class CollEnemVSPlay {
	private int xPlayer = 560;
	private int yPlayer = 362;
	private int widthPlayer = 64;
	private int heightPlayer = 64;
	private Collision cl;

	// Test
	public CollEnemVSPlay(int xEnemie, int yEnemie, int widthEnemie, int heightEnemie) {
		this.cl = new Collision(this.xPlayer, this.yPlayer, this.widthPlayer, this.heightPlayer, xEnemie, yEnemie,
				widthEnemie, heightEnemie);
	}

	public boolean getCollOben() {
		return this.cl.CollOben();
	}

	public boolean getCollUnten() {
		return this.cl.CollUnten();
	}

	public boolean getCollLinks() {
		return this.cl.CollLinks();
	}

	public boolean getCollRechts() {
		return this.cl.CollRechts();
	}
}
