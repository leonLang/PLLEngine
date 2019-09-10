package com.PLLEngine.images;

//Leon
import java.awt.image.BufferedImage;

import com.PLLEngine.srcLoader.SrcLoader;

public class Spritesheet {
	private BufferedImage spritesheet;
	private int width, height;

	public Spritesheet(int width, int height, String path) {
		this.width = width;
		this.height = height;
		this.setImage(path);
	}

	public Spritesheet(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// copy
	private void setImage(String path) {
		this.spritesheet = SrcLoader.Image(path);
	}

	public BufferedImage getSprite(int x, int y) {
		if (this.spritesheet.getWidth() < x * this.width) {
			System.err.println("x out of bounds");
			return null;
		}
		if (this.spritesheet.getHeight() < y * this.height) {
			System.err.println("y out of bounds");
			return null;
		}
		return this.spritesheet.getSubimage(this.width * x, this.height * y, this.width, this.height);
	}
}
