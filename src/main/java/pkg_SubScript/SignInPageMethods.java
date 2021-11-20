package pkg_SubScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import pkg_Base.AppBase;
import pkg_PageOR.SignInPageObjects;

public class SignInPageMethods extends AppBase implements SignInPageObjects {
	
	private static void setusername (String usr) {
		driver.findElement(OSDesigner_login_username).clear();
		driver.findElement(OSDesigner_login_username).sendKeys(usr);
	}
	
	private static void setpassword(String pwd) {
		driver.findElement(OSDesigner_login_password).clear();
		driver.findElement(OSDesigner_login_password).sendKeys(pwd);
	}
	private static void setenvironment()  {
		driver.findElement(OSDesigner_login_environment).clear();
		driver.findElement(OSDesigner_login_environment).click();
		driver.findElement(OSDesigner_login_environment).sendKeys("Designer QA");
		//Thread.sleep(100);
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadGrid1_ctl00_ctl02_ctl02_EditFormControl_rcbControllerType1_Input")).sendKeys("ValueTwo", Keys.ARROW_DOWN, Keys.ENTER)
		//driver.manage().timeouts().implicitlyWait(130, TimeUnit.SECONDS);
		//Select environment =new Select(driver.findElement(OSDesigner_login_environment));
		//environment.selectByVisibleText("Designer QA(QADD)");
		
		
	}
	private static void setloginbtn() {
		driver.findElement(OSDesigner_login_loginbtn).click();
		
	}
	private static void setrole() {
		driver.findElement(OSDesigner_login_role).clear();
		Select role= new Select(driver.findElement(OSDesigner_login_role));
		role.selectByVisibleText("SYSTEM");
	}
	private static void setcontinue() {
	
		driver.findElement(OSDesigner_login_continuebtn).click();
	}
	
	public static void ValidLogin (String usr, String pwd ) {
		
		setusername(usr);
		setpassword(pwd);
		setenvironment();
		setloginbtn();
}
}