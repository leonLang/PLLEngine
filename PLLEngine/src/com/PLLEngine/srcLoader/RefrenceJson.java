//peter
package com.PLLEngine.srcLoader;

import java.awt.image.BufferedImage;

public class RefrenceJson {
	private String path;
	private int id;
	private boolean collision;
	private BufferedImage img;
	private int spriteX;
	private int spriteY;
	private int[] connector;
	private String _note;
	
	
	public int getSpriteX() {
		return spriteX;
	}

	public void setSpriteX(int spriteX) {
		this.spriteX = spriteX;
	}

	public int getSpriteY() {
		return spriteY;
	}

	public void setSpriteY(int spriteY) {
		this.spriteY = spriteY;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getConnector() {
		return connector;
	}

	public void setConnector(int[] connector) {
		this.connector = connector;
	}

	public String get_note() {
		return _note;
	}

	public void set_note(String _note) {
		this._note = _note;
	}
	

}
