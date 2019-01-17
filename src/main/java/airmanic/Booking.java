package airmanic;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "res_seq", allocationSize = 100)
public class Booking {
	
	/*
	 * ####################################################################
	 * ATTRIBUTES
	 * ####################################################################
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq")
	private Integer id;
	
	@ManyToOne
	private Flight flight;
	
	@Column
	@NotBlank
	private String lastname;
	
	@Column
	@NotBlank
	private String firstname;
	
	@Column
	@NotNull
	private int age;
	
	@Column
	private String numReservation;
	
	/*
	 * ####################################################################
	 * CONSTRUCTOR
	 * ####################################################################
	 */

	public Booking() {
		super();
	}
	
	public Booking(String lastname, String firstname, int age, Flight flight) {
		
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.flight = flight;		
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
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getNumReservation() {
		return numReservation;
	}

	public void setNumReservation() {
		this.numReservation = flight.getNumero() + "-" + id;
	}
	
	@Override
	public String toString() {
		return numReservation + " | " + lastname + " | " + firstname + " | " + flight.getNumero() + " | " + flight.getDateDepart();
	}
}
