package co.edurika.sel.wd.basic;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestGetCommands {
	
	WebDriver driver;
		
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			getCommands();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void getCommands() {
		
		try {
			driver.get("http://www.amazon.com");
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of the page is:"+titleOfThePage);
			
			driver.findElement(By.linkText("Today's Deals")).click();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Current URL is: "+currentUrl);
			
			//System.out.println("Current page source: "+ driver.getPageSource());
			
			
			driver.getPageSource();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestGetCommands myobj1 = new TestGetCommands();
		myobj1.invokeBrowser();
		

	}

}
