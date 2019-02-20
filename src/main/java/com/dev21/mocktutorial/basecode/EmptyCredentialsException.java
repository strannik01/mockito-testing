package com.dev21.mocktutorial.basecode;

public class EmptyCredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8242105431215680613L;

	public EmptyCredentialsException() {
		super("Empty credentials!");
	}
}
