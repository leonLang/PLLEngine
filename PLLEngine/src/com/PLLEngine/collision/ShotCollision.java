package com.PLLEngine.collision;

/** Written by Leon **/
import com.PLLEngine.Scene.layerComponents.entity.Entitie;

public class ShotCollision {
	public ShotCollision() {

	}

	/**
	 * Checks if the Enemie is hitted by a Shot from the Player. Needs current
	 * Coordinates from Enemie and Shot
	 **/
	public int shotFromPlayer(int xShot, int yShot, int widthShot, int heightShot, int widthEnemie, int heightEnemie) {
		for (int i = 0; i < Entitie.getArrXLength(); i++) {

			Collision cl = new Collision(xShot, yShot, widthShot, heightShot, Entitie.getArrX(i), Entitie.getArrY(i),
					widthEnemie, heightEnemie);
			if (cl.Coll1()) {
				return i;
			}
		}
		return -1;
	}
}
