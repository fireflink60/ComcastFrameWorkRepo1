package com.comcast.crm.generic.contacttest;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;

public class Practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   WebDriver w=new ChromeDriver();
		   w.manage().window().maximize();
			  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		     w.get("https://www.flipkart.com/");
		     
		     
		     
		     List<WebElement>l=  w.findElements(By.xpath("//a"));
		      for(WebElement k:l) {
		    	    String s=k.getAttribute("href");
		    	        if(s==null || s.isEmpty()) {
		    	        	System.out.println("we cant check");
		    	        	 continue;
		    	        	 
		    	        }
		    	        URL r=new URL(s);
		    	        HttpsURLConnection c=(HttpsURLConnection) r.openConnection();
		    	         c.connect();
		    	          if(c.getResponseCode()>=400) {
		    	        	  System.out.println(s+" "+c.getResponseCode() +"it is a broken link"+c);
		    	          } 
		    	          else {
		    	        	  System.out.println(s+" "+c.getResponseCode() +"it is not  a broken link"+c);
		    	          }
		    	        
		    	  
		    	  
		      }
		         
		   
		   
		 //a

	}

}
