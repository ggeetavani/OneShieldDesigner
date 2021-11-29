package pkg_PageOR;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;

public interface SignInPageObjects {
	
    // Input of username, password and select environment
	//By OSDesigner_login_username = By.xpath("//*[@id=\"textfield-1018-inputEl\"]");
	By OSDesigner_login_username = By.xpath("//input[@ng-reflect-name='userName']");
	By OSDesigner_login_password = By.xpath("//input[@ng-reflect-name='password']");
	By OSDesigner_login_envarrow = By.xpath("//span[@ng-reflect-ng-class='pi pi-chevron-down']");
	//By OSDesigner_login_environment = By.xpath("//p-dropdown[@ng-reflect-name='environment']");
	//By OSDesigner_login_environment = By.xpath("//*[@id=\"pr_id_2_list\"]/p-dropdownitem[44]/li");
	By OSDesigner_login_environment = By.xpath("//input[@placeholder='Environment']");
	By OSDesigner_login_env_value =By.xpath("//div/ul[@role='listbox']//li");
	
	By OSDesigner_login_loginbtn = By.xpath("//button[@ng-reflect-label='Log in']"); 
	
	// selecting role on login page
	By OSDesigner_login_rolearrow =By.xpath("//span[contains(text(),'Select Role')]");
	By OSDesigner_login_role = By.xpath("//*[@id=\"pr_id_4_list\"]/p-dropdownitem/li");
	//By OSDesigner_login_setrole = By.xpath("//li[contains(text(),'SYSTEM')]");
	By OSDesigner_login_continuebtn = By.xpath("//button[@ng-reflect-label='Continue']");
	By OSDesigner_login_environmenterr =By.xpath("//div[@class='error-message']");
	By OSDesigner_login_envrerrorok =By.xpath("//button[@label='OK']");
	//By OSDesigner_login_continuebtn = By.xpath("//*[@id='button-1028-btnIconEl']");

	
	//Expected Error Message
	String OSD_login_blank_field_errmsg_txt = "Please enter a valid username and password";
	String OSD_login_invalid_field_errmsg_txt = "The Dragon username/password combination provided is not correct. Please re-enter the username/password.";
	String OSD_login_blank_invalid_environment_errmsg_txt = "Environment data source is not set properly";
	String OSD_login_blank_role_errmsg_txt = "Please select a role";
	
		
}
