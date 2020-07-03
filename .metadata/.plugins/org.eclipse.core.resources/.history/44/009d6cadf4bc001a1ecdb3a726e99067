package com.jfsfeb.airlinereservationsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.airlinereservationsystem.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystem.dto.TicketsInfo;
import com.jfsfeb.airlinereservationsystem.dto.UserDetails;
import com.jfsfeb.airlinereservationsystem.factory.UserFactory;
import com.jfsfeb.airlinereservationsystem.services.UserServices;
import com.jfsfeb.airlineresevationsystem.exceptions.AirlineSystemException;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserController {

	public static final Scanner scan = new Scanner(System.in);

	public static final LoginController control = new LoginController();
	public static final UserDetails userInfo = new UserDetails();
	public static final FlightDetails flightInfo = new FlightDetails();
	public static final TicketsInfo ticketInfo = new TicketsInfo();
	public static final UserServices userServices = UserFactory.getUserServicesImpleInstance();

	public static void userController() {

		int choice = 0;
		do {

			try {
				log.info("Which operations you want to perform?????");
				log.info("***************************");
				log.info("1.Book Flight ticket");
				log.info("2.Cancel flight ticket");
				log.info("3.Get all tickets details");
				log.info("4.Logout");

				choice = scan.nextInt();

				switch (choice) {

				case 1:
					log.info("Book flight ticket : ");
					int bookingId = (int) (Math.random() * 10000);
					if (bookingId <= 1000) {
						bookingId = bookingId + 1000;
					}
					ticketInfo.setTicketId(bookingId);
					log.info("Your booking id: " + bookingId);
					log.info("Enter flight Id :");
					int flightId = scan.nextInt();
					flightInfo.setFlightId(flightId);

					log.info("Enter user Id : ");
					int userId = scan.nextInt();
					userInfo.setUserId(userId);

					log.info("Enter Number of seats : ");
					int seats = scan.nextInt();
					ticketInfo.setNoOfSeatsBooked(seats);

					try {
						TicketsInfo request = userServices.bookFligthTicket(bookingId, userInfo, flightInfo, seats);
						if (request != null) {
							log.info("Booking is Successful!!!!");
							log.info("Your Booking Details are : ");
							log.info(request.getTicketId());
							log.info(request.getUserDetails().getUserId());
							log.info(request.getFlightDetails().getFlightName());
							log.info(request.getNoOfSeatsBooked());
						}
					} catch (AirlineSystemException e) {
						log.error(e.getMessage());
					}
					break;

				case 2:
					log.info("Enter your booking id to cancel the ticket : ");
					int ticketId = scan.nextInt();
					try {
						boolean deleted = userServices.cancelFlightTicket(ticketId);
						if (deleted) {
							log.info("Cancelled your flight ticket successfully!!!!!!");
						}
					} catch (AirlineSystemException e) {
						log.error(e.getMessage());
					}
					break;

				case 3:
					log.info("Enter your userId : ");
					int userId2 = scan.nextInt();
					log.info("Your ticket details are : ");
					try {
						List<TicketsInfo> tickets = userServices.getTicketDetails(userId2);
						for (TicketsInfo details : tickets) {
							log.info(details);
						}
						break;
					} catch (AirlineSystemException e) {
						log.error(e.getMessage());
					}
					break;

				case 4:
					log.info("Logged out successfully!!!!!!!!!!!");
					LoginController.loginController();
					break;

				default:
					log.info("Invalid choice , please select values from 1 to 7 only");
					break;
				}
			} catch (InputMismatchException e) {
				log.error("Invalid Choice, choice must be in numbers only from 1- 7");
				scan.nextLine();
			} catch (AirlineSystemException e) {
				log.error(e.getMessage());
			}
		} while (true);
	}
}
