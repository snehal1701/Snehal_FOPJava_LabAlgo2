package com.greatlearning.notescounter.exception;

public class NegativeAmountException extends Exception {

	/**
	 * User Exception to handle Negative Amount
	 */
	private static final long serialVersionUID = 5696377048885845988L;

	public NegativeAmountException(String message) {
		super(message);

	}

}
