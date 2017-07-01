package com.githubauto.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitingTest {
	
	@Test
	public void  verifySimilarMovieDetails() {
		WebDriver driver = WebdriverBuilder.getDriver();
		
		driver.get("https://play.google.com/store/movies"
				+ "/details/Into_The_Wild?id=WydJ1w31OEI");
		
		WebElement titleEle = driver.findElement(By.cssSelector("h1.document-title"));
		Assert.assertEquals("Into The Wild", titleEle.getText());
		
		WebElement element = driver.findElements(By.cssSelector(".rec-cluster .card")).get(0);
		element.click();
				 		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[text() = 'Wild']")));
		
		titleEle = driver.findElement(By.cssSelector("h1.document-title"));
		
		Assert.assertEquals("Wild", titleEle.getText());
		
/*		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
