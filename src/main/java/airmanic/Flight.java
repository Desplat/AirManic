package airmanic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@SequenceGenerator(name = "flight_seq", allocationSize = 100)
public class Flight {

	/*
	 * ####################################################################
	 * ATTRIBUTES
	 * ####################################################################
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
	private Integer id;

	@Column
	@NotBlank
	private String number;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Plane plane;

	@Column
	@NotNull
	private int nbrPlace;

	@Column
	@NotBlank
	private String departureCity;

	@Column
	@NotBlank
	private String arrivalCity;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateDepart;
	
	@OneToMany(mappedBy = "flight")
	private List<Booking> reservations;

	/*
	 * ####################################################################
	 * CONSTRUCTOR
	 * ####################################################################
	 */

	public Flight() {
		super();
		this.plane = Plane.A330;
		this.nbrPlace = 0;
		this.dateDepart = new Date();
	}

	public Flight(String numero, Plane type, int nbrPlace, String departureCity, String arrivalCity, Date dateDepart) {

		this.number = numero;
		this.plane = type;
		this.nbrPlace = nbrPlace;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateDepart = dateDepart;
		this.reservations = new ArrayList<>();
	}

	/*
	 * ##########################################################################
	 * GETTER - SETTER
	 * ##########################################################################
	 */

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumero() {
		return number;
	}

	public void setNumero(String numero) {
		this.number = numero;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public int getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(int nbrPlace) {
		this.nbrPlace = nbrPlace;
	}

	public String getVilleDepart() {
		return departureCity;
	}

	public void setVilleDepart(String villeDepart) {
		this.departureCity = villeDepart;
	}

	public String getVilleArrive() {
		return arrivalCity;
	}

	public void setVilleArrive(String villeArrive) {
		this.arrivalCity = villeArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Booking> getReservations() {
		return reservations;
	}

	public void setReservations(List<Booking> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation(Booking reservation) {
		this.reservations.add(reservation);
	}

	@Override
	public String toString() {
		return number + "\t| " + plane + "\t| " + nbrPlace + "\t| " + departureCity  + "\t| " + arrivalCity + "\t| " + dateDepart;
	}
}
