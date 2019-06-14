package com.PLLEngine.Game;

import java.util.Timer;
import java.util.TimerTask;

public class GameLoop extends Thread {

	public static final int FPS = 60;
	public static final long maxLoopTime = 1000 / FPS;
	private int frames;
	private Timer t;
	private TimerTask task;
	
	private Game game;

	public boolean running = true;
	public GameLoop(Game game) {
		frames = 0;
		this.game = game;
		task = new TimerTask() {

			@Override
			public void run() {
				System.out.println(frames+" FPS");
				frames = 0;
			}
			
		};
		t = new Timer();
		t.scheduleAtFixedRate(task, 1000, 1000);
	}

	@Override
	public void run() {
		long timestamp;
		long oldTimestamp;
		while (running) {
			frames++;
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
	public int getFrames() {
		return this.frames;
	}
	
}
