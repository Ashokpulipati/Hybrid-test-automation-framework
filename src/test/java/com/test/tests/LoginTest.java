package com.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test(priority = 1)
    public void testLoginSuccess() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterCredentials(configReader.getProperty("app.valid.user"),configReader.getProperty("app.password"));
    }
}
