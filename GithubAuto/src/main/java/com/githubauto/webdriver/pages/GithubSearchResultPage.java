package com.githubauto.webdriver.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GithubSearchResultPage {
	
	private static final By RESULT_LOCATOR = By.cssSelector("div.codesearch-results ul li");
	private static final By TEXT_LOCATOR = By.tagName("h3");
	
	private final WebDriver driver;

	public GithubSearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getResultCount() {
		return driver.findElements(RESULT_LOCATOR).size();
	}
	
	public List<String> getProjectTitles() {
		List<WebElement> resultEles = driver.findElements(RESULT_LOCATOR);		
		List<String> titles = new ArrayList<>();		
		for (WebElement resEle : resultEles) {			
			String title = resEle.findElement(TEXT_LOCATOR).getText();
			titles.add(title);
		}
		return titles;
	}
	
	public Result getResult(int index) {
		WebElement resultEle = driver.findElements(RESULT_LOCATOR).get(index);
		return new Result(resultEle);
	}
	
	public static class Result {
		WebElement resultEle;

		public Result(WebElement resultEle) {
			this.resultEle = resultEle;
		}
		
		public String getProjectTitle() {
			return resultEle.findElement(TEXT_LOCATOR).getText();
		}
	}
}
