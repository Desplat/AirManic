package main;

import java.util.Date;

import airmanic.Booking;
import airmanic.Flight;
import airmanic.Plane;
import dao.BookingDAO;
import dao.FlightDAO;

public class Main {

	static boolean ui = true;

	public static void main(String[] args) {
		
		Flight flight = new Flight("0001", Plane.A380, 250, "Paris", "Bordeaux", new Date());
		Booking booking = new Booking("Dupond", "Théo", 27, flight);
		
		FlightDAO flightDAO = new FlightDAO();
		BookingDAO bookingDAO = new BookingDAO();
		flightDAO.create(flight);
		bookingDAO.create(booking);
		booking.setNumReservation();
		bookingDAO.update(booking);
		
		while (ui) {
			
			Ui.mainMenu();
		}
		
		System.out.println("\nA bientôt sur Air Manic !");
	}
	
	public static void changeUi() {
		
		ui = false;
	}
}
