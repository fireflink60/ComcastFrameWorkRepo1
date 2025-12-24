package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	   
	public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver>d=new ThreadLocal<WebDriver>();
	 
	public static ExtentTest getTest() {
		 return test.get();
	}
	    public static void setText(ExtentTest actText) {
	    	test.set(actText);
	    }
	      public static WebDriver getDriver() {
	    	  return d.get();
	      }
	
	      public static void setDriver(WebDriver actDriver) {
	    	  d.set(actDriver);;
	      }
}
