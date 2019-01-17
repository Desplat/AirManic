package airmanic;

import java.util.Date;

public class Main {

	static boolean ui = true;

	public static void main(String[] args) {
		
		Flight flight = new Flight("0001", Type.A380, 250, "Paris", "Bordeaux", new Date());
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
}
