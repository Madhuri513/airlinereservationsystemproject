package com.jfsfeb.airlinereservationsystemwithspringboot.exception;

public class AirlineSystemException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AirlineSystemException(String message) {
		super(message);
	}

}
