package com.PLLEngine.collision;

//Leon
public class AttackCollision {
	private int widthShot;
	private int heightShot;
	private int xShot;
	private int yShot;
	private int widthPlayer = 64;
	private int heightPlayer = 64;
	private int xPlayer = 560;
	private int yPlayer = 362;

	public AttackCollision(int xShot, int yShot, int widthShot, int heightShot) {
		this.xShot = xShot;
		this.yShot = yShot;
		this.widthShot = widthShot;
		this.heightShot = heightShot;
	}

	public boolean seeIfCollisionWithPlayer() {
		Collision co = new Collision(xShot, yShot, widthShot, heightShot, xPlayer, yPlayer, widthPlayer, heightPlayer);
		return co.Coll1();
	}
}
