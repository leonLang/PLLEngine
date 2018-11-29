package com.PLLEngine.srcLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SrcLoader {
	public BufferedImage Image(String src) throws IOException {
		BufferedImage returnImage;
		returnImage = ImageIO.read(new File(src));
		return returnImage;
	}
}
