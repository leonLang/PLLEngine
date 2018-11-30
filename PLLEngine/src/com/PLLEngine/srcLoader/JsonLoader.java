package com.PLLEngine.srcLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.PLLEngine.Scene.Map.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoader {
	public Map loadMap() throws JsonParseException, JsonMappingException, IOException {
		Map map;
		byte[] jsonData = Files.readAllBytes(Paths.get(""));
		ObjectMapper objectMapper = new ObjectMapper();
		map = objectMapper.readValue(jsonData, Map.class);
		return map;
	}
}
