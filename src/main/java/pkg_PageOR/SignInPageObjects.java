package pkg_PageOR;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;

public interface SignInPageObjects {
	
    // Input of user name, password and select environment
	
	//By OSDesigner_login_username = By.xpath("//*[@id=\"textfield-1018-inputEl\"]");
	
	By OSDesigner_login_username = By.xpath("//*[@name='username']");
	By OSDesigner_login_password = By.xpath("//*[@id=\"textfield-1019-inputEl\"]");
	By OSDesigner_login_environment = By.xpath("//*[@name='environment']");
	//By OSDesigner_login_environment = By.
	By OSDesigner_login_loginbtn = By.xpath("//*[@id=\"button-1021-btnInnerEl\"]"); 
	
	// selecting role on login page
	
	By OSDesigner_login_role = By.xpath("//*[@name='roleCB']");
	By OSDesigner_login_setrole = By.xpath("//li[contains(text(),'Designer Administrator')]");
	By OSDesigner_login_continuebtn = By.linkText("Continue");
	//By OSDesigner_login_continuebtn = By.xpath("//*[@id='button-1028-btnIconEl']");

	
	
}
