package ch.hevs.travelServices;

import java.util.List;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Destination;
import ch.hevs.businessobject.DestinationArrival;
import ch.hevs.businessobject.DestinationDeparture;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

@Stateful
@ManagedBean
@SessionScoped
public class TravelBean implements Travel {

	@PersistenceContext(name = "TravelPU")
	private EntityManager em;

	//--------------------- METHODS ---------------------
	
	public List<Flight> getFlights() {
		return em.createQuery("FROM Flight").getResultList();
	}
	
	public List<Destination> getDestinations() {
		return em.createQuery("FROM Destination").getResultList();
	}

	public List<DestinationDeparture> getDestinationsDeparture() {
		return em.createQuery("FROM DestinationDeparture").getResultList();
	}

	public List<DestinationArrival> getDestinationsArrival() {
		return em.createQuery("FROM DestinationArrival").getResultList();
	}

	public List<Passenger> getUsers() {
		return em.createQuery("FROM User").getResultList();
	}
	
	public int getNbTravelers() {
		int nb = ((Number)em.createQuery("Select Count(n) from User n").getSingleResult()).intValue();
		return nb;
	}

	public int getNbArrival() {
		int nb = ((Number)em.createQuery("Select Count(a) from DestinationArrival a").getSingleResult()).intValue();
		return nb;
	}

	public int getNbDeparture() {
		int nb = ((Number)em.createQuery("Select Count(d) from DestinationDeparture d").getSingleResult()).intValue();
		return nb;
	}

	public int getNbFlight() {
		int nb = ((Number)em.createQuery("Select Count(f) from Flight f").getSingleResult()).intValue();
		return nb;
	}
	
	public void populateDatabase()
	{
		//--------------------- Adresses Destinations ---------------------
		Address Amsterdam = new Address("1118", "Evert van de Beekstraat 202", "Amsterdam", "Pays-Bas");
		Address Barcelone = new Address("08820", "El Prat de Llobregat", "Barcelone", "Espagne");
		Address Bruges = new Address("8400", "Nieuwpoortsesteenweg 889", "Bruges", "Belgique");
		Address Budapest = new Address("1185", "Nemzetközi Repuloter", "Budapest", "Hongrie");
		Address Copenhagen = new Address("2770", "Lufthavnsboulevarden 6", "Copenhagen", "Danemark");
		Address Edinburgh = new Address("3256", "Édimbourg EH12 9DN", "Edinburgh", "Royaume-Uni");
		Address Florence = new Address("50127", "Via del Termine 11", "Florence", "Italie");
		Address Istanbul = new Address("34149", "Istanbul", "Istanbul", "Turquie");
		Address Londre = new Address("2546", "Nelson Road", "Londre", "Royaume-Uni");
		Address Lucerne = new Address("8058", "Zürich-Flughafen", "Lucerne", "Suisse");
		Address Madrid = new Address("28042", "Av de la Hispanidad", "Madrid", "Espagne");
		Address Nuremberg = new Address("90411", "Flughafenstraße 100", "Nuremberg", "Allemagne");
		Address Paris = new Address("95700", "Roissy-en-France", "Paris", "France");
		Address Prague = new Address("16108", "Aviatická", "Prague", "Tchéquie");
		Address Rome = new Address("00054", "Via dell' Aeroporto di Fiumicino 320", "Rome", "Italie");
		Address Salzburg = new Address("5020", "Innsbrucker Bundesstraße 95", "Salzburg", "Autriche");
		Address Stockholm = new Address("19045", "Stockholm-Arlanda", "Stockholm", "Suède");
		Address Venise = new Address("30173", "Viale Galileo Galilei", "Venise", "Italie");
		Address Vienne = new Address("1300", "Wien-Flughafen", "Vienne", "Autriche");
		Address Zurich = new Address("8058", "Zürich-Flughafen", "Zurich", "Suisse");
		
		//--------------------- Addresses Users ---------------------
		Address Vincent = new Address("1964", "Rue Centrale 65", "Conthey", "Suisse");
		Address Xavier = new Address("3960", "Avenue Poset 5", "Sierre", "Suisse");
		Address Roger = new Address("1965", "Route de Binii 12", "Savièse", "Suisse");
		Address Alexandre = new Address("1907", "Rue de l'Autorout 2", "Saxon", "Suisse");
		Address Laura = new Address("1920", "Rue du Levant 42", "Martigny", "Suisse");
		Address Thierry = new Address("1977", "Chemin de la Scie 3", "Icogne", "Suisse");
		Address David = new Address("1922", "Chemin de Ladray 4", "Salvan", "Suisse");
		Address Nicolas = new Address("1890", "Route de la chapelle 35", "Saint-Maurice", "Suisse");

		//--------------------- Users ---------------------
		Passenger u1 = new Passenger("Caibis", "Vincent");		
		u1.setAddress(Vincent);
		Passenger u2 = new Passenger("Nendaz", "Xavier");		
		u2.setAddress(Xavier);
		Passenger u3 = new Passenger("Dupont", "Roger");		
		u3.setAddress(Roger);
		Passenger u4 = new Passenger("Germanier","Alexandre");		
		u4.setAddress(Alexandre);
		Passenger u5 = new Passenger("Bianco", "Laura");		
		u5.setAddress(Laura);
		Passenger u6 = new Passenger("Moulin", "Thierry");		
		u6.setAddress(Thierry);
		Passenger u7 = new Passenger("Mendes", "David");		
		u7.setAddress(David);
		Passenger u8 = new Passenger("Maret", "Nicolas");		
		u8.setAddress(Nicolas);

		//--------------------- Departure destinations ---------------------
		DestinationDeparture dd1 = new DestinationDeparture();
		dd1.setCityName("Amsterdam");
		dd1.setAirportName("Amsterdam Airport");
		dd1.setGatesNumber(2);
		dd1.setAddress(Amsterdam);

		DestinationDeparture dd2 = new DestinationDeparture();
		dd2.setCityName("Barcelone");
		dd2.setAirportName("Barcelone Airport");
		dd2.setGatesNumber(4);
		dd2.setAddress(Barcelone);		
		
		DestinationDeparture dd3 = new DestinationDeparture();
		dd3.setCityName("Bruges");
		dd3.setAirportName("Bruges Airport");
		dd3.setGatesNumber(2);
		dd3.setAddress(Bruges);

		DestinationDeparture dd4 = new DestinationDeparture();
		dd4.setCityName("Budapest");
		dd4.setAirportName("Budapest Airport");
		dd4.setGatesNumber(4);
		dd4.setAddress(Budapest);
		
		DestinationDeparture dd5 = new DestinationDeparture();
		dd5.setCityName("Copenhagen");
		dd5.setAirportName("Copenhagen Airport");
		dd5.setGatesNumber(2);
		dd5.setAddress(Copenhagen);

		DestinationDeparture dd6 = new DestinationDeparture();
		dd6.setCityName("Edinburgh");
		dd6.setAirportName("Edinburgh Airport");
		dd6.setGatesNumber(4);
		dd6.setAddress(Edinburgh);
		
		DestinationDeparture dd7 = new DestinationDeparture();
		dd7.setCityName("Florence");
		dd7.setAirportName("Florence Airport");
		dd7.setGatesNumber(2);
		dd7.setAddress(Florence);

		DestinationDeparture dd8 = new DestinationDeparture();
		dd8.setCityName("Istanbul");
		dd8.setAirportName("Istanbul Airport");
		dd8.setGatesNumber(4);
		dd8.setAddress(Istanbul);
		
		DestinationDeparture dd9 = new DestinationDeparture();
		dd9.setCityName("Londre");
		dd9.setAirportName("Londre Airport");
		dd9.setGatesNumber(2);
		dd9.setAddress(Londre);

		DestinationDeparture dd10 = new DestinationDeparture();
		dd10.setCityName("Lucerne");
		dd10.setAirportName("Lucerne Airport");
		dd10.setGatesNumber(4);
		dd10.setAddress(Lucerne);

		// --------------------- Arrival destinations ---------------------
		DestinationArrival da1 = new DestinationArrival();
		da1.setCityName("Madrid");
		da1.setAirportName("Madrid Airport");
		da1.setGatesNumber(3);
		da1.setAddress(Madrid);

		DestinationArrival da2 = new DestinationArrival();
		da2.setCityName("Nuremberg");
		da2.setAirportName("Nuremberg Airport");
		da2.setGatesNumber(5);
		da2.setAddress(Nuremberg);	
		
		DestinationArrival da3 = new DestinationArrival();
		da3.setCityName("Paris");
		da3.setAirportName("Paris Airport");
		da3.setGatesNumber(3);
		da3.setAddress(Paris);

		DestinationArrival da4 = new DestinationArrival();
		da4.setCityName("Prague");
		da4.setAirportName("Prague Airport");
		da4.setGatesNumber(5);
		da4.setAddress(Prague);
		
		DestinationArrival da5 = new DestinationArrival();
		da5.setCityName("Rome");
		da5.setAirportName("Rome Airport");
		da5.setGatesNumber(3);
		da5.setAddress(Rome);

		DestinationArrival da6 = new DestinationArrival();
		da6.setCityName("Salzburg");
		da6.setAirportName("Salzburg Airport");
		da6.setGatesNumber(5);
		da6.setAddress(Salzburg);
		
		DestinationArrival da7 = new DestinationArrival();
		da7.setCityName("Stockholm");
		da7.setAirportName("Stockholm Airport");
		da7.setGatesNumber(3);
		da7.setAddress(Stockholm);

		DestinationArrival da8 = new DestinationArrival();
		da8.setCityName("Venise");
		da8.setAirportName("Venise Airport");
		da8.setGatesNumber(5);
		da8.setAddress(Venise);
		
		DestinationArrival da9 = new DestinationArrival();
		da9.setCityName("Vienne");
		da9.setAirportName("Vienne Airport");
		da9.setGatesNumber(3);
		da9.setAddress(Vienne);

		DestinationArrival da10 = new DestinationArrival();
		da10.setCityName("Zurich");
		da10.setAirportName("Zurich Airport");
		da10.setGatesNumber(5);
		da10.setAddress(Zurich);

		//--------------------- Flights ---------------------
		Flight f1 = new Flight(101, 150, 01.30 , 08.30, 10.00, "Aero Lloyd", dd1, da1);
		Flight f2 = new Flight(102, 130, 01.00 , 13.30, 14.30, "Tiara Air", dd2, da2);
		Flight f3 = new Flight(103, 230, 01.30 , 06.30, 08.00, "Vertir Airlines", dd3, da3);
		Flight f4 = new Flight(104, 220, 03.00 , 10.00, 13.00, "Augsburg Airways", dd4, da4);
		Flight f5 = new Flight(105, 150, 01.30 , 08.30, 10.00, "Jetstar Airways", dd5, da5);
		Flight f6 = new Flight(106, 130, 01.00 , 13.30, 14.30, "Austrian Airlines", dd6, da6);
		Flight f7 = new Flight(107, 230, 01.30 , 06.30, 08.00, "Brussels Airlines", dd7, da7);
		Flight f8 = new Flight(108, 220, 03.00 , 10.00, 13.00, "Trans Air Benin", dd8 , da8);
		Flight f9 = new Flight(109, 150, 01.30 , 08.30, 10.00, "Bolivian Airlines", dd9, da9);
		Flight f10 = new Flight(110, 130, 01.00 , 13.30, 14.30, "Royal Air Cambodge", dd10, da10);
		Flight f11 = new Flight(111, 230, 01.30 , 06.30, 08.00, "AIR BERLIN", dd1, da1);
		Flight f12 = new Flight(112, 220, 03.00 , 10.00, 13.00, "AIR FRANCE", dd2 , da2);
		Flight f13= new Flight(113, 150, 01.30 , 08.30, 10.00, "SWISS", dd3, da3);
		Flight f14= new Flight(114, 130, 01.00 , 13.30, 14.30, "EASY-JET", dd4, da4);
		Flight f15= new Flight(115, 230, 01.30 , 06.30, 08.00, "AIR BERLIN", dd5, da5);
		Flight f16= new Flight(116, 220, 03.00 , 10.00, 13.00, "AIR FRANCE", dd6 , da6);
		
		//--------------------- Persist everything ---------------------
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		em.persist(u4);
		em.persist(u5);
		em.persist(u6);
		em.persist(u7);
		em.persist(u8);
		em.persist(dd1);
		em.persist(dd2);
		em.persist(dd3);
		em.persist(dd4);
		em.persist(dd5);
		em.persist(dd6);
		em.persist(dd7);
		em.persist(dd8);
		em.persist(dd9);
		em.persist(dd10);
		em.persist(da1);
		em.persist(da2);
		em.persist(da3);
		em.persist(da4);
		em.persist(da5);
		em.persist(da6);
		em.persist(da7);
		em.persist(da8);
		em.persist(da9);
		em.persist(da10);
		em.persist(f1);
		em.persist(f2);	
		em.persist(f3);	
		em.persist(f4);	
		em.persist(f5);
		em.persist(f6);	
		em.persist(f7);	
		em.persist(f8);
		em.persist(f9);
		em.persist(f10);	
		em.persist(f11);	
		em.persist(f12);
		em.persist(f13);
		em.persist(f14);	
		em.persist(f15);	
		em.persist(f16);
	}
}
