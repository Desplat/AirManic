package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import airmanic.Flight;
import service.DatabaseHelper;

public class FlightDAO implements DAO<Flight> {
	
	private static final String SELECT = "select f from Flight f ";

	public void delete(Flight flight) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		Flight findFlight = em.find(Flight.class, flight.getId());

		if (findFlight != null) {
			em.remove(findFlight);
		}
		DatabaseHelper.commitTxAndClose(em);
	}

	public List<Flight> listAllFlight() {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Flight> query = em
				.createQuery(SELECT, Flight.class);

		List<Flight> flights = query.getResultList();

		DatabaseHelper.commitTxAndClose(em);

		return flights;
	}
	
	public Flight findFlightFromNum(String num) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Flight> query = em
				.createQuery(SELECT + "where number=:nbr", Flight.class);

		query.setParameter("nbr", num);
		Flight flight = query.getSingleResult();

		DatabaseHelper.commitTxAndClose(em);

		return flight;
	}
	
	public List<Flight> findFlightFromCity(String departureCity, String arrivalCity) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Flight> query = em
				.createQuery(SELECT + "where f.departureCity=:start and f.arrivalCity=:end", Flight.class);

		query.setParameter("start", departureCity);
		query.setParameter("end", arrivalCity);
		List<Flight> flights = query.getResultList();

		DatabaseHelper.commitTxAndClose(em);

		return flights;
	}
}
