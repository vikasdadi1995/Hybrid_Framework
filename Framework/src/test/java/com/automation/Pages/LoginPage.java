package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
	}

	@FindBy(id = "user-name") WebElement username;
	@FindBy(id = "password")  WebElement password;
	@FindBy(id = "login-button")  WebElement login;
	
	public void loginToSwagLabs(String Username, String Password) throws Exception
	{
		Thread.sleep(3000);
		username.sendKeys(Username);
		Thread.sleep(1000);
		password.sendKeys(Password);
		Thread.sleep(1000);
		login.click();
		Thread.sleep(3000);
	}

}
