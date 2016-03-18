package com.epam.xpmc.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Driver {

	private static WebDriver driver;

	private Driver() {};

	public static WebDriver getInstance() {
		if (driver == null) {
			driver = new FirefoxDriver(getProfile());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;

	}

	private static FirefoxProfile getProfile() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.useDownloadDir", true);		
		profile.setPreference("browser.download.dir", getAbsolutePath());
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.ms-excel");
		return profile;

	}
	
	private static DesiredCapabilities getCapabilities() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, 
		   org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
		return cap;

	}
	
	
	private static String getAbsolutePath(){
//		System.out.println("This is - " + new File(".\\target\\").getAbsolutePath());
		return new File(".\\target\\").getAbsolutePath();
		
	}
}
