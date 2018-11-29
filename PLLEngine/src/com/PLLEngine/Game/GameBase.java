package com.PLLEngine.Game;

public interface GameBase {
	
	public void setup();

	public void init();

	public void preinit();

	public void update();

	public void lateupdate();
	
	@Deprecated
	public void draw();

	public void close();
	
}
