package com.automation.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.Utilities.BrowserFactory;
import com.automation.Utilities.ConfigDataProvider;
import com.automation.Utilities.ExcelDataProvider;
import com.automation.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {

		Reporter.log("Setting up reports and test is getting ready ", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/"
				+ "Screenshot_" + Helper.getCurrentDataTime() + "_SwagLabs.html"));
		reports = new ExtentReports();
		reports.attachReporter(extent);
		Reporter.log("Setting done - test can be started ", true);

	}
	@Parameters({"browser","app_url"})
	@BeforeClass()
	public void setup(String browser,String app_url) {
		Reporter.log("Trying to start the browser and getting application ready ", true);
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getQaUrl());
		 driver = BrowserFactory.startApplication(driver,browser,app_url);
		Reporter.log("Browser and application is Up and running ", true);
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) {
		Reporter.log("Test is about to end ", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		reports.flush();

		Reporter.log("Test completed >> reports generated ", true);
	}

}
