package com.capgemini.jst.SpringCapmates.exceptions;

public class NoSuchGameInCollectionException extends Exception {
	private static final long serialVersionUID = 3310256122327196017L;

	public NoSuchGameInCollectionException() {
		super("There is No Such Game In Collection");
}
}
