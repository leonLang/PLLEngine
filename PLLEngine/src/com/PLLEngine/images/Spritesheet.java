package com.PLLEngine.images;

import java.awt.image.BufferedImage;

import com.PLLEngine.srcLoader.SrcLoader;

/** Written by Leon. creates the images for our game **/
public class Spritesheet {
	private BufferedImage spritesheet;
	private int width, height;

	public Spritesheet(int width, int height, String path) {
		this.width = width;
		this.height = height;
		this.spritesheet = SrcLoader.Image(path);
	}

	/** this uses a small part of your spritesheet as a new image **/
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
