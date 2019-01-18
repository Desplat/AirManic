package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import airmanic.Flight;
import airmanic.Plane;
import dao.FlightDAO;

public class ServiceFlight {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceFlight.class);

	private FlightDAO flightDAO;

	public ServiceFlight() {

		flightDAO = new FlightDAO();
	}

	public void createFlight() {

		Scanner lectureClavier = new Scanner(System.in);

		LOG.trace("Entrez le num�ro du vol xxxx");
		String num = lectureClavier.nextLine();

		LOG.trace("Entrez le type d'avion");
		String quelType = lectureClavier.nextLine();
		Plane type = Plane.valueOf(quelType);

		LOG.trace("Entrez le nombre de place");
		Integer numPlace = Integer.valueOf(lectureClavier.nextLine());

		LOG.trace("Entrez la ville de d�part");
		String villeDepart = lectureClavier.nextLine();

		LOG.trace("Entrez la ville d'arriv�e");
		String villeArrive = lectureClavier.nextLine();

		LOG.trace("Entrez la date de d�part dd/mm/yyyy");
		String quelleDate = lectureClavier.nextLine();
		Date date;

		try {
			date = new SimpleDateFormat("dd/mm/yyyy").parse(quelleDate);
		} catch (ParseException e) {
			LOG.trace(e.getMessage());
			date = new Date();
		}

		Flight flight = new Flight(num, type, numPlace, villeDepart, villeArrive, date);
		flightDAO.create(flight);
	}

	public void listFlights() {

		List<Flight> flights = flightDAO.listAllFlight();
		LOG.trace("Num�ro\t| Type\t| Place\t| D�part\t| Arriv�\t| Date");

		if (LOG.isTraceEnabled()) {
			for (Flight flight : flights) {
				LOG.trace(flight.toString());
			}
		}
	}

	public void findFlightNum() {

		LOG.trace("Entrez le num�ro du vol que vous recherchez");
		Scanner lectureClavier = new Scanner(System.in);
		String num = lectureClavier.nextLine();

		Flight flight = flightDAO.findFlightFromNum(num);
		LOG.trace("Num�ro | Type  | Place | D�part                 | Arriv�             | Date");
		if (LOG.isTraceEnabled()) {
			LOG.trace("{}", flight.toString());
		}
		LOG.trace("");
	}

	public void findFlightCity() {

		Scanner lectureClavier = new Scanner(System.in);
		LOG.trace("Entrez la ville de d�part du vol que vous recherchez");
		String star = lectureClavier.nextLine();
		LOG.trace("Entrez la ville d'arriv� du vol que vous recherchez");
		String end = lectureClavier.nextLine();

		List<Flight> flights = flightDAO.findFlightFromCity(star, end);
		LOG.trace("Num�ro | Type  | Place | D�part                 | Arriv�             | Date");
		if (LOG.isTraceEnabled()) {
			for (Flight flight : flights) {
				LOG.trace(flight.toString());
			}
		}

	}
}
