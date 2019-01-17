package airManic;

import java.util.Scanner;

public class Ui {

	public static void mainMenu() {

		System.out.println("1) Gestion des vols");
		System.out.println("2) Gestion des r�servations");
		System.out.println("3) Quitter\n");
		System.out.println("Entrez votre choix : ");

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
			Main.ui = false;
			break;
		default:
			System.out.println("Vous devez entrer 1, 2 ou 3 !");
			break;
		}
		// lectureClavier.close();
	}

	public static void flightManagement() {

		System.out.println("1) Cr�ation d'un vol");
		System.out.println("2) Liste des vols");
		System.out.println("3) Trouver un avion avec son num�ro");
		System.out.println("4) Trouver un avion avec ses villes de d�part/arriv�e");
		System.out.println("5) Retournez en arri�re\n");
		System.out.println("Entrez votre choix : ");

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

		// lectureClavier.close();
	}

	public static void bookingManagement() {

		System.out.println("1) Cr�er une r�servation");
		System.out.println("2) Voir les r�servation d'un vol");
		System.out.println("3) Annuler une r�servation");
		System.out.println("4) Voir toutes vos r�servations");
		System.out.println("5) Retournez en arri�re\n");
		System.out.println("Entrez votre choix : ");

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

		// lectureClavier.close();
	}
}
