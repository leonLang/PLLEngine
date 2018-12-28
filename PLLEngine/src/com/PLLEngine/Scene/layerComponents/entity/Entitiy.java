package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics;

import com.PLLEngine.Scene.layerComponents.LayerComponent;
import com.PLLEngine.collision.CollThread;

public class Entitiy extends LayerComponent {
	int x12 = 100;
	public static int[] arrX = new int[100000];
	public static int[] arrY = new int[100000];
	public static int entityNumberAll;
	public static boolean[] synchronize = new boolean[100000];
	public int entityNumberOwn;
	private static boolean onlyOnce = false;
	public int px, py;

	public Entitiy() {
		// der player muss immer als erstes erstellt werden, dmait er array nummer 0
		// ist.
		entityNumberOwn = entityNumberAll;
		entityNumberAll++;
		System.out.println(entityNumberAll);
		if (onlyOnce == false) {
			System.out.println("einmal");
			onlyOnce = true;
			CollThread cT = new CollThread();
			cT.start();
		}
	}

	@Override
	public void draw(Graphics g, int dx, int dy) {
		System.out.println("hi");
		// TODO Auto-generated method stub
		g.drawRect(100, 50, 300, 300);
	}

	public void cameraMovement(int x, int y, int dx, int dy) {
		px = x + dx;
		py = y + dy;
	}

}
