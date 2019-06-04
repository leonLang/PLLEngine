package com.PLLEngine.srcLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SrcLoader {
	/**
	 * if file is not found replaced by backup texture
	 * 
	 * @param src
	 * @return BufferedImage
	 */
	public static BufferedImage Image(String src) {
		try {
		BufferedImage returnImage;
		returnImage = ImageIO.read(new File(src));
		return returnImage;
		} catch (IOException e){
			try {
				BufferedImage returnImage;
				returnImage = ImageIO.read(new File("empty.png"));
				return returnImage;
			} catch(IOException ex) {
				System.err.println("Fatal error while loading backup sprite\n check file system ");
				return null;
			}
		}
	}
}
