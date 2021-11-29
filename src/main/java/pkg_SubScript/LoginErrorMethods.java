package pkg_SubScript;

import pkg_Base.AppBase;
import pkg_PageOR.LoginErrorPage;

public class LoginErrorMethods extends AppBase implements LoginErrorPage {
	
public static boolean checkerrmsg(){
		
		return driver.findElement(OSD_Loginerror).isDisplayed();
	}

}
