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
import com.PLLEngine.images.Spritesheet;
import com.PLLEngine.images.SpritesheetP;
import com.PLLEngine.srcLoader.JsonLoader;

public class TestEntryy extends Game {
	public static TestEntryy entry;
	public static GameLoop loop;
	public static int dx, dy;
	
	private Player pl;

	public static void main(String[] args) {
		entry = new TestEntryy();
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
				addDefaultController();
				Layer layer1 = new Layer();
				Grid grid1 = new Grid();
				pl = new Player(500, 300);
				Spritesheet sp = new Spritesheet(5, 4, "textures/br.png");
				SpritesheetP scp = new SpritesheetP( "textures/br.png");
				sp.setEntitiy(7, 100, 50, 20, 20);
				sp.setEntitiy(5, 50, 100, 20, 20);
				sp.setEntitiy(5, 0, 100, 20, 20);
				Enemy enm1 = new Enemy(100, 50);
				enm1.setSprite(scp.getSprite(0, 0));
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
				layer1.addLayerComponents("firstsprite", sp);
				loadScene("Zene1");
				loop.start();
			}

		});

	}

	@Override
	public void update() {
		gwindow.getWindow().repaint();

	}
	@Override
	public void KeyPressed(KeyEvent e) {
//		this.addScene("zene2", new Scene());
//		this.loadScene("zene2");
		Layer l = currenScene.getLayer(currenScene.getLayerNameByIndex(0));
		l.setDx(l.getDx()+4);
		
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
