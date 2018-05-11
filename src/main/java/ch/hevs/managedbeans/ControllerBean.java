package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;
import ch.hevs.travelServices.Travel;

public class ControllerBean
{
	//General
	private Travel travel;

	//homepage.xhtml
	private List<String> bigImages;

	//Destinations.xhtml
	private List<Destination> destinations;
	private Destination selectedDestination;

	//bookingForm.xhtml
	private List<Flight> flightList;
	private Flight selectedFlight;

	//profile.xhtml
	private Passenger currentUser;

	//administration.xhtml
	private List<DestinationArrival> arrivalList;
	private List<DestinationDeparture> departureList;
	private List<Passenger> userList;
	private int nbTravelers;
	private int nbDeparture;
	private int nbArrival;
	private int nbFlight;

	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		//travel = (Travel) ctx.lookup("java:global/Travel-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelServices.Travel");
		travel = (Travel) ctx.lookup("java:app/Travel-0.0.1-SNAPSHOT/TravelBean");

		// Create and populate a list of flight objects
		setFlightList(new ArrayList<Flight>());
		setFlightList(travel.getFlights());

		// Create and populate a list of destination objects
		setDestinations(new ArrayList<Destination>());
		setDestinations(travel.getDestinations());

		// Create and populate a list of DestinationArrival objects
		setArrivalList(new ArrayList<DestinationArrival>());
		setArrivalList(travel.getDestinationsArrival());

		// Create and populate a list of DestinationDeparture objects
		setDepartureList(new ArrayList<DestinationDeparture>());
		setDepartureList(travel.getDestinationsDeparture());

		// Create and populate a list of DestinationDeparture objects
		setUserList(new ArrayList<Passenger>());
		setUserList(travel.getUsers());

		// Get user N�3 to simulate a logged in user in the profile page
		setCurrentUser(userList.get(2));

		// Get numbers for the admin panel stat
		setNbTravelers(travel.getNbTravelers()) ;
		setNbArrival(travel.getNbArrival()) ;
		setNbDeparture(travel.getNbDeparture()) ;
		setNbFlight(travel.getNbFlight()) ;

		populateBigImageList();
	}

	public void populateDatabase(){
		travel.populateDatabase();
	}

	public void populateBigImageList(){
		bigImages = new ArrayList<String>();
		bigImages.add("Amsterdam.jpg");
		bigImages.add("Barcelone.jpg");
		bigImages.add("Bruges.jpg");
		bigImages.add("Budapest.jpg");
		bigImages.add("Copenhagen.jpg");
		bigImages.add("Edinburgh.jpg");
		bigImages.add("Florence.jpg");
		bigImages.add("Istanbul.jpg");
		bigImages.add("Londre.jpg");
		bigImages.add("Lucerne.jpg");
		bigImages.add("Madrid.jpg");
		bigImages.add("Nuremberg.jpg");
		bigImages.add("Paris.jpg");
		bigImages.add("Rome.jpg");
		bigImages.add("Salzburg.jpg");
		bigImages.add("Stockholm.jpg");
		bigImages.add("Venise.jpg");
		bigImages.add("Vienne.jpg");
		bigImages.add("Zurich.jpg");
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public Destination getSelectedDestination() {
		return selectedDestination;
	}

	public void setSelectedDestination(Destination selectedDestination) {
		this.selectedDestination = selectedDestination;
	}

	public List<String> getBigImages() {
		return bigImages;
	}

	public void setBigImages(List<String> bigImages) {
		this.bigImages = bigImages;
	}

	public Flight getSelectedFlight() {
		return selectedFlight;
	}

	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	public List<DestinationArrival> getArrivalList() {
		return arrivalList;
	}

	public void setArrivalList(List<DestinationArrival> arrivalList) {
		this.arrivalList = arrivalList;
	}

	public List<DestinationDeparture> getDepartureList() {
		return departureList;
	}

	public void setDepartureList(List<DestinationDeparture> departureList) {
		this.departureList = departureList;
	}

	public List<Passenger> getUserList() {
		return userList;
	}

	public void setUserList(List<Passenger> userList) {
		this.userList = userList;
	}

	public int getNbDeparture() {
		return nbDeparture;
	}

	public void setNbDeparture(int nbDeparture) {
		this.nbDeparture = nbDeparture;
	}

	public int getNbArrival() {
		return nbArrival;
	}

	public void setNbArrival(int nbArrival) {
		this.nbArrival = nbArrival;
	}

	public int getNbFlight() {
		return nbFlight;
	}

	public void setNbFlight(int nbFlight) {
		this.nbFlight = nbFlight;
	}

	public int getNbTravelers() {
		return nbTravelers;
	}

	public void setNbTravelers(int nbTravelers) {
		this.nbTravelers = nbTravelers;
	}

	public Passenger getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Passenger currentUser) {
		this.currentUser = currentUser;
	}
}
