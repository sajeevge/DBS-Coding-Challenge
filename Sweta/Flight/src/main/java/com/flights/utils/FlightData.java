package com.flights.utils;

public class FlightData {

	String flightNumber;
	String fare;
	String travelTime;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public FlightData(String flightNumber, String fare, String travelTime) {
		super();
		this.flightNumber = flightNumber;
		this.fare = fare;
		this.travelTime = travelTime;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", fare=" + fare + ", travelTime=" + travelTime + "]";
	}
	
	
	
}
