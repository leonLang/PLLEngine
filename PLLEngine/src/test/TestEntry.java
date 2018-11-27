package test;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.Scene;

public class TestEntry extends Game {

	public static void main(String[] args) {
		new TestEntry() {
			//Hier kommt der Game code rein, zur übersicht lohnt sich diese schribweise
			// Alternativ kann man das auch in der klasse selbst machen
			
			public void preinit() {
				this.setWindowsLook();
				this.createGameWindow("nam1");
				//this.addScene(new Scene());
			}
			
			
			
			
		};
	}
}
