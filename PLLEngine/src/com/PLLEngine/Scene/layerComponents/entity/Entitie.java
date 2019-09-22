package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics2D;

import com.PLLEngine.Scene.SceneComponentInterface;
import com.PLLEngine.collision.CollObject;
import com.PLLEngine.collision.CollThread;

/** Written by Leon **/
/** Builds the Fundation for my Enemies **/
public class Entitie implements SceneComponentInterface {

	private static int[] arrX = new int[1];
	private static int[] arrY = new int[1];
	private static int[] arrHealth = new int[1];
	private static boolean[] synchronize = new boolean[1]; // to synchronize with the EnemieCollisionThread
	private static int dxAll; // shows you x camera movement
	private static int dyAll; // shows you y camera movement

	protected int entityNumberOwn; // use this to give each Enemie a Number
	protected int px, py;
	protected int dx, dy;
	private static boolean onlyOnce = false; // only create one new Thread
	private CollObject cO = new CollObject(32, 32);

	public Entitie() {
		this.dx = 0;
		this.dy = 0;
		this.entityNumberOwn = arrX.length - 1;
		arrX = this.enlargeArraySize(arrX);
		arrY = this.enlargeArraySize(arrY);
		synchronize = this.enlargeBooleanSize(synchronize);
		arrHealth[arrHealth.length - 1] = 3;
		arrHealth = this.enlargeArraySize(arrHealth);

		if (onlyOnce == false) {
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

	/** reset the Enemies if a new World is created **/
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

	private boolean[] enlargeBooleanSize(boolean[] arrayB) {
		boolean[] tmpA = new boolean[arrayB.length + 1];
		System.arraycopy(arrayB, 0, tmpA, 0, arrayB.length);
		arrayB = tmpA;
		return arrayB;
	}

	/** this creates the cameraMovement **/
	public void cameraMovement(int x, int y, int dx, int dy) {
		this.cO.updateDatas(dx, dy);
		this.px = x + dx;
		this.py = y + dy;
	}

	/** get one value from the X Array **/
	public static int getArrX(int number) {
		return arrX[number];
	}

	/** set one value for the X Array **/
	public static void setArrX(int arrX, int number) {
		Entitie.arrX[number] = arrX;
	}

	/** get the length from the X Array **/
	public static int getArrXLength() {
		return arrX.length;
	}

	/** get the whole X Array **/
	public static int[] getArrXArray() {
		return arrX;
	}

	/** get one Value from ArrY **/
	public static int getArrY(int number) {
		return arrY[number];
	}

	/** get the whole Y Array **/
	public static int[] getArrYArray() {
		return arrY;
	}

	/** set one Value for Y Array **/
	public static void setArrY(int arrY, int number) {
		Entitie.arrY[number] = arrY;
	}

	public static int getArrHealth(int number) {
		return arrHealth[number];
	}

	public static void setArrHealth(int arrHealth, int number) {
		Entitie.arrHealth[number] = arrHealth;
	}

	public static boolean getSynchronize(int number) {
		return synchronize[number];
	}

	public static void setSynchronize(boolean synchronize, int number) {
		Entitie.synchronize[number] = synchronize;
	}

	/** get the x camera Movement **/
	public static int getDxAll() {
		return dxAll;
	}

	/** get the y camera Movement **/
	public static int getDyAll() {
		return dyAll;
	}

	public int getDx() {
		return this.dx;
	}

	public void setDx(int dx) {
		Entitie.dxAll = dx;
		this.dx = dx;
	}

	public int getDy() {
		return this.dy;
	}

	public void setDy(int dy) {
		Entitie.dyAll = dy;
		this.dy = dy;
	}
}
