package pkg_PageOR;

import org.openqa.selenium.By;

public interface LogoutPageObjects {
	
	By OSD_Logout = By.xpath("//a[text()=' Log Out  ']");
	By OSD_Logout_Ok = By.xpath("//button[@class=\"p-element p-button p-component\"][1]");
	By OSD_Logout_Cancel = By.xpath("//button[@class=\"p-element p-button p-component\"][2]");

}
