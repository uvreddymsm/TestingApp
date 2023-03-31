package module;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchApplication {
	
	public static WebDriver driver;
	
	
	
	@Test
	public void TC1()  {
		// TODO Auto-generated method stub

	
		System.setProperty("webdriver.chrome.driver", "./Library/chromedriver1.exe");
		
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPHONE");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Test Case Executed Completed Buddy");
	}

	@Test
	public void TC2() {

		System.out.println("Test Case Executed Completed Buddy 1");
	}
}
