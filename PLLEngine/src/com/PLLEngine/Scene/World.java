package com.PLLEngine.Scene;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.PLLEngine.Scene.Map.EventMap;
import com.PLLEngine.srcLoader.JsonLoader;
import com.PLLEngine.srcLoader.RefrenceJson;
import com.PLLEngine.srcLoader.SrcLoader;

@SuppressWarnings("serial")
public class World extends JPanel implements SceneComponentInterface{
	private String refrencePath;
	private RefrenceJson[] loadedsrc;
	private int[][] map;
	private int[][] eventCoordinates;
	private int entryX, entryY;
	private EventMap eMap;
	private int spriteSize;
	private int cellCountX, cellCountY;
	private int dx, dy;
	private int dcx, dcy;

	public void loadMap() {
		// World is getting rendern as big as the screen is
		// this methode is impoveable
		Dimension screenSize = SwingUtilities.getWindowAncestor(this.getParent()).getSize();
		cellCountX = (int) (screenSize.getWidth() / spriteSize + 1);
		cellCountY = (int) (screenSize.getHeight() / spriteSize + 1);
		this.dx = 0;
		this.dy = 0;
		this.dcx = 0;
		this.dcy = 0;
		// Load all images for the refrecnes
		new Thread(() -> {
			try {
				loadedsrc = JsonLoader.loadRefrence(refrencePath);
				for (int i = 0; i < loadedsrc.length; i++) {
					loadedsrc[i].setImg(SrcLoader.Image(loadedsrc[i].getPath()));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error while loading map.map");
			}
			try {
				loadEvents();

			} catch (Exception e) {
				System.err.println("Error while loading map.Event's");
			}

		}).start();
	}

	public void draw(Graphics2D g) {
		for (int x = -1; x < cellCountX; x++) {
			for (int y = -1; y < cellCountY; y++) {
				try {
					/*
					 * NOTE: do NOT mess with the numbers, wierd stuff will happen....
					 */
					g.drawImage(loadedsrc[map[y + dcy][x + dcx]].getImg(), x * spriteSize + dx, y * spriteSize + dy,
							spriteSize, spriteSize, null);
					//g.drawRect(x * spriteSize + dx, y * spriteSize + dy, spriteSize, spriteSize);
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
	}

	public void moveUp(int px) {
		this.dy = this.dy + px;
		this.update();

	}

	public void moveDown(int px) {
		this.dy = this.dy - px;
		this.update();
	}

	public void moveRight(int px) {
		this.dx = this.dx + px;
		this.update();
	}

	public void moveLeft(int px) {
		this.dx = this.dx - px;
		this.update();
	}

	public int getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}

	public void loadEvents() {
		this.eMap = new EventMap(eventCoordinates);
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

}
