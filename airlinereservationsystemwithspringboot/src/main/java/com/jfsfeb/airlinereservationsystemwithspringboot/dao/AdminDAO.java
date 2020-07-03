package com.jfsfeb.airlinereservationsystemwithspringboot.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.TicketsInfo;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.UserDetails;

public interface AdminDAO {
		
	public boolean adminLogin(String emailId,String password);
	
	public boolean addFlights(FlightDetails flights);
	
	public boolean deleteFlights(int id);
	
	public List<FlightDetails> searchFlight(int id);
	
	public List<FlightDetails> viewFlightDetails();
	
	public List<UserDetails> viewAllUserDetails();
	
	public List<TicketsInfo> viewTicketsInfos();

}
