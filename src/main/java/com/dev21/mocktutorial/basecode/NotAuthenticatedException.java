package com.dev21.mocktutorial.basecode;

public class NotAuthenticatedException extends Exception {

	public NotAuthenticatedException() {
		super("Could not authenticate!");
	}
}
