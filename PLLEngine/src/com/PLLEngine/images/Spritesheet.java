package com.PLLEngine.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.PLLEngine.Scene.layerComponents.LayerComponent;
import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class Spritesheet extends Entitiy{
	private  BufferedImage br_grass, br_recolor, br;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100];
	private int x, y;
	public Spritesheet() {
		try {
			//br_grass = ImageIO.read(getClass().getResourceAsStream("textures/br_grass.png"));
			// br_grass1 =
			// ImageIO.read(getClass().getResourceAsStream("textures/br_grass1.png"));
			//br_recolor = ImageIO.read(getClass().getResourceAsStream("textures/br_recolor.png"));
			br = ImageIO.read(getClass().getResourceAsStream("textures/br.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			brD[i] = brdefault(x, y, 50, 50);
			//brG[i] = grass(x, y, 50, 50);
			//brR[i] = recolor(x, y, 50, 50);
			if (x == 200) {
				x = 0;
				y = y + 50;
			} else {
				x = x + 50;
			}

		}
	}
	private BufferedImage grass(int x, int y, int width, int height) {
		return br_grass.getSubimage(x, y, width, height);
	}

	private BufferedImage recolor(int x, int y, int width, int height) {
		return br_recolor.getSubimage(x, y, width, height);
	}

	private BufferedImage brdefault(int x, int y, int width, int height) {
		return br.getSubimage(x, y, width, height);
}
	@Override
	public void draw(Graphics g, int dx, int dy) {
		g.drawImage(brD[5], 100, 100, 100, 100, null);
		g.drawRect(100, 100, 100, 100);
		
	}
}
