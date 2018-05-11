package ch.hevs.businessobject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int  flightNumber;
	private int  passengersNumber;
	private double duration; 
	private double departure; 
	private double timeArrival; 	
	private String airline;

	// relations
	@ManyToOne(cascade=CascadeType.REMOVE)
	private DestinationDeparture fkDestinationDeparture;

	// relations
	@ManyToOne(cascade=CascadeType.REMOVE)
	private DestinationArrival fkDestinationArrival;

	//constructors
	public Flight(){
	}

	public Flight(int flightNumber, int passengersNumber, double duration, double departure, double timeArrival,
			String airline, DestinationDeparture fkDestinationDeparture, DestinationArrival fkDestinationArrival){
		this.flightNumber = flightNumber;
		this.passengersNumber = passengersNumber;
		this.duration = duration;
		this.departure = departure; 
		this.timeArrival = timeArrival;
		this.airline = airline;
		this.fkDestinationDeparture = fkDestinationDeparture;
		this.fkDestinationArrival = fkDestinationArrival;
	}

	//getters setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getPassengersNumber() {
		return passengersNumber;
	}

	public void setPassengersNumber(int passengersNumber) {
		this.passengersNumber = passengersNumber;
	}

	public double getDuration() {
		return duration;
	}


	public double getTimeArrival() {
		return timeArrival;
	}


	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public void setDeparture(double departure) {
		this.departure = departure;
	}

	public void setTimeArrival(double timeArrival) {
		this.timeArrival = timeArrival;
	}

	public double getDeparture() {
		return departure;
	}

	public DestinationDeparture getFkDestinationDeparture() {
		return fkDestinationDeparture;
	}

	public void setFkDestinationDeparture(DestinationDeparture fkDestinationDeparture) {
		this.fkDestinationDeparture = fkDestinationDeparture;
	}

	public DestinationArrival getFkDestinationArrival() {
		return fkDestinationArrival;
	}

	public void setFkDestinationArrival(DestinationArrival fkDestinationArrival) {
		this.fkDestinationArrival = fkDestinationArrival;
	}
}