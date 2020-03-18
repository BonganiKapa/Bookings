package airline.bookings.airport.bean;

import java.io.Serializable;

public class AirportBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String airportName;
	private String city;
	private String province;
	private String code;
	private String iata;
	
	
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}

	
	
}

