package com.brabii.dev.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.brabii.dev.blog.metier.EnumSort;

public class AbstractPagination {
	protected EnumSort sort;
	protected int pageCourante = 1;
	protected int nombreTotalEnregistrements = 0;
	protected int maxEnregistrementParPage = 10;
	protected Map<String, Object> sortBy;
	protected Map<String, Object> recherche;
	protected List<Map<String, Object>> resultats = new ArrayList<>();
	protected List<Object> resultatsBean = new ArrayList<>();

	public AbstractPagination() {
	}

	public AbstractPagination(EnumSort sort, int pageCourante, int nombreTotalEnregistrements,
			int maxEnregistrementParPage, Map<String, Object> sortBy, Map<String, Object> recherche,
			List<Map<String, Object>> resultats, List<Object> resultatsBean) {
		this.pageCourante = pageCourante;
		this.maxEnregistrementParPage = maxEnregistrementParPage;
		this.nombreTotalEnregistrements = nombreTotalEnregistrements;
		this.sortBy = sortBy;
		this.recherche = recherche;
	}

	public static String filterSortBy(String sortByEtDirection) {
		String resultat = null;
		if (sortByEtDirection == null) {
			return "";
		}
		try {
			int position = sortByEtDirection.indexOf(",");
			resultat = sortByEtDirection.substring(0, position);
		} catch (IndexOutOfBoundsException iooeb) {
			resultat = "";
		}
		return resultat;
	}

	public void ajouterResultat(Map<String, Object> map) {
		this.getResultats().add(map);
		this.nombreTotalEnregistrements++;
	}

	public static EnumSort getDirection(String sortByEtDirection) {
		if (sortByEtDirection == null || sortByEtDirection == "") {
			return null;
		}
		if (sortByEtDirection.toLowerCase().endsWith(",asc")) {
			return EnumSort.ASC;
		} else {

			return EnumSort.DESC;
		}
	}

	public EnumSort getSort() {
		return sort;
	}

	public void setSort(EnumSort sort) {
		this.sort = sort;
	}

	public int getPageCourante() {
		return pageCourante;
	}

	public void setPageCourante(int pageCourante) {
		this.pageCourante = pageCourante;
	}

	public int getNombreTotalEnregistrements() {
		return nombreTotalEnregistrements;
	}

	public void setNombreTotalEnregistrements(int nombreTotalEnregistrements) {
		this.nombreTotalEnregistrements = nombreTotalEnregistrements;
	}

	public int getMaxEnregistrementParPage() {
		return maxEnregistrementParPage;
	}

	public void setMaxEnregistrementParPage(int maxEnregistrementParPage) {
		this.maxEnregistrementParPage = maxEnregistrementParPage;
	}

	public Map<String, Object> getSortBy() {
		return sortBy;
	}

	public void setSortBy(Map<String, Object> sortBy) {
		this.sortBy = sortBy;
	}

	public Map<String, Object> getRecherche() {
		return recherche;
	}

	public void setRecherche(Map<String, Object> recherche) {
		this.recherche = recherche;
	}

	public List<Map<String, Object>> getResultats() {
		return resultats;
	}

	public void setResultats(List<Map<String, Object>> resultats) {
		this.resultats = resultats;
	}

	public List<Object> getResultatsBean() {
		return resultatsBean;
	}

	public void setResultatsBean(List<Object> resultatsBean) {
		this.resultatsBean = resultatsBean;
	}
}
/**










****
*/