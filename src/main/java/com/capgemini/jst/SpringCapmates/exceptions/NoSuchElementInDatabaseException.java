package com.capgemini.jst.SpringCapmates.exceptions;

public class NoSuchElementInDatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451157878502807176L;
	/**
	 * @return 
	 * 
	 */
	public NoSuchElementInDatabaseException(){
		super("Requested element was not found in database");
	}

}
