package com.githubauto.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GithubHomePage {
	
	private WebDriver driver;

	public GithubHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void load() {
		driver.navigate().to("https://github.com/");
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public GithubFeaturesPage gotoFeatures() {
		driver.findElement(By.linkText("Features")).click();
		return new GithubFeaturesPage(driver);
	}
	
	public GithubLoginPage gotoSignIn() {
		// locate sign-in link, click 
		WebElement link = driver.findElement(By.linkText("Sign in"));
		link.click();
		return new GithubLoginPage(this.driver);		
	}

	public GithubSearchResultPage search(String query) {
		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys(query);
		searchInput.sendKeys(Keys.ENTER);
		return new GithubSearchResultPage(driver);
	}
}
