package com.githubauto.webdriver.pages;

import org.openqa.selenium.WebDriver;

public class GithubFeaturesPage {
	private WebDriver driver;
	
	public GithubFeaturesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
