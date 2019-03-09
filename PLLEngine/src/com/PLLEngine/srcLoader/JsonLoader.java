package com.PLLEngine.srcLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.PLLEngine.Game.Game;
import com.PLLEngine.Game.SchriptGame;
import com.PLLEngine.Scene.Map.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoader {
	public static Map loadMap(String Path) throws JsonParseException, JsonMappingException, IOException {
		Map map;
		byte[] jsonData = Files.readAllBytes(Paths.get(Path));
		ObjectMapper objectMapper = new ObjectMapper();
		map = objectMapper.readValue(jsonData, Map.class);
		return map;
	}

	public static RefrenceJson[] loadRefrence(String Path)
			throws JsonParseException, JsonMappingException, IOException {
		RefrenceJson[] refrenceJson;
		byte[] jsonData = Files.readAllBytes(Paths.get(Path));
		ObjectMapper objectMapper = new ObjectMapper();
		refrenceJson = objectMapper.readValue(jsonData, RefrenceJson[].class);
		return refrenceJson;
	}
	public static SchriptGame startGame() throws IOException {
		SchriptGame game;
		String path = "src_data/entry.json";
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
		ObjectMapper objectMapper = new ObjectMapper();
		game = objectMapper.readValue(jsonData, SchriptGame.class);
		return game;
	}
}