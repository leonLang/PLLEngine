package test;

import java.io.IOException;

import com.PLLEngine.Game.SchriptGame;
import com.PLLEngine.srcLoader.JsonLoader;

public class Game {

	public static void main(String[] args) throws IOException {
		SchriptGame game = JsonLoader.startGame();
		game.init();

	}

}
