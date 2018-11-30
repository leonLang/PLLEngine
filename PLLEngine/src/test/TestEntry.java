package test;

import javax.swing.SwingUtilities;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Scene.Map.Map;
import com.PLLEngine.Scene.layerComponents.Background;
import com.PLLEngine.Scene.layerComponents.Grid;
import com.PLLEngine.Scene.layerComponents.entity.Enemy;


public class TestEntry extends Game {
	public static TestEntry entry;

	public static void main(String[] args) {
		entry = new TestEntry() {
			// Hier kommt der Game code rein, zur �bersicht lohnt sich diese schribweise
			// Alternativ kann man das auch in der klasse selbst machen

			public void preinit() {
				// Hier nur settings reinmachen, die alle vor dem eigentlichen gam geladen
				// werden sollen zb. WindowsLook
				this.setWindowsLook();
			}

			public void init() {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						createGameWindow("nam1");
						//man sollte objecte die teil des Window sind auch immer erst danach erstellen
						Layer layer1 = new Layer();
						Grid grid1 = new Grid(32,32);
						addScene("Zene1", new Scene());
						loadScene("Zene1");
						getScene("Zene1").LayerCount(4);
						//layer1.addLayerComponents("background", new Background("Skyline.jpg"));
						//layer1.addLayerComponents("olaf", new Enemy());
						grid1.addMap("testmap.json");
						layer1.addLayerComponents("Grid", grid1);
						getScene("Zene1").addLayer("test",layer1 , 0);
						
					}

				});
			}
		};
		entry.start();
	}
}
