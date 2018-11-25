package test;

import com.PLLEngine.Game.Game;

public class TestEntry {

	public static void main(String[] args) {
		new Game() {
			public void setup() {
				sysout("this function is called once per game start");
			}
		};

	}

}
