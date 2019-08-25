package com.PLLEngine.Scene.layerComponents.entity;

import java.awt.Graphics2D;

public class PassiveEntitie extends Entitie {
	int startXP, startYP; // Passive Entitie X and Y
	int startXD, startYD; // Dialog X and Y
	int width, height;
	String dialog;

	public PassiveEntitie(int startXP, int startYP, int width, int height, int startXD, int startYD, String dialog) {
		this.startXP = startXP;
		this.startYP = startYP;
		this.startXD = startXD;
		this.startYD = startYD;
		this.dialog = dialog;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawRect(startXP + Entitie.dxAll, startYP + Entitie.dyAll, width, height);
		g.drawString(dialog, startXD + Entitie.dxAll, startYD + Entitie.dyAll);
	}
}
