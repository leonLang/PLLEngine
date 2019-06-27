package com.PLLEngine.collision;

public class CollEnemVSPlay {
	private int xPlayer = 600;
	private int yPlayer = 400;
	private int widthPlayer = 64;
	private int heightPlayer = 64;
	private Collision cl;
	private boolean onlyOneShouldActivate;
	//Test
	public CollEnemVSPlay(int xEnemie, int yEnemie, int widthEnemie, int heightEnemie) {
		cl = new Collision(xPlayer, yPlayer, widthPlayer, heightPlayer, xEnemie, yEnemie, widthEnemie, heightEnemie);
	}

	public boolean getCollOben() {
		return cl.CollOben();
	}

	public boolean getCollUnten() {
		return cl.CollUnten();
	}

	public boolean getCollLinks() {
		return cl.CollLinks();
	}

	public boolean getCollRechts() {
		return cl.CollRechts();
	}
}
