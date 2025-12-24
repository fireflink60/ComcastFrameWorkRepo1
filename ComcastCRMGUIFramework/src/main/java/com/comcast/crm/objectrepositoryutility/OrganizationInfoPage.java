package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInfoPage {
	
	
//	public CreatingNewOrganizationPage(WebDriver d) {
//	  PageFactory.initElements(d,LoginPage.class);
//}
	
	
	
	     
	
	       @FindBy(className = "dvHeaderText")
	       WebElement txt;

		   public WebElement getTxt() {
			   return txt;
		   }
	       
	       
	       

}
