package com.githubauto.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.githubauto.webdriver.WebdriverBuilder;

public class GithubUserHomePage {
	private WebDriver driver;
	
	public GithubUserHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void locateStartButton() {
		this.driver.findElement(By.linkText("Start a project"));
	}
}
