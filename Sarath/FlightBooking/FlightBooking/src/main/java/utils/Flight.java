package utils;

public class Flight {

	private String flightNumber;
	private int price;
	private int duration;
	private int index; 
	
	public Flight(int index, String flightNumber, int price, int duration) {
		this.index = index;
		this.flightNumber = flightNumber;
		this.price = price;
		this.duration = duration;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}