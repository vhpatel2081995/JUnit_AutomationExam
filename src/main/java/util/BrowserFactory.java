package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
 
	static WebDriver driver;
	
	
	
	public static WebDriver initDriver() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return driver;
	}
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
