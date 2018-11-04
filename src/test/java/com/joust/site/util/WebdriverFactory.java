package com.joust.site.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebdriverFactory {

	// final static String CONFIG_PROPERTIES_DIRECTORY =
	// "properties\\config.properties";

	final String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/webdrivers/mac/geckodriver";
	final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/webdrivers/mac/chromedriver";
	final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/webdrivers/windows/IEDriverServer";

	protected static WebDriver webdriver;

	public WebDriver getDriver() {
		return webdriver;
	}
	
	public void initializeDriver() {
		try {

			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "/resources/config/config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");
			String osName = p.getProperty("OS");

			String gecko_driver_directory="";
			String chrome_driver_directory="";
			String ie_driver_directory="";
			
			switch (osName) {
				case "Windows":
					gecko_driver_directory = System.getProperty("user.dir") + "/resources/webdrivers/windows/geckodriver.exe";
					chrome_driver_directory = System.getProperty("user.dir") + "/resources/webdrivers/windows/chromedriver.exe";
					ie_driver_directory = System.getProperty("user.dir") + "/src/test/resources/webdrivers/windows/IEDriverServer.exe";
				break;
				case "Mac":
					gecko_driver_directory = System.getProperty("user.dir") + "/resources/webdrivers/mac/geckodriver";
					chrome_driver_directory = System.getProperty("user.dir") + "/resources/webdrivers/mac/chromedriver";
					ie_driver_directory = System.getProperty("user.dir") + "/resources/webdrivers/mac/IEDriverServer";
				break;
			}

			switch (browserName) {

			case "firefox":
				if (null == webdriver) {
					System.setProperty("webdriver.gecko.driver", gecko_driver_directory);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					webdriver = new FirefoxDriver();
					webdriver.manage().window().maximize();
				}
				break;

			case "chrome":
				if (null == webdriver) {
					System.setProperty("webdriver.chrome.driver", chrome_driver_directory);
					// CHROME OPTIONS
					webdriver = new ChromeDriver();
					webdriver.manage().window().maximize();
				}
				break;

			case "ie":
				if (null == webdriver) {
					// DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", ie_driver_directory);
					// capabilities.setCapability("ignoreZoomSetting", true);
					webdriver = new InternetExplorerDriver();
					webdriver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
	}
}
