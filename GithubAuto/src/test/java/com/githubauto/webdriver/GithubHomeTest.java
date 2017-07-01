package com.githubauto.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.githubauto.webdriver.pages.GithubHomePage;
import com.githubauto.webdriver.pages.GithubLoginPage;
import com.githubauto.webdriver.pages.GithubSearchResultPage;
import com.githubauto.webdriver.pages.GithubUserHomePage;

@RunWith(JUnit4.class)
public class GithubHomeTest {
	private WebDriver driver;
	
	public GithubHomeTest() {
		driver = WebdriverBuilder.getDriver();
	}

	@Test
	public void verifyTitleWithoutLogin() {
		GithubHomePage homePage = new GithubHomePage(driver);
		homePage.load();
		String title = homePage.getTitle();		
	}
	
	@Test
	public void verifyTitleLogin() {
		GithubHomePage homePage = new GithubHomePage(driver);
		homePage.load();
		String title = homePage.getTitle();		
	}
	
	@Test
	public void verifySearchResults() {
		GithubHomePage homePage = new GithubHomePage(driver);
		homePage.load();
		GithubSearchResultPage resultsPage = homePage.search("hibernate");
		Assert.assertEquals(10, resultsPage.getResultCount());
		
		//String projectTitle = resultsPage.getProjectTitles().get(0);
		String projectTitle = resultsPage.getResult(0).getProjectTitle();
		Assert.assertEquals("vireshmanagooli/hibernate", projectTitle);
	}	
}
