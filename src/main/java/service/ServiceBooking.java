package service;

import java.util.List;
import java.util.Scanner;

import airmanic.Booking;
import airmanic.Flight;
import dao.BookingDAO;
import dao.FlightDAO;

public class ServiceBooking {

	private BookingDAO bookingDAO;

	public ServiceBooking() {
		

		bookingDAO = new BookingDAO();
	}

	public void createBooking() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le numéro du vol xxxx");
		String num = lectureClavier.nextLine();

		System.out.println("Entrez votre nom");
		String lastname = lectureClavier.nextLine();

		System.out.println("Entrez votre prénom");
		String firstname = lectureClavier.nextLine();

		System.out.println("Entrez votre age");
		Integer age = Integer.valueOf(lectureClavier.nextLine());

		FlightDAO flightDAO = new FlightDAO();
		Flight flight = flightDAO.findFlightFromNum(num);

		Booking booking = new Booking(lastname, firstname, age, flight);
		bookingDAO.create(booking);

		booking.setNumReservation();
		bookingDAO.update(booking);

		System.out.println("Votre vol est réservé !\n");

	}

	public void listBookingFlight() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le numéro du vol xxxx");
		String num = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.findBookingFromNum(num);
		System.out.println("Numéro de réservation | Nom  | Prénom | Numéro de vol | Date de départ");
		
		for (Booking booking : bookings) {
			System.out.println(booking.toString());
		}
	}

	public void cancelBooking() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le numéro du vol à annulé xxxx");
		String num = lectureClavier.nextLine();

		Booking booking= bookingDAO.cancelBooking(num);
		bookingDAO.delete(booking);

		System.out.println("Votre réservation est bien annulée");
	}

	public void listBookingUser() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le numéro de la réservation xxxx-x");
		String name = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.listBookingFromUser(name);
		System.out.println("Numéro de réservation | Nom  | Prénom | Numéro de vol | Date de départ");

		for (Booking booking : bookings) {
			System.out.println(booking.toString());
		}
	}
}
