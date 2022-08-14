package utilities;

import org.apache.log4j.Logger;


public class Log {
	
	public static Logger Log= Logger.getLogger(Log.class.getName());
	
	public static void startTest(String stest) {
		System.out.println("------------ "+stest+" Test Start------------");
	}
	
	
	public static void endTest(String etest) {
		System.out.println("------------ "+etest+" Test End------------");
	}
	
	public static void info(String message) {
		Log.info(message);
	}
	
	public static void debug(String message) {
		Log.debug(message);
	}
	
	public static void fatal(String message) {
		Log.fatal(message);
	}
	
	public static void error(String message) {
		Log.error(message);
	}
}
