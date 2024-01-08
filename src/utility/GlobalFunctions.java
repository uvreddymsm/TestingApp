package utility;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;




public class GlobalFunctions extends ReportManager{
	
///	public static WebDriver driver;
	public static Map<String, String> data;
	static public final int DRIVER_IMPLICIT_WAIT = 20;
    static public final int PAGE_LOAD_WAIT = 30;
    static public final int Element_LOAD_WAIT = 20;
    public String fileInput;
    public static String inputfield;
    public static String ScroolBarStatus;
    public static String textbox;
	private static Object Static;
   
	public  By getLocator(String input){
			  By value = null;
			  if(input.startsWith("XPH::"))
				  value = By.xpath(input.substring(5));
			  if(input.startsWith("ID::"))
				  value = By.id(input.substring(4));
			  if(input.startsWith("LT::"))
				  value = By.xpath(input.substring(4));
			  if(input.startsWith("PLT::"))
				  value = By.xpath(input.substring(5));
			  if(input.startsWith("CSS::"))
				  value = By.cssSelector(input.substring(5));
			  if(input.startsWith("CLASSNAME::"))
				  value = By.xpath(input.substring(11));
			  if(input.startsWith("NAME::"))
				  value = By.xpath(input.substring(6));
			  if(input.startsWith("TGN::"))
				  value = By.xpath(input.substring(5));
			
			  return value;
			  
			 
			  
		  }
	
	
	
	/** Method Deals To Launch Browser  **/
	//    @Parameters("browser")
		 public static WebDriver launchBrowser(WebDriver driver) throws Exception {
			
			 String firefox="firefox";
			 String chrome="chrome";
		     String ie="ie";
		     
		     //   System.setProperty("webdriver.chrome.driver","C:\\Users\\yuvaraju.reddy.Applaud\\Desktop\\chromedriver.exe");
		   //   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Library\\chromedriver.exe");
		    //  System.setProperty("webdriver.chrome.driver","C:\\Users\\Yuvaraju Reddy\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		    // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Library\\chromedriver.exe");	
		     System.setProperty("webdriver.ie.driver","E:\\\\Workspace\\\\AppLaud\\\\Library\\\\chromedriver.exe");
		     System.setProperty("webdriver.chrome.driver", "./Library/chromedriver.exe");
		        
		        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Library\\geckodriver.exe");
				
				if(firefox.equals(launchProperties("browser"))){
					  driver=new FirefoxDriver();
					  driver.manage().window().maximize();
				
					  
				  }
			   else if(chrome.equals(launchProperties("browser"))) {
				   ChromeOptions options = new ChromeOptions();
				   options.addArguments("disable-infobars");
				  
				   
				   // add parameter which will disable the extension
				 //  options.addArguments("--disable-extensions");
					driver=new ChromeDriver(options);
			    	driver.manage().window().maximize(); 
				
					//waitForPageToLoad( driver);
				}
			   else if(ie.equals(launchProperties("browser"))) {
					driver=new InternetExplorerDriver();
					driver.manage().window().maximize();
					
					//waitForPageToLoad( driver);
				}
				return driver;
	  }
	    
    /** Method Deals To Open URL Browser  **/
		 public static WebDriver openUrl(WebDriver driver, String url) throws Exception{
			 driver.get(launchProperties(url));
			 waitForPageToLoad( driver);
			 return driver;
		  }
		 
		 public static WebDriver launchUrl(WebDriver driver, String url) throws Exception{
			 driver.get(url);
			 waitForPageToLoad( driver);
			 
			 return driver;  
		  }
		 
		 public static String launchProperties(String prop){
				
			  
		     Properties properties = new Properties();
		   try{
			   
			
			  //   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
			   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\ConfigFiles\\Config.properties");

			   properties.load(fileInput);
			
		      }catch(Exception e){
			      e.printStackTrace();
		     }
		
		         return properties.getProperty(prop);
	}
		 
		 
		 /** Method Deals To WaitForPageToLoad **/
		 public static WebDriver waitForPageToLoad(WebDriver driver) {
				
				
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        String command = "return document.readyState";
		        try {
		            for (int i = 0; i < PAGE_LOAD_WAIT; i++) {
		            	
		            	
		            	Thread.sleep(1000);
		                
		                if (js.executeScript(command).toString().equals("complete")) {
		                    break;
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				return driver;
		    }
		 /** This Method is used to get Current System Date & Time **/
	      
	      public static String getTime(){
	    	  
	    	  DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
			  Date d=new Date();
			  String time=df.format(d);
			return time;
	      }
}
		