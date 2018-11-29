package test;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Scene;

public class TestEntry extends Game {
	public static TestEntry entry;

	public static void main(String[] args) {
		entry = new TestEntry() {
			// Hier kommt der Game code rein, zur �bersicht lohnt sich diese schribweise
			// Alternativ kann man das auch in der klasse selbst machen

			public void preinit() {
				//Hier nur settings reinmachen, die alle vor dem eigentlichen gam geladen werden sollen zb. WindowsLook
				this.setWindowsLook();
			}

			public void init() {
				this.createGameWindow("nam1");
				this.addScene("Zene1",new Scene());
				this.loadScene("Zene1");
				this.getScene("Zene1").LayerCount(4);
				this.getScene("Zene1").addLayer("test", new Layer(),0);
			}
		};
		entry.start();
	}
}
