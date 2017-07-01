package co.edurika.sel.wd.basic;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestNavigateCommands {
	
	WebDriver driver;
	
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			naviComm();
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void naviComm() {
		
		try {
			//driver.get("http://www.amazon.com");
			driver.navigate().to("http://www.amazon.com");
			Thread.sleep(3000);
			driver.findElement(By.id("nav-your-amazon")).click();
			String CurrentUrl = driver.getCurrentUrl();
			System.out.println("current url is" +CurrentUrl);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.navigate().back();
			System.out.println("URL after navigating back"+ driver.getCurrentUrl());
			driver.navigate().forward();
			System.out.println("URL after forwarding back"+ driver.getCurrentUrl());
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	public static void main(String[] args) {
		
		TestNavigateCommands myobj1 = new TestNavigateCommands();
		
		myobj1.invokeBrowser();	
		
		
	}

}
