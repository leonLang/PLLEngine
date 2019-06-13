package com.PLLEngine.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.PLLEngine.srcLoader.SrcLoader;

public class SpritesheetP {
	private BufferedImage spritesheet;
	private int width, height;

	public SpritesheetP(int width, int height, String path) {
		this.width = width;
		this.height = height;
		setImage(path);
	}

	public SpritesheetP(int width, int height) {
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
