package com.PLLEngine.srcLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Scene.GUI;
import com.PLLEngine.Scene.Layer;
import com.PLLEngine.Scene.Player;
import com.PLLEngine.Scene.Scene;
import com.PLLEngine.Scene.World;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoader {

	public static RefrenceJson[] loadRefrence(String refrecePath)
			throws JsonParseException, JsonMappingException, IOException {
		RefrenceJson[] refrenceJson;
		String path = "src_data/refrence/" + refrecePath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		refrenceJson = objectMapper.readValue(jsonData, RefrenceJson[].class);
		return refrenceJson;
	}

	public static Game startGame() throws IOException {
		Game game;
		String path = "src_data/entry.json";
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		game = objectMapper.readValue(jsonData, Game.class);
		return game;
	}

	public static World loadWorld(String WorldPath) throws JsonParseException, JsonMappingException, IOException {
		World world;
		String path = "src_data/worlds/" + WorldPath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		world = objectMapper.readValue(jsonData, World.class);
		return world;
	}

	public static Scene SceneLoader(String ScenePath) throws IOException {
		Scene scene;
		String path = "src_data/scenes/" + ScenePath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		scene = objectMapper.readValue(jsonData, Scene.class);
		return scene;
	}

	public static Layer LayerLoader(String layerPath) throws IOException {
		Layer layer;
		String path = "src_data/layer/" + layerPath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		layer = objectMapper.readValue(jsonData, Layer.class);
		return layer;
	}

	public static GUI InterfaceLoader(String GUIPath) throws IOException {
		GUI gui;
		String path = "src_data/interfaces/" + GUIPath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		gui = objectMapper.readValue(jsonData, GUI.class);
		return gui;
	}

	public static Player playerLoader(String playerPath) throws IOException {
		Player player;
		String path = "src_data/player/" + playerPath;
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		player = objectMapper.readValue(jsonData, Player.class);
		return player;
	}
}