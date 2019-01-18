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

		System.out.println("Entrez le num�ro du vol xxxx");
		String num = lectureClavier.nextLine();

		System.out.println("Entrez votre nom");
		String lastname = lectureClavier.nextLine();

		System.out.println("Entrez votre pr�nom");
		String firstname = lectureClavier.nextLine();

		System.out.println("Entrez votre age");
		Integer age = Integer.valueOf(lectureClavier.nextLine());

		FlightDAO flightDAO = new FlightDAO();
		Flight flight = flightDAO.findFlightFromNum(num);

		Booking booking = new Booking(lastname, firstname, age, flight);
		bookingDAO.create(booking);

		booking.setNumReservation();
		bookingDAO.update(booking);

		System.out.println("Votre vol est r�serv� !\n");

	}

	public void listBookingFlight() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le num�ro du vol xxxx");
		String num = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.findBookingFromNum(num);
		System.out.println("Num�ro de r�servation | Nom  | Pr�nom | Num�ro de vol | Date de d�part");
		
		for (Booking booking : bookings) {
			System.out.println(booking.toString());
		}
	}

	public void cancelBooking() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le num�ro du vol � annul� xxxx");
		String num = lectureClavier.nextLine();

		Booking booking= bookingDAO.cancelBooking(num);
		bookingDAO.delete(booking);

		System.out.println("Votre r�servation est bien annul�e");
	}

	public void listBookingUser() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le num�ro de la r�servation xxxx-x");
		String name = lectureClavier.nextLine();

		List<Booking> bookings= bookingDAO.listBookingFromUser(name);
		System.out.println("Num�ro de r�servation | Nom  | Pr�nom | Num�ro de vol | Date de d�part");

		for (Booking booking : bookings) {
			System.out.println(booking.toString());
		}
	}
}
