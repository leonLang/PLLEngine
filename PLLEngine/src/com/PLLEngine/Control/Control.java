package com.PLLEngine.Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.PLLEngine.Scene.Player;

public class Control implements KeyListener {
	private Player player;

	public Control(Player game) {
		this.player = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.player.KeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.player.KeyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.player.KeyTyped(e);

	}

}
