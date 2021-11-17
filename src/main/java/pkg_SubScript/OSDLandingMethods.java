package pkg_SubScript;

import pkg_Base.AppBase;
import pkg_PageOR.OSDLandingObjects;

public class OSDLandingMethods extends AppBase implements OSDLandingObjects{

public static boolean checksignin(){
		
		return driver.findElement(OSD_dashboard_General_Development_Dashboard).isDisplayed();
	}

}
