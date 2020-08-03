package utils;

import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;

public class InstancesManager {

	public static ConcurrentHashMap<Long, WebDriver> driverMap = new ConcurrentHashMap<Long, WebDriver>();
}
