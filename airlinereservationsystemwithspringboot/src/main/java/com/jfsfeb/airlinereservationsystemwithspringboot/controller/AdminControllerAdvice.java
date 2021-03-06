package com.jfsfeb.airlinereservationsystemwithspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightResponseBean;
import com.jfsfeb.airlinereservationsystemwithspringboot.exception.AirlineSystemException;

@RestControllerAdvice
public class AdminControllerAdvice {
	@ExceptionHandler(AirlineSystemException.class)
	public FlightResponseBean handleAirlineException(AirlineSystemException exception) {
		FlightResponseBean response = new FlightResponseBean();
		response.setError(true);
		response.setMessage(response.getMessage());
		
		return response;
	}

	@ExceptionHandler(Exception.class)
	public FlightResponseBean handleException(Exception e) {
		FlightResponseBean response = new FlightResponseBean();
		response.setError(true);
		response.setMessage(e.getMessage());
		
		return response;
	}
}
