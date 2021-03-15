package com.brabii.dev.blog;

public class Header {
	private String nom;
	private String labelle;
	private String labelleCourt;
	private String description;
	private EnumType type;

//	private FilterType filterType;
	public Header(String nom) {
		this(nom, "", "", "", null);
	}

	public Header(String nom, String labelle, String labelleCourt, String description) {
		this(nom, labelle, labelleCourt, description, null);
	}

	public Header(String nom, String labelle, String labelleCourt, String description, EnumType type) {
		this.nom = nom;
		this.labelle = labelle;
		this.labelleCourt = labelleCourt;
		this.description = description;
		this.type = type;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public String getLabelleCourt() {
		return labelleCourt;
	}

	public void setLabelleCourt(String labelleCourt) {
		this.labelleCourt = labelleCourt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnumType getType() {
		return type;
	}

	public void setType(EnumType type) {
		this.type = type;
	}

}
