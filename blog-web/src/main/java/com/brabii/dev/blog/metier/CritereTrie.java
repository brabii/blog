package com.brabii.dev.blog.metier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CritereTrie {
	Map<String, EnumSort> mapTrie = new LinkedHashMap<>();

	public CritereTrie() {
	}

	public CritereTrie(String nom, EnumSort sort) {
		mapTrie.put(nom, sort);
	}

	public static CritereTrie createFromMap(Map<String, Object> mapCritereTrie) {
		List<String> keys = new ArrayList<>(mapCritereTrie.keySet());
		CritereTrie critereTrie = new CritereTrie();

		keys.forEach(key -> {
			EnumSort sorter;
			switch ((String) mapCritereTrie.get(key)) {
			case "asc":
				sorter = EnumSort.ASC;
				break;
			case "desc":
				sorter = EnumSort.DESC;
				break;
			default:
				throw new IllegalArgumentException("Le trie n'est pas renseigné correctement");
			}
			critereTrie.addToMapTrie(key, sorter);
		});

		return critereTrie;
	}

	public void addToMapTrie(String nom, EnumSort sort) {
		this.mapTrie.put(nom, sort);
	}

}
