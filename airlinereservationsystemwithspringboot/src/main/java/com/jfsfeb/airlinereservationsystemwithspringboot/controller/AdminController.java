package com.jfsfeb.airlinereservationsystemwithspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemwithspringboot.beans.FlightResponseBean;
import com.jfsfeb.airlinereservationsystemwithspringboot.service.AdminServices;

@RestController
public class AdminController {
	
	@Autowired
	private AdminServices adminService;
	
	@PostMapping(path = "/addFlight",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public FlightResponseBean addFlights(@RequestBody FlightDetails flightDetails) {
		
		boolean isAdded = adminService.addFlights(flightDetails);
		FlightResponseBean flightResponse = new FlightResponseBean();
		if(isAdded) {
			flightResponse.setMessage("Flight added successfully");
		} else {
			flightResponse.setError(true);
			flightResponse.setMessage("Can't add the flight");
		}
		return flightResponse;
	}
	
	@GetMapping(path = "/searchFlight",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponseBean searchFlight(int id) {
		List<FlightDetails> flight = adminService.searchFlight(id);
		FlightResponseBean flightResponse = new FlightResponseBean();
		if(flight !=null && !flight.isEmpty()) {
			flightResponse.setMessage("FLight Details of "+id);
			flightResponse.setData(flight);
		}else {
			flightResponse.setError(true);
			flightResponse.setMessage("No flights avaliable");
		}
		return flightResponse;
	}
}
