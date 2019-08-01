package com.PLLEngine.Scene;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.PLLEngine.Event.EventMap;
import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.layerComponents.entity.enemy.Enemy;
import com.PLLEngine.images.SpritesheetP;
import com.PLLEngine.srcLoader.JsonLoader;
import com.PLLEngine.srcLoader.RefrenceJson;
import com.PLLEngine.srcLoader.SrcLoader;

@SuppressWarnings("serial")
public class World extends JPanel implements SceneComponentInterface {
	/*
	 * The World contains all data about world especially the map data itself Render
	 * data Structure: World |_Map | |_Entites
	 */

	private Game game;
	private String refrencePath;
	private String spriteSheet;
	private RefrenceJson[] loadedsrc;
	private Enemy[] enemysrc;
	private int[][] map;
	private int defaultTexture;
	private int[][] eventCoordinates;
	private int[][] enemies;
	private int entryX, entryY;
	private int spriteSize;
	private int cellCountX, cellCountY;
	public int offsetX, offsetY;
	public EventMap eMap;

	/**
	 * this number set#s the amount of Rendering Threads. The Screen is split into
	 * the amount of frames each frame calculates it's own proccesing data(image
	 * data)
	 */
	// private int renderingThreads,currentThread;
	// default delta with reset at cellCount
	private int dx, dy;
	// cell dx dcx = cellCount * dx
	private int dcx, dcy;
	// entity dex = dx with no reset
	private int dex, dey;

	public World() {
		/**
		 * dx&dy is by pixel's the offset to the starting location
		 */
		this.dx = 0;
		this.dy = 0;
		/**
		 * dcx&dcy is by cell's the offset the starting location
		 **/
		this.dcx = 0;
		this.dcy = 0;
		/**
		 * dey&dex is for enemies offset
		 */
		this.dex = 0;
		this.dey = 0;
	}

	public void init(Game game) {
		this.game = game;
		// World is getting rendern as big as the screen is
		// this methode is impoveable
		Dimension screenSize = SwingUtilities.getWindowAncestor(this.getParent()).getSize();
		cellCountX = (int) (screenSize.getWidth() / spriteSize + 1);
		cellCountY = (int) (screenSize.getHeight() / spriteSize + 1);
		/*
		 * renderingThreads = 1; if (cellCountX > 16 || cellCountY > 16) {
		 * renderingThreads = renderingThreads * 2; }
		 */

		this.loadRefrence();

		this.loadEvents();

		this.loadEnemies();

		this.dcx = this.entryX - game.getScene().getPlayer().getxOnScreen() / this.spriteSize;
		this.dcy = this.entryY - game.getScene().getPlayer().getyOnScreen() / this.spriteSize;
		
		this.dex = this.entryX + game.getScene().getPlayer().getxOnScreen();
		this.dey = this.entryY + game.getScene().getPlayer().getyOnScreen();
	}

	private void loadEnemies() {
		try {
			enemysrc = new Enemy[enemies.length];
			for (int i = 0; i < enemysrc.length; i++) {
				enemysrc[i] = new Enemy(enemies[i][0] * this.spriteSize, enemies[i][1] * this.spriteSize);
			}
		} catch (Exception e) {
			System.err.println("Error while loading map.entities");
		}
	}

	public void loadEvents() {
		try {
			this.eMap = new EventMap(eventCoordinates);
		} catch (Exception e) {
			System.err.println("Error while loading Event map");
		}
	}

	protected void loadRefrence() {
		try {
			loadedsrc = JsonLoader.loadRefrence(refrencePath);
			if (this.spriteSheet != null) {
				SpritesheetP sh = new SpritesheetP(16, 16, this.spriteSheet);
				for (int i = 0; i < loadedsrc.length; i++) {
					//// Conector
					if (loadedsrc[i].getConnector() != null) {
						try {
							BufferedImage img = new BufferedImage(spriteSize, spriteSize, BufferedImage.TYPE_INT_RGB);
							Graphics g = img.getGraphics();
							for (int index = 0; index < loadedsrc[i].getConnector().length; index++) {
								// very compact version ... somehow...
								g.drawImage(loadedsrc[loadedsrc[i].getConnector()[index]].getImg(),
										(index < 2 ? 0 : 1) * this.spriteSize / 2,
										((index == 0 || index == 2) ? 0 : 1) * this.spriteSize / 2, this.spriteSize / 2,
										this.spriteSize / 2, null);
							}
							loadedsrc[i].setImg(img);

						} catch (Exception e) {
							System.err.println("Can't load META_SPRITE check if required sprites are loaded");
						}
						////////
					} else {
						if (loadedsrc[i].getPath() == null)
							loadedsrc[i].setImg(sh.getSprite(loadedsrc[i].getSpriteX(), loadedsrc[i].getSpriteY()));
						else
							loadedsrc[i].setImg(SrcLoader.Image(loadedsrc[i].getPath()));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while loading map.map");
		}
	}

	public void draw(Graphics2D g) {
		/*
		 * NOTE: synchonise?
		 * Gescheiterter versuch für multithreading redering for (int i = 0; i <
		 * this.renderingThreads; i++) { this.currentThread = i; new Thread(() -> { for
		 * (int x = -1+(cellCountX/renderingThreads)*currentThread; x <
		 * cellCountX/2+((cellCountX/2) *currentThread) + 1; x++) { for (int y =
		 * -1+(cellCountY/renderingThreads)*currentThread; y <
		 * cellCountY/2+((cellCountY/2) *currentThread) + 1; y++) {
		 * 
		 * } } }).start(); }
		 */
		for (int x = -1; x < cellCountX + 1; x++) {
			for (int y = -1; y < cellCountY; y++) {
				try {
					/*
					 * NOTE: do NOT mess with the numbers, wierd stuff will happen....
					 */
					/**
					 * draw map NOTE: map data is drawen within the world class while other data
					 * get's drawn outside first draw, draws backgrounbd texture
					 **/
					g.drawImage(
							(loadedsrc[map[y + dcy][x + dcx]].getImg() == null) ? null
									: loadedsrc[this.defaultTexture].getImg(),
							x * spriteSize + dx, y * spriteSize + dy, spriteSize, spriteSize, null);
					// second draw draws "builded" layer
					g.drawImage(loadedsrc[map[y + dcy][x + dcx]].getImg(), x * spriteSize + dx, y * spriteSize + dy,
							spriteSize, spriteSize, null);
					// draw enemies
					for (int i = 0; i < enemysrc.length; i++) {
						// enemysrc[i].cameraMovement(enemysrc[i].getPx(), enemysrc[i].getPy(), dx, dy);
						enemysrc[i].setDx(dex);
						enemysrc[i].setDy(dey);
						enemysrc[i].draw(g);

					}

					// g.drawRect(x * spriteSize + dx, y * spriteSize + dy, spriteSize, spriteSize);
				} catch (Exception e) {
				}
			}
		}
	}

	public void update() {
		if (dx > this.spriteSize) {
			this.dcx--;
			this.dx = this.dx - this.spriteSize;
		} else if (dx < -this.spriteSize) {
			this.dcx++;
			this.dx = this.dx + this.spriteSize;
			;
		}

		if (dy > this.spriteSize) {
			this.dcy--;
			this.dy = this.dy - this.spriteSize;
			;
		} else if (dy < -this.spriteSize) {
			this.dcy++;
			this.dy = this.dy + this.spriteSize;
			;
		}
		// events

	}

	public void moveUp(int px) {
		this.dy = this.dy + px;
		this.dey += px;
		this.update();

	}

	public void moveDown(int px) {
		this.dy = this.dy - px;
		this.dey -= px;
		this.update();
	}

	public void moveRight(int px) {
		this.dx = this.dx + px;
		this.dex += px;
		this.update();
	}

	public void moveLeft(int px) {
		this.dx = this.dx - px;
		this.dex -= px;
		this.update();
	}

	public String getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(String spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public int getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}

	public String getRefrencePath() {
		return refrencePath;
	}

	public void setRefrencePath(String refrencePath) {
		this.refrencePath = refrencePath;
	}

	public RefrenceJson[] getLoadedsrc() {
		return loadedsrc;
	}

	public void setLoadedsrc(RefrenceJson[] loadedsrc) {
		this.loadedsrc = loadedsrc;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getDefaultTexture() {
		return defaultTexture;
	}

	public void setDefaultTexture(int defaultTexture) {
		this.defaultTexture = defaultTexture;
	}

	public int getEntryX() {
		return entryX;
	}

	public void setEntryX(int entryX) {
		this.entryX = entryX;
	}

	public int getEntryY() {
		return entryY;
	}

	public void setEntryY(int entryY) {
		this.entryY = entryY;
	}

	public EventMap geteMap() {
		return eMap;
	}

	public void seteMap(EventMap eMap) {
		this.eMap = eMap;
	}

	public int[][] getEventCoordinates() {
		return eventCoordinates;
	}

	public void setEventCoordinates(int[][] eventCoordinates) {
		this.eventCoordinates = eventCoordinates;
	}

	public int[][] getEnemies() {
		return enemies;
	}

	public void setEnemies(int[][] enemies) {
		this.enemies = enemies;
	}

	// cam getter and setter -> dx,dy
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getDcx() {
		return dcx;
	}

	public void setDcx(int dcx) {
		this.dcx = dcx;
	}

	public int getDcy() {
		return dcy;
	}

	public void setDcy(int dcy) {
		this.dcy = dcy;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getDey() {
		return dey;
	}

	public void setDey(int dey) {
		this.dey = dey;
	}

	
	
}
