package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtility {

	     
	     public void waitToLoad(WebDriver w,int s) {
	    	   
	    	     w.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
	     }
	        
	        public void switchToWindow(String a,WebDriver w) {
	        	
	        	w.switchTo().window(a);
	        }
	          public void SelectByText(String text,WebElement web) {
	        	 
	        	   Select s=new Select(web);
	        	   s.selectByVisibleText(text);
	          }
	              public void waitForElement(WebElement web,WebDriver w,int s) {
	            	        WebDriverWait w1=new WebDriverWait(w,Duration.ofSeconds(s));
	            	           w1.until(ExpectedConditions.visibilityOf(web));
	            	           
	              }
	              public void SelectByIndex(int index,WebElement web) {
	 	        	 
		        	   Select s=new Select(web);
		        	   s.selectByIndex (index);
		          }
	                  public void alertaccept(WebDriver w) {
	                	       w.switchTo().alert().accept();
	                  }
	                  public void alertDismiss(WebDriver w) {
               	       w.switchTo().alert().dismiss();
                 }
	                  
}
