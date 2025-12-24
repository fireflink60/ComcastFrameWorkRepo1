package com.comcast.crm.objectrepositoryutility;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	 WebDriver d=null;
	
	
	      @FindBy(linkText = "Organizations")
	        WebElement orgbtn;
	         
	   @FindBy(css = "img[src='themes/softed/images/user.PNG' ]")
	     WebElement movetoLogout;
	   
	   @FindBy(linkText = "Sign Out")
	    WebElement signoutbtn;

		  public WebElement getOrgbtn() {
			return orgbtn;
		}



		  public HomePage(WebDriver d) {
			  this.d=d;
			  PageFactory.initElements(d,this);
		  }
		     
		     public void logOut() {
		    	 Actions a=new Actions(d);
		    	    a.moveToElement(movetoLogout).perform();
		    	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		    	    wait.until(ExpectedConditions.visibilityOf(signoutbtn));

		    	    signoutbtn.click();
		    	 
		    	 
		     }
	      
	          

}
