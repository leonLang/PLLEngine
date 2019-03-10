package test;

import java.io.IOException;

import com.PLLEngine.Game.Game;
import com.PLLEngine.srcLoader.JsonLoader;

public class ScriptEntry {

	public static void main(String[] args) throws IOException {
		Game game = JsonLoader.startGame();
		game.init();

	}

} 
