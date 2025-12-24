package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	  
	
	   @FindBy(xpath = "//img[@alt='Create Organization...']")
	      WebElement pulsbtn;
	   
	     @FindBy(name ="search_text")
	       WebElement searchbtn;
	        
	     @FindBy(id = "bas_searchfield")
	        WebElement dropdn;
	     @FindBy(xpath = "//input[@value=' Search Now ']")
	       WebElement submit;
	     
	     

	   public WebElement getSubmit() {
			return submit;
		}



		 public void setSearchbtn(WebElement searchbtn) {
			 this.searchbtn = searchbtn;
		 }



	   public WebElement getDropdn() {
			return dropdn;
		}

		  

	   public WebElement getSearchbtn() {
			return searchbtn;
		}

		 
		   
		   

	   public WebElement getPulsbtn() {
		   return pulsbtn;
	   }

	   public OrganizationPage(WebDriver d) {
		   PageFactory.initElements(d,LoginPage.class);

	   }
	   
	   
	   
	      
	   
}
