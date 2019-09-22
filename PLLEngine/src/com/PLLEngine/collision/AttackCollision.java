package com.PLLEngine.collision;

/** written by Leon **/
public class AttackCollision {
	private int widthShot;
	private int heightShot;
	private int xShot;
	private int yShot;
	private int widthPlayer = 64;
	private int heightPlayer = 64;
	private int xPlayer = 560;
	private int yPlayer = 362;

	/** Player Values are already added **/
	public AttackCollision(int xShot, int yShot, int widthShot, int heightShot) {
		this.xShot = xShot;
		this.yShot = yShot;
		this.widthShot = widthShot;
		this.heightShot = heightShot;
	}

	/** returns true if the shot touches the player **/
	public boolean seeIfCollisionWithPlayer() {
		Collision co = new Collision(this.xShot, this.yShot, this.widthShot, this.heightShot, this.xPlayer,
				this.yPlayer, this.widthPlayer, this.heightPlayer);
		return co.Coll1();
	}
}
