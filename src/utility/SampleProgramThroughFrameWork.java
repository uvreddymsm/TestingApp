//package utility;
//
//import org.testng.annotations.Test;
//
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import objectrepository.Locators;
//
//public class SampleProgramThroughFrameWork extends ReportManager{
//
//
//	@Test(enabled=false)
//	public void emailLogin() throws Exception {
//
//		test=extent.startTest( "Sample Program Through Framework");
//		driver=	GlobalFunctions.launchBrowser(driver);
//		GlobalFunctions.openUrl(driver,"url");
//		test.log(LogStatus.INFO, "Browser Launched Sucessfully");
////		GlobalFunctions.click(driver, Locators.oneWay);
////		GlobalFunctions.click(driver, Locators.Depature);
////		GlobalFunctions.click(driver, Locators.from);
////		GlobalFunctions.click(driver, Locators.to);
//
//	}
//
//	@Test(enabled=true)
//	public void gmailLogin() throws Exception {
//
//		test=extent.startTest( "Sample Program Through Framework");
//		driver=	GlobalFunctions.launchBrowser(driver);
//		GlobalFunctions.openUrl(driver,"url");
//		test.log(LogStatus.INFO, "Browser Launched Sucessfully");
//		GlobalFunctions.sendkeys(driver, Locators.email, "UserName");
//		GlobalFunctions.click(driver, Locators.next);
//		GlobalFunctions.sendKeysThroughActions(driver, Locators.email, "Pwd");
//		/*String toltip=GlobalFunctions.getToolTip("");
//	    test.log(LogStatus.INFO, "This Is The TopTip We get" + toltip);*/
//
//
//	}
//
//
//}
