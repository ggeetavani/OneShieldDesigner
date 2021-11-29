package pkg_TestSuit;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import pkg_Base.AppBase;
import pkg_PageOR.SignInPageObjects;
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

public class InvalidSignInValidation extends AppBase implements SignInPageObjects{
	
	ExtentReports report;
	ExtentTest logger;
	
	
	@Test(dataProviderClass=pkg_Utility.SignInInputDataProvider.class, dataProvider = "dp_negativedata" ) 
	public void TC02NegativelLogin(String testcase, String usr, String pwd) throws IOException, InterruptedException {
		String errMsg;
		if (testcase.equalsIgnoreCase("TC02_BlankUsernamecheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			errMsg=SignInPageMethods.invaliduserernamelogin(usr);
			Assert.assertEquals(errMsg, OSD_login_blank_field_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}
		if (testcase.equalsIgnoreCase("TC03_BlankPasswordcheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			errMsg=SignInPageMethods.invalidpasswordlogin(usr, pwd);
			Assert.assertEquals(errMsg, OSD_login_blank_field_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}
		if (testcase.equalsIgnoreCase("TC04_InvalidUsernameCheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			//errMsg=SignInPageMethods.invaliduserernamelogin(usr);
			//SignInPageMethods.invaliduserernamelogin(usr);
			errMsg=SignInPageMethods.invalidpasswordlogin2(usr, pwd);
			Assert.assertEquals(errMsg, OSD_login_blank_invalid_environment_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}
		if (testcase.equalsIgnoreCase("TC05_InvalidPasswordCheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			errMsg=SignInPageMethods.invalidpasswordlogin2(usr, pwd);
			Assert.assertEquals(errMsg, OSD_login_blank_invalid_environment_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}
		if (testcase.equalsIgnoreCase("TC06_SpecialCharUsernameCheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			errMsg=SignInPageMethods.invalidpasswordlogin2(usr,pwd);
			Assert.assertEquals(errMsg, OSD_login_blank_invalid_environment_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}
		if (testcase.equalsIgnoreCase("TC07_SpecialCharPasswordCheck")) {
			logger = report.startTest(testcase);
			logger.log(LogStatus.INFO, "User is login with username " + usr + " and password " + pwd);
			errMsg=SignInPageMethods.invalidpasswordlogin2(usr, pwd);
			Assert.assertEquals(errMsg, OSD_login_blank_invalid_environment_errmsg_txt);
			logger.log(LogStatus.PASS, testcase + " test passed");
			logger.log(LogStatus.PASS, logger.addScreenCapture(captureScreenshot(testcase, driver)));
		}

	}
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getName() + " :test_failed");
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
	  
		report = new ExtentReports(userDir + "//OutputReport//OSDSignInNegativeInExecutionReport"+time+".html", false);
		setBrowser("Chrome");
		launch();
	}
  @AfterTest
  public void afterTest() {

		report.flush();
		report.close();

	}
}
