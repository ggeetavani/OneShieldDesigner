package pkg_SubScript;

import pkg_Base.AppBase;
import pkg_PageOR.LogoutPageObjects;


public class LogoutMethods extends AppBase implements LogoutPageObjects  {
	
	public static void logoutcancel () {
		
		driver.findElement(OSD_Logout).click();
		driver.findElement(OSD_Logout_Cancel).click();
	}
	
	public static void logoutok () {
		
		driver.findElement(OSD_Logout).click();
		driver.findElement(OSD_Logout_Ok).click();
	}

}
