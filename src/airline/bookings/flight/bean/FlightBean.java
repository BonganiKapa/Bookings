package airline.bookings.flight.bean;

import java.io.Serializable;

public class FlightBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String flightName;
	private String flightService;
	private String flightNum;
	private String departTime;
	private String arrivalTime;
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightService() {
		return flightService;
	}
	public void setFlightService(String flightService) {
		this.flightService = flightService;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
