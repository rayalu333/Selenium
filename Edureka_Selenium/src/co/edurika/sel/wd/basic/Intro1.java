package co.edurika.sel.wd.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Intro1 {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://edureka.co");
			searchCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void searchCourse(){
		try {
			driver.findElement(By.id("search-inp1")).sendKeys("java");
			Thread.sleep(3000);
			driver.findElement(By.id("search-button-bottom")).click();
			jse = (JavascriptExecutor)driver; 
			jse.executeScript("scroll(0, 400)");
			 
			driver.findElement(By.xpath("//label[contains(text(), 'Weekdays')]")).click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intro1 myobj = new Intro1(); 
		myobj.invokeBrowser();
		

	}

}
