package pkg_TestSuit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pkg_Base.AppBase;

import pkg_SubScript.SignInPageMethods;
import pkg_SubScript.LogoutMethods;
import pkg_SubScript.OSDLandingMethods;

public class LogoutValidation extends AppBase{
	
	ExtentReports report;
	ExtentTest logger;
	
  @Test
   
	  public void TC01PositiveLogout() throws IOException {
	  
		  String testcase ="TC01_Log_Out" ;
		  logger = report.startTest(testcase);
		  logger.log(LogStatus.INFO, "User logged out");
		  LogoutMethods.logoutcancel();
		  Assert.assertTrue(OSDLandingMethods.checksignin());
		  logger.log(LogStatus.PASS, testcase+" Test Passed");
		  logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));	  
	  
		 
}
  
  @Test
  
  public void TC02PositiveLogout() throws IOException {
  
	  String testcase ="TC02_Log_Out" ;
	  logger = report.startTest(testcase);
	  logger.log(LogStatus.INFO, "User logged out");
	  LogoutMethods.logoutok();
	  String expected1 ="OsDesignerApp";
	  Assert.assertEquals(driver.getTitle(), expected1);
	  logger.log(LogStatus.PASS, testcase+" Test Passed");
	  logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));	  
  
	 
}
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if (result.getStatus()==ITestResult.FAILURE){
		  logger.log(LogStatus.FAIL, result.getName() +": Test Fail");
		  logger.log(LogStatus.ERROR, result.getThrowable());
		  logger.log(LogStatus.FAIL, logger.addScreenCapture(captureScreenshot(result.getName(), driver)));
	  }
	  report.endTest(logger);
	  
  }
  
  @BeforeTest()
  public void beforeTest() {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
      Date date = new Date();
      // System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

      String time = dateFormat.format(date);
	  report = new ExtentReports(userDir+"//OutputReport//OSDLogoutExecutionReport"+time+".html", true);
	  setBrowser("chrome");
	  launch();
	  SignInPageMethods.ValidLogin("gvani", "Oneshield@21","Designer QA (QADD)");
	  //LogoutMethods.clicklogout();
  }
  
  @AfterTest
  public void afterTest() {
	  
	  report.flush();
	  report.close();
	  
  }

}
