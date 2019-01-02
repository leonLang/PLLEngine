package test;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import com.PLLEngine.Control.Control;
import com.PLLEngine.Game.Game;
import com.PLLEngine.Game.GameLoop;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Scene.layerComponents.Background;
import com.PLLEngine.Scene.layerComponents.Grid;
import com.PLLEngine.Scene.layerComponents.entity.enemy.Enemy;
import com.PLLEngine.Scene.layerComponents.entity.player.Player;
import com.PLLEngine.srcLoader.JsonLoader;

public class TestEntry extends Game {
	public static TestEntry entry;
	public static GameLoop loop;
	public static int dx, dy;

	public static void main(String[] args) {
		entry = new TestEntry();
		entry.start();
	}

	public void preinit() {
		// Hier nur settings reinmachen, die alle vor dem eigentlichen gam geladen
		// werden sollen zb. WindowsLook
		this.setWindowsLook();
		dx = 0;
		dy = 0;
		loop = new GameLoop(this);
	}

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				createGameWindow("nam1");
				// man sollte objecte die teil des Window sind auch immer erst danach erstellen
				Layer layer1 = new Layer();
				Grid grid1 = new Grid(32, 32);
				Player pl = new Player(500, 300);
				Enemy enm1 = new Enemy(100, 50);
				Enemy enm2 = new Enemy(200, 50);
				Enemy enm3 = new Enemy(300, 10);
				Enemy enm4 = new Enemy(400, 50);
				Enemy enm5 = new Enemy(500, 50);
				Enemy enm6 = new Enemy(800, 300);

				addScene("Zene1", new Scene()); // Solange die Scene nicht geladen ist passiert nix
				getScene("Zene1").LayerCount(4);
				grid1.addMap("testmap.json");

				// namen mit zahlen hintendran scheinen nicht zu funktionierens
				// bsp. name war enemy1

				layer1.addLayerComponents("Grid", grid1);
				getScene("Zene1").addLayer("test", layer1, 0);
				layer1.addLayerComponents("aPlayer", pl);
				layer1.addLayerComponents("enemOne", enm1);
				layer1.addLayerComponents("enemTwo", enm2);
				layer1.addLayerComponents("enemThree", enm3);
				layer1.addLayerComponents("enemFour", enm4);
				layer1.addLayerComponents("enemFive", enm5);
				layer1.addLayerComponents("enemSix", enm6);
				addKeyListener(new Control() {
					// provisorischer controll versuch

					@Override
					public void keyPressed(KeyEvent e) {
						dx++;
						layer1.dx = dx;
					}

					@Override
					public void keyReleased(KeyEvent e) {

					}

					@Override
					public void keyTyped(KeyEvent e) {

					}
				});
				loadScene("Zene1");
				loop.start();
			}

		});

	}

	@Override
	public void update() {
		gwindow.repaint();

	}
}
