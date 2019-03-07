package com.PLLEngine.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpritesheetP {
	private BufferedImage spritesheet;
	private int width,height;
	public SpritesheetP(String path) {
		this.width = 32;
		this.height = 32;
		setImage(path);
	}
	//copy
	private void setImage(String path) {
		try {
			this.spritesheet = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x,int y) {
		if(this.spritesheet.getWidth() < x*this.width) {
			System.err.println("x out of bounds");
			return null;
		}
		if(this.spritesheet.getHeight() < y*this.height)	{
			System.err.println("y out of bounds");
			return null;
		}
		return this.spritesheet.getSubimage(
				this.width *x,this.height+y, this.width, this.height);
	}
}
