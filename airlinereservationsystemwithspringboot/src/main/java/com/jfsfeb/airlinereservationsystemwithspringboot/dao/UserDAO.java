package com.jfsfeb.airlinereservationsystemwithspringboot.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.TicketsInfo;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.UserDetails;

public interface UserDAO {
	
	public boolean userRegistration(UserDetails user);
	
	public UserDetails userLogin(String emailId,String password);
	
	public List<FlightDetails> getFlightDetails();
	
	public List<FlightDetails> searchFlightByName(String name);
	
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination);
	
	public TicketsInfo bookFligthTicket(TicketsInfo ticket);
	
	public boolean cancelFlightTicket(int bookingId);
	
	public List<TicketsInfo> getTicketDetails(int userId);

}
