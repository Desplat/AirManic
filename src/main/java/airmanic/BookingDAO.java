package airmanic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BookingDAO extends DAO<Booking> {

	public void delete(Booking booking) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		Booking findBooking = em.find(Booking.class, booking.getId());

		if (findBooking != null) {
			em.remove(findBooking);
		}
		DatabaseHelper.commitTxAndClose(em);
	}

	public List<Booking> findBookingFromNum(String num) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Booking> query = em.createQuery("select b " + "from Booking b " + "join b.flight f" + " where f.number=:nbr", Booking.class);

		query.setParameter("nbr", num);
		List<Booking> bookings = query.getResultList();

		DatabaseHelper.commitTxAndClose(em);

		return bookings;
	}
	
	public Booking cancelBooking(String num) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Booking> query = em.createQuery("select b " + "from Booking b " + " where b.numReservation=:nbr", Booking.class);

		query.setParameter("nbr", num);
		Booking booking = query.getSingleResult();

		DatabaseHelper.commitTxAndClose(em);

		return booking;
	}
	
	public List<Booking> listBookingFromUser(String name) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		TypedQuery<Booking> query = em.createQuery("select b " + "from Booking b " + " where b.lastname=:nbr" + " order by b.lastname, b.firstname, b.age", Booking.class);

		query.setParameter("nbr", name);
		List<Booking> bookings = query.getResultList();

		DatabaseHelper.commitTxAndClose(em);

		return bookings;
	}
}
