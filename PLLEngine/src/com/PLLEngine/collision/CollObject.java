package com.PLLEngine.collision;

public class CollObject {
	public static int x[] = new int[0];
	public static int y[] = new int[0];
	public static int width[] = new int[0];
	public static int height[] = new int[0];

	private int counter = 0;

	public CollObject() {

	}

	public void safeDatas(boolean collision, int x, int y, boolean once) {
		if (once) {
			if (collision) {
				changeAllArraySize();
				CollObject.x[CollObject.x.length - 1] = x;
				CollObject.y[CollObject.y.length - 1] = y;

			}
		}
	}

	private void changeAllArraySize() {
		CollObject.x = changeOneArraySize(CollObject.x);
		CollObject.y = changeOneArraySize(CollObject.y);
		changeOneArraySize(width);
		changeOneArraySize(height);
	}

	private int[] changeOneArraySize(int arrayO[]) {
		int temp[] = new int[arrayO.length + 1];
		for (int i = 0; i < arrayO.length; i++) {
			temp[i] = arrayO[i];
		}
		arrayO = temp;
		return arrayO;
	}

}
