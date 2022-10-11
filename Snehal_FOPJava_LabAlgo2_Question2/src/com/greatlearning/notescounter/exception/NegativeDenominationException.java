package com.greatlearning.notescounter.exception;

public class NegativeDenominationException extends Exception {

	/**
	 * User Exception to handle Negative Denominations
	 */
	private static final long serialVersionUID = 2531749131745854431L;

	public NegativeDenominationException(String message) {
		super(message);

	}

}
