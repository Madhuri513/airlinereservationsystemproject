package com.jfsfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.TicketsInfo;
import com.jfsfeb.airlinereservationsystem.dto.UserDetails;
import com.jfsfeb.airlinereservationsystem.repository.AirlineSystemRepository;
import com.jfsfeb.airlineresevationsystem.exceptions.AirlineSystemException;

public class UserDAOImple implements UserDAO {

	@Override
	public boolean userRegistration(UserDetails user) {
		for (UserDetails users : AirlineSystemRepository.user) {
			if (users.getMailId().equals(user.getMailId())) {
				throw new AirlineSystemException("This mail id already registered please enter another emailid");
			}
		}
		AirlineSystemRepository.user.add(user);
		return true;
	}

	@Override
	public UserDetails userLogin(String emailId, String password) {
		for (UserDetails details : AirlineSystemRepository.user) {
			if ((details.getMailId().equals(emailId)) && (details.getPassword().equals(password))) {
				return details;
			}else {
				throw new AirlineSystemException("Enter correct mailid and password");							
			}
		}
		throw new AirlineSystemException("Enter correct mailid and password");							
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		List<FlightDetails> flights = new ArrayList<FlightDetails>();
		for (FlightDetails details : AirlineSystemRepository.flight) {
			details.getFlightId();
			details.getFlightName();
			details.getNoOfSeats();
			details.getArrivalTime();
			details.getDepartureTime();
			details.getSource();
			details.getDestination();

			flights.add(details);
		}

		return flights;
	}

	@Override
	public List<FlightDetails> searchFlightByName(String name) {
		List<FlightDetails> flights = new ArrayList<FlightDetails>();
		for (FlightDetails details : AirlineSystemRepository.flight) {
			if (details.getFlightName().equals(name)) {
				flights.add(details);
			}
		}
		if (flights.size() == 0) {
			throw new AirlineSystemException("Flight not found");
		}

		return flights;
	}

	@Override
	public TicketsInfo bookFligthTicket(int bookingId, UserDetails userInfo, FlightDetails flightInfo, int seats) {

		TicketsInfo ticket = new TicketsInfo();
		UserDetails user = new UserDetails();
		FlightDetails flight = new FlightDetails();

		for (FlightDetails flights : AirlineSystemRepository.flight) {
			for (UserDetails users : AirlineSystemRepository.user) {
				if ((flights.getFlightId() == (flightInfo.getFlightId()))
						&& (userInfo.getUserId() == users.getUserId())) {
					user = users;
					flight = flights;
					ticket.setTicketId(bookingId);
					ticket.setFlightDetails(flight);
					ticket.setUserDetails(user);
					ticket.setNoOfSeatsBooked(seats);
					AirlineSystemRepository.tickets.add(ticket);
					return ticket;
				}
			}
		}

		throw new AirlineSystemException("Invalid request");

	}

	@Override
	public boolean cancelFlightTicket(int bookingId) {

		for (TicketsInfo beans : AirlineSystemRepository.tickets) {

			if (beans.getTicketId() == bookingId) {
				AirlineSystemRepository.tickets.remove(beans);
				return true;
			}
		}
		throw new AirlineSystemException("Enter correct booking id");
	}

	@Override
	public List<TicketsInfo> getTicketDetails(int userId) {
		List<TicketsInfo> tickets = new ArrayList<TicketsInfo>();
		for (TicketsInfo details : AirlineSystemRepository.tickets) {

			details.getTicketId();
			details.getUserDetails();
			details.getFlightDetails();

			if (details.getUserDetails().getUserId() == userId) {
				tickets.add(details);
			}
		}
		if (tickets.size() > 0) {
			return tickets;
		}
		throw new AirlineSystemException("No tickets with this userid...........");
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		List<FlightDetails> flights = new ArrayList<FlightDetails>();
		for (FlightDetails details : AirlineSystemRepository.flight) {
			if (details.getSource().equalsIgnoreCase(source) && details.getDestination().equalsIgnoreCase(destination)) {
				flights.add(details);
			}
		}
		if (flights.size() == 0) {
			throw new AirlineSystemException("Flight not found");
		}
		return flights;
	}

}
