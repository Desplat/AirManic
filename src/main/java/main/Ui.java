package main;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.ServiceBooking;
import service.ServiceFlight;

public class Ui {

	private static final  Logger LOG = LoggerFactory.getLogger(ServiceFlight.class);
	
	private static final  String CHOIX = "Entrez votre choix : ";
	
	private Ui() {
		
		throw new IllegalStateException("Utility class");
	}

	public static void mainMenu() {

		LOG.trace("1) Gestion des vols");
		LOG.trace("2) Gestion des réservations");
		LOG.trace("3) Quitter\n");
		LOG.trace(CHOIX);

		Scanner lectureClavier = new Scanner(System.in);
		Integer answer = Integer.valueOf(lectureClavier.nextLine());

		switch (answer) {

		case 1:
			flightManagement();
			break;
		case 2:
			bookingManagement();
			break;
		case 3:
			Main.changeUi();
			break;
		default:
			LOG.trace("Vous devez entrer 1, 2 ou 3 !");
			break;
		}
	}

	public static void flightManagement() {

		LOG.trace("1) Création d'un vol");
		LOG.trace("2) Liste des vols");
		LOG.trace("3) Trouver un avion avec son numéro");
		LOG.trace("4) Trouver un avion avec ses villes de départ/arrivée");
		LOG.trace("5) Retournez en arrière\n");
		LOG.trace(CHOIX);

		Scanner lectureClavier = new Scanner(System.in);
		Integer answer = Integer.valueOf(lectureClavier.nextLine());

		ServiceFlight service = new ServiceFlight();

		switch (answer) {

		case 1:
			service.createFlight();
			break;
		case 2:
			service.listFlights();
			break;
		case 3:
			service.findFlightNum();
			break;
		case 4:
			service.findFlightCity();
			break;
		case 5:
		default:
			break;
		}
	}

	public static void bookingManagement() {

		LOG.trace("1) Créer une réservation");
		LOG.trace("2) Voir les réservation d'un vol");
		LOG.trace("3) Annuler une réservation");
		LOG.trace("4) Voir toutes vos réservations");
		LOG.trace("5) Retournez en arrière\n");
		LOG.trace(CHOIX);

		Scanner lectureClavier = new Scanner(System.in);
		Integer answer = Integer.valueOf(lectureClavier.nextLine());

		ServiceBooking service = new ServiceBooking();

		switch (answer) {

		case 1:
			service.createBooking();
			break;
		case 2:
			service.listBookingFlight();
			break;
		case 3:
			service.cancelBooking();
			break;
		case 4:
			service.listBookingUser();
			break;
		case 5:
		default:
			break;
		}
	}
}
