package pkg_TestSuit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import pkg_SubScript.CreateSCRPageMethods;
import pkg_SubScript.OSDLandingMethods;
import pkg_SubScript.SignInPageMethods;

public class CreateSCRValidation extends AppBase {
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test(dataProviderClass=pkg_Utility.CreateSCRDataProvider.class, dataProvider = "dp_scrpositivedata")
	public void TC01PositiveCreateScr(String testcase, String scrName, String descr, String Id) throws IOException {
		  if (testcase.equalsIgnoreCase("TC01_Positive_CreateScr_check")){
			  logger = report.startTest(testcase);
			  logger.log(LogStatus.INFO, "Scr created  with scrname:" +scrName+ "and description:" +descr);
			  CreateSCRPageMethods.CreateScr(scrName, descr, Id);
			  String expectedresult="Data Saved Successfully";
			  WebElement result = driver.findElement(By.xpath("//div[@id='VwMessagePopup-2167']"));
			  String actualresult = result.getText();
			  Assert.assertEquals(actualresult, expectedresult);
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
		  report = new ExtentReports(userDir+"//OutputReport//OSDCreateScrReport.html", true);
		  setBrowser("chrome");
		  launch();
		  WebElement record = driver.findElement(By.xpath("//span[@id='button-1019-btnInnerEl']"));
		  record.click();
		  //String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebElement create =driver.findElement(By.xpath("//*[@id=\"button-2475-btnInnerEl\"]"));
		create.click();
	  }

	  @AfterTest
	  public void afterTest() {
		  
		  report.flush();
		  report.close();
	  }

	
	

}
