package com.test.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
	
	private static String remote=System.getProperty("remote");
	private static String hubUrl = "https:localhost";
	
	private WebDriverFactory() {}
	
	public static WebDriver createWebDriver(Browser browser) {
		WebDriver driver;
		
		if("true".equalsIgnoreCase(remote)) {
			driver= getRemoteWebDriver(browser);
		}else{
			driver = getLocalWebDriver(browser);
		}
		
		return driver;
	}
	
	public static WebDriver getLocalWebDriver(Browser browser) {
		
		WebDriver driver;
		
		switch(browser) {
			case EDGE:
				driver=new EdgeDriver();
				break;
			case FIREFOX:
				driver =new FirefoxDriver();
				break;
			default:
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<>();
			    prefs.put("profile.password_manager_leak_detection", false);
				options.setExperimentalOption("prefs", prefs);
				driver=new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static WebDriver getRemoteWebDriver(Browser browser) {
		WebDriver driver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser.getBrowserName());
		try {
			driver = new RemoteWebDriver(new URL(hubUrl).toURI().toURL(),capabilities);
		} catch (MalformedURLException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		return driver;
	}
}
