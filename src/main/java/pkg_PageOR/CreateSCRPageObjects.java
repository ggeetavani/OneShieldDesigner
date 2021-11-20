package pkg_PageOR;

import org.openqa.selenium.By;

public interface CreateSCRPageObjects {
	
	//Input values for scrname, description, tickect id
	
	By OSDesigner_Create_SCRname = By.xpath("//input[@name='scrName']");
	By OSDesigner_Create_SCRDescription= By.xpath("//input[@name='scrDescription']");
	By OSDesigner_Create_TicketID = By.xpath("//input[@name='ticketID']");
	By OSDesigner_Create_DevelopmentTypeID = By.xpath("//input[@name='developmentTypeID']"); //developmentTypeID
	By OSDesigner_Create_ScrStatusID = By.xpath("//input[@name='scrStatusID']");           // scrStatusID
	By OSDesigner_Create_RepositoryID = By.xpath("//input[@name='developmentRepositoryID']"); //developmentRepositoryID
	By OSDesigner_Create_AssigneeID = By.xpath("//input[@name='mapiUserID']");           //AssigneeID
	By OSDesigner_Create_Group = By.xpath("//input[@name='mapiGroupID']");					// Group
	
	By OSDesigner_Create_isProductScr = By.xpath("//input[@name='isProductScr']");   // Is product checkbox
	By OSDesigner_Create_SCRProductId = By.xpath("//input[@name='scrProductID']");  // Input product
	By OSDesigner_Create_scrFilingID = By.xpath("//input[@name='scrFilingID']"); //scrFilingID
	By OSDesigner_Create_SCRSavebtn = By.xpath("//span[@id='button-1987-btnInnerEl']");  // Savebtn
	By OSDesigner_Create_Savemsg =  By.xpath("//div[@id='VwMessagePopup-2167']");  //save alert msg
	
}
