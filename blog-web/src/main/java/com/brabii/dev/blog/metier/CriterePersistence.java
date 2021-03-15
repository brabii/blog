package com.brabii.dev.blog.metier;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CriterePersistence {
	private String nom;
	private Object valeur;
	private EnumOperator operator = EnumOperator.LIKE;

	public CriterePersistence() {
	}

	public CriterePersistence(String nom, Object valeur, EnumOperator operator) {
		this.nom = nom;
		this.valeur = valeur;
		this.operator = operator;
	}

	private Criterion between(String mapper, Collection list) {
		if (list.size() != 2) {
			throw new IllegalArgumentException("L'operateur between doit prendre deux parametres!");
		}
		Iterator iterator = list.iterator();
		Object minimum = iterator.next();
		Object maxmimum = iterator.next();
		return Restrictions.between(mapper, minimum, maxmimum);
	}

	private Criterion like(String mapper) {
		if (this.valeur instanceof Boolean || this.valeur instanceof Enum) {
			return Restrictions.eq(mapper, this.valeur);
		}
		return Restrictions.ilike(mapper, "%" + this.valeur + "%");
	}

	public DetachedCriteria addDetachedCriteriaRestrictions(DetachedCriteria detachedCriteria, String mapper) {

		switch (operator) {
		case EQ:
			detachedCriteria.add(Restrictions.eq(mapper, valeur));
			break;
		case EQ_IGNORE_CASE:
			detachedCriteria.add(Restrictions.eq(mapper, valeur).ignoreCase());
			break;
		case NE:
			detachedCriteria.add(Restrictions.ne(mapper, valeur));
			break;
		case LIKE:
			detachedCriteria.add(like(mapper));
			break;
		case IN:
			detachedCriteria.add(Restrictions.in(mapper, (Collection) valeur));
			break;
		case NULL:
			detachedCriteria.add(Restrictions.isNull(mapper));
			break;
		case NOT_NULL:
			detachedCriteria.add(Restrictions.isNotNull(mapper));
			break;
		case GE:
			detachedCriteria.add(Restrictions.ge(mapper, valeur));
			break;
		case GT:
			detachedCriteria.add(Restrictions.gt(mapper, valeur));
			break;
		case LE:
			detachedCriteria.add(Restrictions.le(mapper, valeur));
			break;
		case LT:
			detachedCriteria.add(Restrictions.lt(mapper, valeur));
			break;
		case BETWEEN:
			detachedCriteria.add(between(mapper, (Collection) valeur));
			break;
		}
		return detachedCriteria;
	}

	public static EnumOperator extractOperatorFromString(String critere) {
		Pattern pattern = Pattern.compile("^(.*),([0-9]{1,})$"); // TODO a voir c'est qu'il fait le pattern
		Matcher matcher = pattern.matcher(critere);// TODO a voir c'est qu'il fait le matcher
		if (matcher.find()) {
			return EnumOperator.createFromInteger(Integer.valueOf(matcher.group(2)));
		}
		return EnumOperator.LIKE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Object getValeur() {
		return valeur;
	}

	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}

	public EnumOperator getOperator() {
		return operator;
	}

	public void setOperator(EnumOperator operator) {
		this.operator = operator;
	}

}
