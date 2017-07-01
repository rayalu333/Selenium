package co.edurika.sel.wd.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseEleLocTec {

	WebDriver driver;

	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					driver.quit();
				}
			});
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ElementLocatorTecqniques() {
		invokeBrowser("http://www.amazon.com");
		driver.findElement(By.linkText("Gift Cards & Registry")).click();
		System.out.println("this is link text");
		driver.findElement(By.partialLinkText("Registry")).click();
		System.out.println("This is partial link text");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenova Laptops");
		driver.findElement(By.className("nav-input")).click();
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {

		UseEleLocTec obj = new UseEleLocTec();
		obj.ElementLocatorTecqniques();
		System.out.println("final statement");

	}

}
