package com.brabii.dev.blog.metier;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface InterfaceJsonMapper {

	HashMap<String, Object> convertStringToMap(String jsonString) throws IOException;

	List<Object> convertStringToList(List<Object> list) throws IOException;

	String convertListToString(List<Object> list) throws IOException;

	Map<String, Object> convertToMap(String json) throws IOException;

	String toString(Object object) throws JsonProcessingException;
}
