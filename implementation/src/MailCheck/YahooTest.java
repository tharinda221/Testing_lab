package MailCheck;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooTest {

	@Test
	public  void test()throws Exception {
		
		WebDriver driver;
		//WebDriver driver = new ChromeDriver();
		WebDriverWait wait;

		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
			
		wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();
		
		driver.get("https://login.yahoo.com/");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("login-username")).sendKeys("Dishan000001");
		
		driver.findElement(By.name("passwd")).sendKeys("920371230vvvv");
		
		driver.findElement(By.id("login-signin")).sendKeys("LOGIN BUTTON");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.quit();

		
	}

}


