package service;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import airmanic.Booking;
import airmanic.Flight;
import dao.BookingDAO;
import dao.FlightDAO;

public class ServiceBooking {
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceFlight.class);

	private BookingDAO bookingDAO;

	public ServiceBooking() {
		

		bookingDAO = new BookingDAO();
	}

	public void createBooking() {

		Scanner lectureClavier = new Scanner(System.in);

		LOG.trace("Entrez le numéro du vol xxxx");
		String num = lectureClavier.nextLine();

		LOG.trace("Entrez votre nom");
		String lastname = lectureClavier.nextLine();

		LOG.trace("Entrez votre prénom");
		String firstname = lectureClavier.nextLine();

		LOG.trace("Entrez votre age");
		Integer age = Integer.valueOf(lectureClavier.nextLine());

		FlightDAO flightDAO = new FlightDAO();
		Flight flight = flightDAO.findFlightFromNum(num);

		Booking booking = new Booking(lastname, firstname, age, flight);
		bookingDAO.create(booking);

		booking.setNumReservation();
		bookingDAO.update(booking);

		LOG.trace("Votre vol est réservé !\n");

	}

	public void listBookingFlight() {

		Scanner lectureClavier = new Scanner(System.in);

		LOG.trace("Entrez le numéro du vol xxxx");
		String num = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.findBookingFromNum(num);
		LOG.trace("Numéro de réservation | Nom  | Prénom | Numéro de vol | Date de départ");
		
		for (Booking booking : bookings) {
			LOG.trace(booking.toString());
		}
	}

	public void cancelBooking() {

		Scanner lectureClavier = new Scanner(System.in);

		LOG.trace("Entrez le numéro du vol à annulé xxxx");
		String num = lectureClavier.nextLine();

		Booking booking= bookingDAO.cancelBooking(num);
		bookingDAO.delete(booking);

		LOG.trace("Votre réservation est bien annulée");
	}

	public void listBookingUser() {

		Scanner lectureClavier = new Scanner(System.in);

		LOG.trace("Entrez le numéro de la réservation xxxx-x");
		String name = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.listBookingFromUser(name);
		LOG.trace("Numéro de réservation | Nom  | Prénom | Numéro de vol | Date de départ");

		for (Booking booking : bookings) {
			LOG.trace("{}", booking.toString());
		}
	}
}
