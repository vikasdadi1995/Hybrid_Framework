package com.automation.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.Pages.BaseClass;
import com.automation.Pages.LoginPage;
import com.automation.Utilities.BrowserFactory;
import com.automation.Utilities.Helper;

public class loginTestApplication extends BaseClass {

	@Test
	public void loginApp() throws Exception {

		logger = reports.createTest("Log in to the Swag Labs Application");
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.loginToSwagLabs(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login Success");

	}

}
