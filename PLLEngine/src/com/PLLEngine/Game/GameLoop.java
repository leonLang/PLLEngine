package com.PLLEngine.Game;

public class GameLoop extends Thread {

	public static final int FPS = 60;
	public static final long maxLoopTime = 1000 / FPS;
	
	private Game game;

	public boolean running = true;
	public GameLoop(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		long timestamp;
		long oldTimestamp;
		while (running) {
			oldTimestamp = System.currentTimeMillis();
			game.update();
			timestamp = System.currentTimeMillis();
			if (timestamp - oldTimestamp > maxLoopTime) {
				System.out.println("update to late");
				continue;
			}
			game.draw();
			timestamp = System.currentTimeMillis();
			if (timestamp - oldTimestamp <= maxLoopTime) {
				try {
					Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
