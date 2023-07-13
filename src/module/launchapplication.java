package module;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class launchapplication {
	
	public static WebDriver driver;
	
	
	
	@Test
	public void TC1()  {
		// TODO Auto-generated method stub

	
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		
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
