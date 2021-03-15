package com.brabii.dev.blog.metier;

import java.util.Objects;

/**
 * ceci est une enum qui prend pour valeurs les opérateurs d'une requete sql
 * 
 * @author rabii
 *
 */
public enum EnumOperator {
	/**
	 * {@literal} ==}
	 */
	EQ(0),
	/**
	 * {@literal} !=}
	 */
	NE(1),
	/**
	 * {@literal} >}
	 */
	GT(2),
	/**
	 * {@literal} <}
	 */
	LT(3),
	/**
	 * {@literal} >=}
	 */
	GE(4),
	/**
	 * {@literal} <=}
	 */
	LE(5),
	/**
	 * {@literal}
	 */
	IN(6), EQ_IGNORE_CASE(7), NOT_NULL(8), NULL(9), BETWEEN(10), LIKE(11);

	private Integer codeInterne;

	private EnumOperator(Integer codeInterne) {
		this.codeInterne = codeInterne;
	}

	public static EnumOperator createFromInteger(Integer codeInterne) {
		if (codeInterne != null) {
			for (EnumOperator operator : EnumOperator.values()) {
				if (Objects.equals(codeInterne, operator.codeInterne)) {
					return operator;
				}
			}
		}
		return null;
	}

	public Integer getCodeInterne() {
		return codeInterne;
	}
}
