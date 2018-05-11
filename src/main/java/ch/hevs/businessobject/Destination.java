package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Destination{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String cityName;
	private String airportName;
	private int gatesNumber;


	// constructors
	protected Destination() {
	}

	public Destination(String cityName, String airportName, int gatesNumber) {
		this.cityName = cityName;
		this.airportName = airportName;
		this.gatesNumber = gatesNumber;
	}

	//Getters setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public int getGatesNumber() {
		return gatesNumber;
	}

	public void setGatesNumber(int gatesNumber) {
		this.gatesNumber = gatesNumber;
	}

	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	//Address
	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString(){
		return " "+airportName+" ";
	}
}