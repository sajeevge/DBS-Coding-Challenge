package comp.flights.helper;

import org.apache.log4j.Logger;

public class Log {

	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void info(String message) {
		Log.info(message);
	}
	
	public static void debug(String message) {
		Log.info(message);
	}
	
	public static void error(String message) {
		Log.info(message);
	}
	
	public static void trace(String message) {
		Log.info(message);
	}
	
	public static void fatal(String message) {
		Log.info(message);
	}
}
