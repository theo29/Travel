package ch.hevs.travelServices;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.User;

@Local
public interface Travel {

	List<Flight> getFlights();
	List<Destination> getDestinations();	
	List<DestinationDeparture> getDestinationsDeparture();
	List<DestinationArrival> getDestinationsArrival();	
	List<User> getUsers();
	int getNbTravelers();
	int getNbArrival();
	int getNbDeparture();
	int getNbFlight();
	void populateDatabase();
}
