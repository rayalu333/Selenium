package com.githubauto.webdriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverBuilder {
	private static WebDriver webDriver;
	
	private static String projectPath = Paths.get(".").toAbsolutePath().normalize().toString();
	
	public static WebDriver getDriver() {		
		if (webDriver == null) {
			
			String requestedBrowser = System.getProperty("browser");
			if ("chrome".equals(requestedBrowser)) { // requestBrowser.equals("chrome")
				webDriver = newChromeDriver();
			} else if ("firefox".equals(requestedBrowser)) {
				webDriver = newFireFoxDriver();
			} else {
				webDriver = newChromeDriver();
			}
			
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					webDriver.quit();
				}
			});
		}
		return webDriver;
	}
	
	private static WebDriver newChromeDriver() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");	
		WebDriver webDriver = new ChromeDriver();
		return webDriver;
	}
	
	private static WebDriver newFireFoxDriver() {	
		System.setProperty("webdriver.gecko.driver", 
				projectPath +"/drivers/geckodriver");
		//System.setProperty("webdriver.firefox.bin", "/path/to/firefox/bin");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		return webDriver;
	}
}
