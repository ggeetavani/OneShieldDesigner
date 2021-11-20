package pkg_SubScript;

import org.openqa.selenium.support.ui.Select;

import pkg_Base.AppBase;
import pkg_PageOR.CreateSCRPageObjects;

public class CreateSCRPageMethods extends AppBase implements CreateSCRPageObjects{
	
	private static void setscrname (String scr) {
		driver.findElement(OSDesigner_Create_SCRname).clear();
		driver.findElement(OSDesigner_Create_SCRname).sendKeys(scr);
	}
	
	private static void setscrdescr (String descr) {
		driver.findElement(OSDesigner_Create_SCRDescription).clear();
		driver.findElement(OSDesigner_Create_SCRDescription).sendKeys(descr);
	}
	
	private static void setticketid (String id) {
		driver.findElement(OSDesigner_Create_TicketID).clear();
		driver.findElement(OSDesigner_Create_TicketID).sendKeys(id);
	}
	
	private static void setDevelopmentTypeID() {
		driver.findElement(OSDesigner_Create_DevelopmentTypeID).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_DevelopmentTypeID));
		productId.selectByVisibleText("CORE");
	}
	private static void setScrStatusID() {
		driver.findElement(OSDesigner_Create_ScrStatusID).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_ScrStatusID));
		productId.selectByVisibleText("WIP");
	}
	private static void setRepositoryID() {
		driver.findElement(OSDesigner_Create_RepositoryID).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_RepositoryID));
		productId.selectByVisibleText("Designer QA");
	}
	private static void setAssigneeID() {
		driver.findElement(OSDesigner_Create_AssigneeID).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_AssigneeID));
		productId.selectByVisibleText("Gajavelly Geeta Vani");
	}
	
	private static void setGroup() {
		driver.findElement(OSDesigner_Create_Group).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_Group));
		productId.selectByVisibleText("");
	}
	
	
	private static void setIsProduct () {
		driver.findElement(OSDesigner_Create_isProductScr).clear();
		driver.findElement(OSDesigner_Create_isProductScr).click();
	}
	
	private static void setSCRProductId() {
		driver.findElement(OSDesigner_Create_SCRProductId).clear();
		Select productId= new Select(driver.findElement(OSDesigner_Create_SCRProductId));
		productId.selectByVisibleText("All");
	}
	
	private static void setFillingId() {
		driver.findElement(OSDesigner_Create_scrFilingID).clear();
		Select fillingId= new Select(driver.findElement(OSDesigner_Create_scrFilingID));
		fillingId.selectByVisibleText("All");
	}
	
	private static void setsave() {
		
		driver.findElement(OSDesigner_Create_SCRSavebtn).click();
	}
	
	//private static String getmsg()
	//{
		//return driver.findElement(OSDesigner_Create_Savemsg).getText();
		
	//}
	
	public static void CreateScr (String scrName, String descr, String Id) {
		
		setscrname(scrName);
		setscrdescr(descr);
		setticketid(Id);
		setsave();
		
	}
	


}
