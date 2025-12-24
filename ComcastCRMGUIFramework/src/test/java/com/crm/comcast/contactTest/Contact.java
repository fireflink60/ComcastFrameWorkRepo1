package com.crm.comcast.contactTest;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JasonUtility;
import com.comcast.crm.generic.fileutility.XlUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.crm.comcast.basetest.Basetest;

public class Contact  extends Basetest {
	JavaUtility jt=new JavaUtility();
	String actualdate = jt.actualDate() ;
	String after=jt.afterDate(30);

	 
	String afterDate = jt.beforeDate(30);

 
	 JasonUtility j=new JasonUtility();
	 int randomInt=jt.randomnumber();
	 XlUtility x=new XlUtility();
 
	
	
	      @Test(groups = "SmokeTest")
	    public void createContact() throws IOException, ParseException {
	    	     System.out.println("create contact");
	    	     
	    	      
	    		  String orgname=	 x.getDataFromExcelFile(0, 7, 2)+randomInt;
	    		String lastname =  x.getDataFromExcelFile(0, 7,3) + randomInt;
	    		    

	    			w.findElement(By.xpath("//a[text()='Contacts']")).click();
	    			w.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

	    			w.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	    			 
	    			   
	    			 
	    			w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    }
	    
	    
	    
	     @Test(groups = "RegressionTest")
	      public void createContactwith_Date() throws IOException, ParseException {
	    	  System.out.println("created contact with date");
	    	  String orgname=	 x.getDataFromExcelFile(0, 7, 2)+randomInt;
	    		String lastname =  x.getDataFromExcelFile(0, 7,3) + randomInt;
	    		    

	    			w.findElement(By.xpath("//a[text()='Contacts']")).click();
	    			w.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

	    			w.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	    			String parent=w.getWindowHandle();
	    			  
	    			    
	    			w.findElement(By.xpath("//input[@name='support_end_date']")).clear();
	    			   w.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(after);
	    			   w.findElement(By.xpath("//input[@name='support_start_date']")).clear();
	    			   w.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(actualdate);
	    			   
	    			 
	    			w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	      }
	          
	
	
	
	 
}
