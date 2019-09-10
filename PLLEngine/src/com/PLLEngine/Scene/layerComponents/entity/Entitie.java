package com.PLLEngine.Scene.layerComponents.entity;
//Leon
import java.awt.Graphics2D;

import com.PLLEngine.Scene.SceneComponentInterface;
import com.PLLEngine.collision.CollObject;
import com.PLLEngine.collision.CollThread;

public class Entitie implements SceneComponentInterface {
	CollObject cO = new CollObject(32, 32);
	int x12 = 100;
	public static int[] arrX = new int[1];
	public static int[] arrY = new int[1];
	public static int[] arrHealth = new int[1];
	public static int dxAll;
	public static int dyAll;
	public static boolean[] synchronize = new boolean[100000];
	public int entityNumberOwn;
	private static boolean onlyOnce = false;
	public int px, py;
	protected int dx, dy;

	public Entitie() {
		dx = 0;
		dy = 0;
		entityNumberOwn = arrX.length - 1;
		arrX = enlargeArraySize(arrX);
		arrY = enlargeArraySize(arrY);
		arrHealth[arrHealth.length - 1] = 3;
		arrHealth = enlargeArraySize(arrHealth);

		if (onlyOnce == false) {
			System.out.println("einmal");
			onlyOnce = true;
			CollThread cT = new CollThread();
			cT.start();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawRect(100, 50, 300, 300);
	}
	
	public static void resetEnemies() {
		arrX = new int[1];
		arrY = new int[1];
		arrHealth = new int[1];
	}

	private int[] enlargeArraySize(int[] arrayN) {
		int[] tmpA = new int[arrayN.length + 1];
		System.arraycopy(arrayN, 0, tmpA, 0, arrayN.length);
		arrayN = tmpA;
		return arrayN;
	}

	public void cameraMovement(int x, int y, int dx, int dy) {
		cO.updateDatas(dx, dy);
		px = x + dx;
		py = y + dy;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		Entitie.dxAll = dx;
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		Entitie.dyAll = dy;
		this.dy = dy;
	}

}
