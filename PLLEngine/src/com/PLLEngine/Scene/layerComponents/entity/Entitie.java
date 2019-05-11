package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics2D;

import com.PLLEngine.Scene.SceneComponentInterface;
import com.PLLEngine.collision.CollThread;

public class Entitie implements SceneComponentInterface {
	int x12 = 100;
	public static int[] arrX = new int[1];
	public static int[] arrY = new int[1];
	public static boolean[] synchronize = new boolean[100000];
	public int entityNumberOwn;
	private static boolean onlyOnce = false;
	public int px, py;
	protected int dx, dy;

	public Entitie() {
		dx = 0;
		dy = 0;
		// der player muss immer als erstes erstellt werden, dmait er array nummer 0
		// ist.
		entityNumberOwn = arrX.length-1;
		arrX = enlargeArraySize(arrX);
		arrY = enlargeArraySize(arrY);
		if (onlyOnce == false) {
			System.out.println("einmal");
			onlyOnce = true;
			CollThread cT = new CollThread();
			cT.start();
		}
	}

	// Hier ist was ver‰ndert da dx und dy nicht mehr gebraucht werden und ich alles
	// von Graphics g auf graphics2D ge‰ndert habe
	// der unterschied ist gering und sollte nicht auffallen auﬂer mehr features
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawRect(100, 50, 300, 300);
	}
	private int [] enlargeArraySize(int [] arrayN) {
		int [] tmpA = new int [arrayN.length+1];
		System.arraycopy(arrayN, 0, tmpA, 0, arrayN.length);
		arrayN = tmpA;
		return arrayN;
	}
	public void cameraMovement(int x, int y, int dx, int dy) {
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
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

}
