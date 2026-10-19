package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.test.utils.Browser;
import com.test.utils.ConfigReader;
import com.test.utils.WebDriverFactory;

public class BaseTest {
	WebDriver driver;
	ConfigReader configReader=new ConfigReader();
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser"})
	public void setUp(String browser) {
		// Add any setup code here, such as initializing WebDriver, loading configurations, etc.
		Browser browserType=Browser.valueOf(browser.toUpperCase());
		driver=WebDriverFactory.createWebDriver(browserType);
		driver.get(configReader.getProperty("app.url"));
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
//		if(driver!=null) {
//			driver.quit();
//		}
	}
	
}
