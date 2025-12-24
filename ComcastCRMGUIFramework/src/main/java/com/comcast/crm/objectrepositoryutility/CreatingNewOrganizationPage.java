package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	 
	
	
    @FindBy(name = "accountname")
    WebElement actname;

	public WebElement getActname() {
		return actname;
	}

	public CreatingNewOrganizationPage(WebDriver d) {
		  PageFactory.initElements(d,this);
	}
	
	
	   @FindBy(name="industry")
	   WebElement ind;
	 
     @FindBy(name="ship_street")
     WebElement adress;
     
     @FindBy(css = ".crmbutton.small.save")
     WebElement save;

     

	 public WebElement getAdress() {
		 return adress;
	 }

	  

	 public WebElement getSave() {
		 return save;
	 }
	     
	     public void Details(String Orgname,String adress) {
	    	 
	    	 actname.sendKeys(Orgname);
	    	 this.adress.sendKeys(adress);
	    	 save.click();
	    	 
	     }
	         public void Details(String Orgname,String adress,String industry) {
	        	 actname.sendKeys(Orgname);
	        	 Select s=new Select(ind);
	        	   s.selectByVisibleText(industry);
	        	   this.adress.sendKeys(adress);
	  	    	 save.click();
	        	   
	        	   
	        	   
				
			}

	  
     
     
    
    
    
   


}
