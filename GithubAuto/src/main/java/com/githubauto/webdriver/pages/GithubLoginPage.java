package com.githubauto.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GithubLoginPage {
	private WebDriver driver;
	
	public GithubLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public GithubUserHomePage login(String username, String password) {
		driver.findElement(By.name("login")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();	
		return new GithubUserHomePage(driver);
	}
}
