package com.automation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.automation.Pages.BaseClass;

public class Helper extends BaseClass
{
	public static String captureScreenShot(WebDriver driver)
	{
		String ScreenshotPath =  System.getProperty("user.dir")+"/Screenshots/"+getCurrentDataTime()+"_screenshot.png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 	 
		
		try {
			FileHandler.copy(src,new File(ScreenshotPath));
		} catch (IOException e) {
			System.out.println("Screenshot not found "+e.getMessage());
			e.printStackTrace();
		}
		return ScreenshotPath;
	}
	
	public static String getCurrentDataTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return customformat.format(date);
	}
}
