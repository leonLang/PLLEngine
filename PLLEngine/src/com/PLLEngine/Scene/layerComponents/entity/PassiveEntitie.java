package com.PLLEngine.Scene.layerComponents.entity;

//Leon
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
		g.drawRect(this.startXP + Entitie.getDxAll(), this.startYP + Entitie.getDyAll(), this.width, this.height);
		g.drawString(this.dialog, this.startXD + Entitie.getDxAll(), this.startYD + Entitie.getDyAll());
	}
}
