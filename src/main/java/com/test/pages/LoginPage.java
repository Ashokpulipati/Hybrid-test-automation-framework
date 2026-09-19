package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By userNameFieldXPath = By.xpath("//input[@data-test='username']");
	private By passwordFieldXPath = By.xpath("//input[@data-test='password']");
	private By loginButtonXPath = By.xpath("//input[@data-test='login-button']");

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername(String username) {
	    driver.findElement(userNameFieldXPath).clear();
	    driver.findElement(userNameFieldXPath).sendKeys(username);
	}

	public void enterPassword(String password) {
	    driver.findElement(passwordFieldXPath).clear();
	    driver.findElement(passwordFieldXPath).sendKeys(password);
	}

	public void enterCredentials(String username, String password) {
	    this.enterUsername(username);
	    this.enterPassword(password);
	}
}
