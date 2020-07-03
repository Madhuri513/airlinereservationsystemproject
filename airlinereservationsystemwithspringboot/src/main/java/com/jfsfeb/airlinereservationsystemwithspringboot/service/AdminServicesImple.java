package com.jfsfeb.airlinereservationsystemwithspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.TicketsInfo;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.UserDetails;
import com.jfsfeb.airlinereservationsystemwithspringboot.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemwithspringboot.validation.AirlineValidations;

@Service
public class AdminServicesImple implements AdminServices {

	@Autowired
	AdminDAO adminImple;
	
	@Autowired
	AirlineValidations validation;

	@Override
	public boolean adminLogin(String emailId, String password) {
		if (validation.validateEmail(emailId)) {
			if (validation.validatePassword(password)) {
				return adminImple.adminLogin(emailId, password);
			}
		}
		return false;
	}

	@Override
	public boolean addFlights(FlightDetails flights) {
		if (validation.validateId(flights.getFlightId())) {
			if (validation.validateName(flights.getFlightName())) {
				if (validation.validateName(flights.getSource())) {
					if (validation.validateName(flights.getDestination())) {
						if (validation.validatePrice(flights.getPrice())) {
							return adminImple.addFlights(flights);
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public boolean deleteFlights(int id) {
		if (validation.validateId(id)) {
			return adminImple.deleteFlights(id);
		}
		return false;
	}

	@Override
	public List<FlightDetails> searchFlight(int id) {
		if (validation.validateId(id)) {
			return adminImple.searchFlight(id);
		}
		return null;
	}

	@Override
	public List<FlightDetails> viewFlightDetails() {
		return adminImple.viewFlightDetails();
	}

	@Override
	public List<UserDetails> viewAllUserDetails() {
		return adminImple.viewAllUserDetails();
	}

	@Override
	public List<TicketsInfo> viewTicketsInfos() {
		return adminImple.viewTicketsInfos();
	}
}