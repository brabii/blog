package com.brabii.dev.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.brabii.dev.blog.metier.EnumAction;

public class PaginationWithHeader extends AbstractPagination {

	private EnumAction action;
	private Map<String, Object> miscellaneous = new HashMap<>();
	private List<Header> headersDisponibles = new LinkedList<>();
	private List<Header> headers = new LinkedList<>();
	private List<EnumAction> actions = new ArrayList<>();

	public PaginationWithHeader() {
	}

	public PaginationWithHeader(int pageCourante, int maxEnregistrementsParPage, int totalEnregistrements,
			Map<String, Object> sortBy, Map<String, Object> recherche) {
		this.pageCourante = pageCourante;
		this.maxEnregistrementParPage = maxEnregistrementsParPage;
		this.nombreTotalEnregistrements = totalEnregistrements;
		this.sortBy = sortBy;
		this.recherche = recherche;
	}

	public void ajouterAction(EnumAction action) {
		if (!this.actions.contains(action)) {
			this.actions.add(action);
		}
	}
	
	public EnumAction getAction() {
		return action;
	}

	public void setAction(EnumAction action) {
		this.action = action;
	}

	public Map<String, Object> getMiscellaneous() {
		return miscellaneous;
	}

	public void setMiscellaneous(Map<String, Object> miscellaneous) {
		this.miscellaneous = miscellaneous;
	}

	public List<Header> getHeadersDisponibles() {
		return headersDisponibles;
	}

	public void setHeadersDisponibles(List<Header> headersDisponibles) {
		this.headersDisponibles = headersDisponibles;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public List<EnumAction> getActions() {
		return actions;
	}

	public void setActions(List<EnumAction> actions) {
		this.actions = actions;
	}

}
