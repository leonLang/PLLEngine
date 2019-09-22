package com.PLLEngine.collision;

/**
 * Written by Leon. This is the Collision from my last Game and it is the
 * fundament for all the other Collisions
 **/
public class Collision {
	private int Obj1Y, Obj1X, Obj1Width, Obj1Height, Obj2X, Obj2Y, Obj2Width, Obj2Height = 0;

	/** it needs all 4 basic values from the 2 Objects **/
	public Collision(int Obj1X, int Obj1Y, int Obj1Width, int Obj1Height, int Obj2X, int Obj2Y, int Obj2Width,
			int Obj2Height) {
		this.Obj1Y = Obj1Y;
		this.Obj1X = Obj1X;
		this.Obj1Width = Obj1Width;
		this.Obj1Height = Obj1Height;
		this.Obj2Y = Obj2Y;
		this.Obj2X = Obj2X;
		this.Obj2Width = Obj2Width;
		this.Obj2Height = Obj2Height;

	}

	/** Returns true if Objekt 1 has a Collision from Objekt 2 which is over it **/
	public boolean CollOben() {
		if (this.Obj1Y + this.Obj1Height >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/** Returns true if Objekt 1 has a Collision from Objekt 2 which is under it **/
	public boolean CollUnten() {

		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns true if Objekt 1 has a Collision from Objekt 2 which is left from it
	 **/
	public boolean CollLinks() {
		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns true if Objekt 1 has a Collision from Objekt 2 which is right from it
	 **/
	public boolean CollRechts() {
		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * If you use an Player it is possible he moves more than one pixel per move
	 * which would result in a Error. This Method solves the Error
	 **/
	public boolean CollUntenP() {
		if (this.Obj1Y + this.Obj1Height + 5 >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * If you use an Player it is possible he moves more than one pixel per move
	 * which would result in a Error. This Method solves the Error
	 **/
	public boolean CollObenP() {
		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height + 5 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * If you use an Player it is possible he moves more than one pixel per move
	 * which would result in a Error. This Method solves the Error
	 **/
	public boolean CollRechtsP() {
		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width + 2 >= this.Obj2X && this.Obj2X + this.Obj2Width - 1 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * If you use an Player it is possible he moves more than one pixel per move
	 * which would result in a Error. This Method solves the Error
	 **/
	public boolean CollLinksP() {
		if (this.Obj1Y + this.Obj1Height - 1 >= this.Obj2Y && this.Obj2Y + this.Obj2Height - 1 >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width - 1 >= this.Obj2X && this.Obj2X + this.Obj2Width + 2 >= this.Obj1X) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * If you don't need something special and just want to know if there is an
	 * Collision then use this
	 **/
	public boolean Coll1() {
		if (this.Obj1Y + this.Obj1Height >= this.Obj2Y && this.Obj2Y + this.Obj2Height >= this.Obj1Y
				&& this.Obj1X + this.Obj1Width >= this.Obj2X && this.Obj2X + this.Obj2Width >= this.Obj1X) {
			return true;
		} else {
			return false;
		}
	}
}
