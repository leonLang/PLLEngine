package com.PLLEngine.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.PLLEngine.Scene.layerComponents.LayerComponent;
import com.PLLEngine.Scene.layerComponents.entity.Entitiy;

public class Spritesheet extends LayerComponent {
	private BufferedImage br_grass, br_recolor, br;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100];
	private int[] drawNumbers = new int[1000];
	private int[] drawNumbersX = new int[1000];
	private int[] drawNumbersY = new int[1000];
	private int[] drawNumbersWidth = new int[1000];
	private int[] drawNumbersHeight = new int[1000];

	private int drawNumberZaehler = 0;
	private int x, y;

	public Spritesheet(int columnsX, int columnsY, String path) {
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
			brD[i] = brdefault(x, y, 50, 50);
			if (x == br.getWidth() / columnsX * (columnsX - 1)) {
				x = 0;
				y = y + br.getHeight() / columnsY;
			} else {
				x = x + br.getWidth() / columnsX;
			}

		}
	}

	private void columnsToDraw(Graphics g) {
		if (drawNumbers[0] == -1) {
		} else {
			for (int i = 0; i < drawNumberZaehler; i++) {
				g.drawImage(brD[drawNumbers[i]], drawNumbersX[i], drawNumbersY[i], drawNumbersWidth[i],
						drawNumbersHeight[i], null);
			}

		}
	}

	private BufferedImage brdefault(int x, int y, int width, int height) {
		return br.getSubimage(x, y, width, height);
	}

	public void setEntitiy(int entitiyNumber, int x, int y, int width, int height) {
		drawNumbers[drawNumberZaehler] = entitiyNumber;
		drawNumbersX[drawNumberZaehler] = x;
		drawNumbersY[drawNumberZaehler] = y;
		drawNumbersWidth[drawNumberZaehler] = width;
		drawNumbersHeight[drawNumberZaehler] = height;
		drawNumberZaehler++;
	}

	public int getEntitiyX(int entitiyNumber) {
		return drawNumbersX[entitiyNumber];
	}

	public int getEntitiyY(int entitiyNumber) {
		return drawNumbersY[entitiyNumber];
	}

	public int getEntitiyWidth(int entitiyNumber) {
		return drawNumbersWidth[entitiyNumber];
	}

	public int getEntitiyHeight(int entitiyNumber) {
		return drawNumbersHeight[entitiyNumber];
	}

	@Override
	public void draw(Graphics g, int dx, int dy) {
		columnsToDraw(g);
		g.drawRect(100, 100, 100, 100);

	}
}
