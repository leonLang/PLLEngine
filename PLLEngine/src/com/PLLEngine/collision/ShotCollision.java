package com.PLLEngine.collision;
//Leon
import com.PLLEngine.Scene.layerComponents.entity.Entitie;

public class ShotCollision {
	public ShotCollision() {

	}

	public int shotFromPlayer(int xShot, int yShot, int widthShot, int heightShot, int widthEnemie, int heightEnemie) {
		for (int i = 0; i < Entitie.arrX.length; i++) {

			Collision cl = new Collision(xShot, yShot, widthShot, heightShot, Entitie.arrX[i], Entitie.arrY[i],
					widthEnemie, heightEnemie);
			if (cl.Coll1()) {
				return i;
			}
		}
		return -1;
	}

	public void shotFromEnemie() {

	}
}
