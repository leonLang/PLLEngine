package com.PLLEngine.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.PLLEngine.Scene.layerComponents.LayerComponent;
import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class Spritesheet {
	private BufferedImage br_grass, br_recolor, br;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100];
	private int[] drawNumbers = new int[1000];
	private int[] drawNumbersX = new int[1000];
	private int[] drawNumbersY = new int[1000];
	private int[] drawNumbersWidth = new int[1000];
	private int[] drawNumbersHeight = new int[1000];
	private int width,height;
	private int drawNumberZaehler = 0;
	private int x, y;

	public Spritesheet(int columnsX, int columnsY, String path) {
		this.width = 32;
		this.height = 32;
		drawNumbers[0] = -1; // to ensure that it is not the 0 column which is selected
		setImage(path);
		calculateColumns(columnsX, columnsY);

	}

	private void setImage(String path) {
		try {
			// returnImage = ImageIO.read(new File(src));
			// URL url = new URL(getCodeBase(), "examples/strawberry.jpg");
			// br = ImageIO.read(new File("_sprite_1.png"));
			br = ImageIO.read(getClass().getResourceAsStream(path));
			// br = ImageIO.read(getClass().getResourceAsStream("textures/br.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void calculateColumns(int columnsX, int columnsY) {
		for (int i = 0; i < columnsX * columnsY; i++) {
			brD[i] = getSprite(x, y);
			if (x == br.getWidth() / columnsX * (columnsX - 1)) {
				x = 0;
				y = y + br.getHeight() / columnsY;
			} else {
				x = x + br.getWidth() / columnsX;
			}

		}
	}


	public BufferedImage getSprite(int x, int y) {
		if(this.br.getWidth() < x*this.width) {
			System.err.println("x out of bounds");
			return null;
		}
		if(this.br.getHeight() < y*this.height)	{
			System.err.println("y out of bounds");
			return null;
		}
		return this.br.getSubimage(
				this.width *x,this.height+y, this.width, this.height);
	}
		//return br.getSubimage(x, y, width, height);
	}

	
