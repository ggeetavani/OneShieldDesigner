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

	static Alert alert = null;

	private static void setusername(String usr) {
		driver.findElement(OSDesigner_login_username).clear();
		driver.findElement(OSDesigner_login_username).sendKeys(usr);
	}

	private static void setpassword(String pwd) {
		driver.findElement(OSDesigner_login_password).clear();
		driver.findElement(OSDesigner_login_password).sendKeys(pwd);
	}

	private static void setenvironment(String env) {
		// driver.findElement(OSDesigner_login_environment).clear();
		driver.findElement(OSDesigner_login_envarrow).click();
		// driver.findElement(OSDesigner_login_environment).clear();

		//WebElement env_text_elm = driver.findElement(OSDesigner_login_environment);
		//env_text_elm.click();

		List<WebElement> envlists = driver.findElements(OSDesigner_login_env_value);
		System.out.println(envlists.size());
		for (WebElement envElm : envlists) {
			String env_str = envElm.getText();
			if (env_str.equals(env)) {

				envElm.click();
				break;
			}
		}
	}

	private static void setloginbtn() {
		driver.findElement(OSDesigner_login_loginbtn).click();

	}

	private static void setrole() {

		driver.findElement(OSDesigner_login_rolearrow).click();
		driver.findElement(OSDesigner_login_role).click();
		// driver.switchTo().activeElement().click();
		// driver.findElement(OSDesigner_login_role).sendKeys("SYSTEM",Keys.ARROW_DOWN,Keys.ENTER);
		// driver.findElement(OSDesigner_login_setrole).click();

	}

	private static void setcontinue() {

		driver.findElement(OSDesigner_login_continuebtn).click();
	}

	public static void ValidLogin(String usr, String pwd, String env) {

		setusername(usr);
		setpassword(pwd);
		setenvironment(env);
		setloginbtn();
		setrole();
		setcontinue();
	}

//public static void InValidLogin (String usr, String pwd ) {
//		
//		setusername(usr);
//		setpassword(pwd);
//		setenvironment();
//		setloginbtn();
//}

	public static String invaliduserernamelogin(String usr) throws InterruptedException {
		setusername(usr);
		setloginbtn();
		Thread.sleep(1000);
		alert = driver.switchTo().alert();
		String actualErrorMsg = alert.getText();
		alert.accept();
		return actualErrorMsg;
	}

	public static String invalidpasswordlogin(String usr, String pwd) throws InterruptedException {
		setusername(usr);
		setpassword(pwd);
		setloginbtn();
		Thread.sleep(1000);
		alert = driver.switchTo().alert();
		String actualErrorMsg = alert.getText();
		alert.accept();
		return actualErrorMsg;
	}

	public static void invaliduserernamelogin1(String usr) throws InterruptedException {
		setusername(usr);
		// setloginbtn();
		Thread.sleep(1000);
		// alert = driver.switchTo().alert();
		// String actualErrorMsg=alert.getText();
		// alert.accept();
		// return actualErrorMsg;
	}

	public static String invalidpasswordlogin2(String usr, String pwd) throws InterruptedException {
		setusername(usr);
		setpassword(pwd);
		setloginbtn();
		Thread.sleep(1000);
		String msg = driver.findElement(OSDesigner_login_environmenterr).getText();
		driver.findElement(OSDesigner_login_envrerrorok).click();
		return msg;
	}

}