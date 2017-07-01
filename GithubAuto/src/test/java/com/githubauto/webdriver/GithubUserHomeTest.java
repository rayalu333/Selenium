package com.githubauto.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

import com.githubauto.webdriver.pages.GithubHomePage;
import com.githubauto.webdriver.pages.GithubLoginPage;
import com.githubauto.webdriver.pages.GithubUserHomePage;

@RunWith(JUnit4.class)
public class GithubUserHomeTest {
	private WebDriver driver;
	private GithubUserHomePage userHome;
	
	public GithubUserHomeTest() {
		driver = WebdriverBuilder.getDriver();
	}
	
	@Before
	public void anotherBefore() {
		System.out.println(">>>Another before method");
	}
		
	@Before
	public void setup() {	
		System.out.println("Run preconditions");		
		GithubHomePage homePage = new GithubHomePage(driver);
		homePage.load();
		GithubLoginPage loginPage = homePage.gotoSignIn();
		userHome = loginPage.login("wipauto123", "Github123$");
	}
	
	@After
	public void afterTest() {
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void verifyStartButtonExists() {
		userHome.locateStartButton();
	}
	
	@Test
	public void verifySignIn() {
		userHome.locateStartButton();
	}
	
}
