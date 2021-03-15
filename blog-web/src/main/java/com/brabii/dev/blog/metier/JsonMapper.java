package com.brabii.dev.blog.metier;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper implements InterfaceJsonMapper {
	public JsonMapper() {
		System.out.println("===== json mapper chargé =======");
	}

	private ObjectMapper mapper; 

	@Override
	public HashMap<String, Object> convertStringToMap(String jsonString) throws IOException {
		return this.mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
		});
	}

	// TODO implémenter les autres méthodes selon le besoin
	@Override
	public List<Object> convertStringToList(List<Object> list) throws IOException {
		return null;
	}

	@Override
	public String convertListToString(List<Object> list) throws IOException {
		return null;
	}

	@Override
	public Map<String, Object> convertToMap(String json) throws IOException {
		return null;
	}

	@Override
	public String toString(Object object) throws JsonProcessingException {
		return null;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
}
