package com.automation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.automation.Pages.BaseClass;

public class ConfigDataProvider extends BaseClass {

	Properties properties;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("File not found " + e.getMessage());
			e.printStackTrace();
		}

	}

	public String getDatafromConfig(String keyToSearch) {
		return properties.getProperty(keyToSearch);
	}

	public String getBrowser() {

		return properties.getProperty("Browser");

	}

	public String getQaUrl() {

		return properties.getProperty("QaUrl");

	}

}
