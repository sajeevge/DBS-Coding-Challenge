package utils;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {
	String sortCriteria;

	public FlightComparator(String sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	@Override
	public int compare(Flight flight1, Flight flight2) {
		switch (sortCriteria) {
		
			case CommonConstants.PRICE:
				if (flight1.getPrice() < flight2.getPrice()) {
					return -1;
				} else if (flight1.getPrice() > flight2.getPrice()) {
					return 1;
				}
				break;

			case CommonConstants.DURATION:
				if (flight1.getDuration() < flight2.getDuration()) {
					return -1;
				} else if (flight1.getDuration() > flight2.getDuration()) {
					return 1;
				}
				break;
				
		}
		return 0;
	}
}