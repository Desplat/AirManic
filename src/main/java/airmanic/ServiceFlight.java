package airmanic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ServiceFlight {

	private FlightDAO flightDAO;

	public ServiceFlight() {

		flightDAO = new FlightDAO();
	}

	public void createFlight() {

		Scanner lectureClavier = new Scanner(System.in);

		System.out.println("Entrez le numéro du vol xxxx");
		String num = lectureClavier.nextLine();

		System.out.println("Entrez le type d'avion");
		String quelType = lectureClavier.nextLine();
		Type type = Type.valueOf(quelType);

		System.out.println("Entrez le nombre de place");
		Integer numPlace = Integer.valueOf(lectureClavier.nextLine());

		System.out.println("Entrez la ville de départ");
		String villeDepart = lectureClavier.nextLine();

		System.out.println("Entrez la ville d'arrivée");
		String villeArrive = lectureClavier.nextLine();

		System.out.println("Entrez la date de départ dd/mm/yyyy");
		String quelleDate = lectureClavier.nextLine();
		Date date;
		
		try {
			date = new SimpleDateFormat("dd/mm/yyyy").parse(quelleDate);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			date = new Date();
		}

		Flight flight = new Flight(num, type, numPlace, villeDepart, villeArrive, date);
		flightDAO.create(flight);
		//lectureClavier.close();
	}
	
	public void listFlights() {
		
		List<Flight> flights = flightDAO.listAllFlight();
		System.out.println("Numéro\t| Type\t| Place\t| Départ\t| Arrivé\t| Date");
		
		for (Flight flight : flights){
			System.out.println(flight.toString());
		}
	}

	public void findFlightNum(){
		
		System.out.println("Entrez le numéro du vol que vous recherchez");
		Scanner lectureClavier = new Scanner(System.in);
		String num = lectureClavier.nextLine();
		
		Flight flight = flightDAO.findFlightFromNum(num);
		System.out.println("Numéro | Type  | Place | Départ                 | Arrivé             | Date");
		System.out.println(flight.toString());
		System.out.println("");
	}
	
	public void findFlightCity() {
		
		Scanner lectureClavier = new Scanner(System.in);
		System.out.println("Entrez la ville de départ du vol que vous recherchez");
		String star = lectureClavier.nextLine();
		System.out.println("Entrez la ville d'arrivé du vol que vous recherchez");
		String end = lectureClavier.nextLine();
		
		List <Flight> flights = flightDAO.findFlightFromCity(star, end);
		System.out.println("Numéro | Type  | Place | Départ                 | Arrivé             | Date");
		for(Flight flight: flights)
			System.out.println(flight.toString());
		
	}
}
