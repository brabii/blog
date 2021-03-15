package com.brabii.dev.blog.metier;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CritereRecherche {
	private List<CriterePersistence> criteresPersistence = new LinkedList<>();

	public CritereRecherche() {
	}

	public boolean contains(String nom) {
		for (CriterePersistence critere : this.criteresPersistence) {
			if (critere.getNom().equals(nom)) {
				return true;
			}
		}
		return false;
	}

	public void addCritere(CriterePersistence criterePersistence) {
		CriterePersistence critere = foundCriterePersistence(criterePersistence.getNom());
		if (critere != null) {
			critere.setOperator(criterePersistence.getOperator());
			critere.setValeur(critere.getValeur());
		} else {
			this.criteresPersistence.add(criterePersistence);
		}
	}

	public void addCritere(String nom, Object valeur, EnumOperator operator) {
		CriterePersistence critere = new CriterePersistence(nom, valeur, operator);
		this.criteresPersistence.add(critere);

	}

	public CriterePersistence foundCriterePersistence(String nom) {
		for (CriterePersistence critere : criteresPersistence) {
			if (critere.getNom().equals(nom)) {
				return critere;
			}
		}
		return null;
	}

	public Map<String, Object> convertToMap() {
		Map<String, Object> mapCriteres = new HashMap<>();
		for (CriterePersistence critere : this.criteresPersistence) {
			mapCriteres.put(critere.getNom() + "," + critere.getOperator().getCodeInterne(), critere.getValeur());
		}
		return mapCriteres;
	}

	public static CritereRecherche createFromMap(Map<String, Object> mapCritereRecherche) {
		CritereRecherche critereRecherche = new CritereRecherche();
		for (Map.Entry<String, Object> critere : mapCritereRecherche.entrySet()) {
			String key = critere.getKey();
			if (key.contains(",")) {
				key = key.substring(0, key.indexOf(","));
			}
			critereRecherche.addCritere(key, critere.getValue(),
					CriterePersistence.extractOperatorFromString(critere.getKey()));
		}

		return critereRecherche;
	}
}
