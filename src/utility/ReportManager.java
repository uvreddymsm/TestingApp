package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class ReportManager extends GlobalObjects{
    protected static ExtentReports extent;
    protected static ExtentTest test;
//    protected WebDriver driver;
    String time=GlobalFunctions.getTime();
  

    @AfterMethod
    protected void  afterMethod( ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable().getMessage()+ "</pre>");
           
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
     
        extent.endTest(test);     
        extent.flush();
        
		
    }
    
    @BeforeSuite
    public void beforeSuite() {
    	
    	 if (extent == null) {
    
    		
    		String time=GlobalFunctions.getTime();
  
 //   extent = new ExtentReports(System.getProperty("user.dir")+"\\Data\\"+ "\\Report Manager\\"+"CA Tracker"+time+".html", true);
    extent = new ExtentReports(System.getProperty("user.dir")+"\\Data\\"+ "\\Report Manager\\"+"SpiceJetMorning"+time+".html", true);
    //   
	 extent.config()
     .documentTitle("AppLaudGS")
     .reportName("AppLaudGS Automation Reports");
	 extent
	 .addSystemInfo("Host Name", "Yuvaraju Reddy")
     .addSystemInfo("Environment", "QA");
                         }
    
    }
    
    @AfterSuite
    protected void afterSuite() throws Exception {
        extent.close();
       // driver.quit();
    //	GlobalFunctions.sendEmail(driver);
    }
    
    
}
