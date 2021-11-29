package pkg_TestSuit;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pkg_Base.AppBase;
import pkg_PageOR.SignInPageObjects;
import pkg_SubScript.LoginErrorMethods;
import pkg_SubScript.OSDLandingMethods;
import pkg_SubScript.SignInPageMethods;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ValidSignInValidation extends AppBase implements SignInPageObjects{
	ExtentReports report;
	ExtentTest logger;
	
	
	@Test(dataProviderClass=pkg_Utility.SignInInputDataProvider.class, dataProvider = "dp_positivedata" ) 
	  
	  //Calling Data Provider from Other Class
	  public void TC01PositiveLogin(String testcase, String usr, String pwd, String env) throws IOException {
		  if (testcase.equalsIgnoreCase("TC01_Positive_Login_check")){
			  logger = report.startTest(testcase);
			  logger.log(LogStatus.INFO, "User logged in with Username:" +usr+ "and Password:" +pwd);
			  SignInPageMethods.ValidLogin(usr, pwd, env);
			  Assert.assertTrue(OSDLandingMethods.checksignin());
			  logger.log(LogStatus.PASS, testcase+" Test Passed");
			  logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));	  
		  }
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

  @BeforeTest
  public void beforeTest() {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
      Date date = new Date();
      // System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

      String time = dateFormat.format(date);
	  
	  report = new ExtentReports(userDir+"//OutputReport//OSDSignInPositiveInExecutionReport"+time+".html", true);
	  setBrowser("chrome");
	  launch();
  }

  @AfterTest
  public void afterTest() {
	  
	  report.flush();
	  report.close();
	  
  }

}
