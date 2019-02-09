package com.PLLEngine.Game;

import java.awt.event.KeyEvent;

public interface GameBase {

	public void setup();

	public void init();

	public void preinit();

	public void update();

	public void lateupdate();

	@Deprecated
	public void draw();

	public void close();

	public void KeyPressed(KeyEvent e);

	public void KeyReleased(KeyEvent e);

	public void KeyTyped(KeyEvent e);

}
