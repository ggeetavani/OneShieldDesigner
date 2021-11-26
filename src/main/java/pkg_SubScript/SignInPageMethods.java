package pkg_SubScript;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private static void setenvironment() throws InterruptedException  {
		driver.findElement(OSDesigner_login_environment).clear();
		driver.findElement(OSDesigner_login_environment).click();
		driver.findElement(OSDesigner_login_environment).sendKeys("Designer QA");
		Thread.sleep(5000);
		
		
		
		
		
	}
	private static void setloginbtn() {
		driver.findElement(OSDesigner_login_loginbtn).click();
		
	}
	private static void setrole() {
		
		
		driver.findElement(OSDesigner_login_role).click();
		//driver.switchTo().activeElement().click();
		driver.findElement(OSDesigner_login_role).sendKeys("SYSTEM",Keys.ARROW_DOWN,Keys.ENTER);
		//driver.findElement(OSDesigner_login_setrole).click();
		
		
		
		
	}
	private static void setcontinue() {
	
		driver.findElement(OSDesigner_login_continuebtn).click();
	}
	
	public static void ValidLogin (String usr, String pwd ) {
		
		setusername(usr);
		setpassword(pwd);
		
			try {
				setenvironment();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		setloginbtn();
		
			setrole();
		
		
		setcontinue();
}
}