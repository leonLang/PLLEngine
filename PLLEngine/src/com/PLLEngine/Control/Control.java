package com.PLLEngine.Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.PLLEngine.Game.Game;

public class Control implements KeyListener {
	private Game game;

	public Control(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.game.KeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.game.KeyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.game.KeyTyped(e);

	}

}
