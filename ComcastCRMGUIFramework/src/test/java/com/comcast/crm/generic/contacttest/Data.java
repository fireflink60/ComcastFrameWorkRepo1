package com.comcast.crm.generic.contacttest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriver w=new ChromeDriver();
		     w.manage().window().maximize();
		  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  w.get("https://demoapps.qspiders.com/ui/table?scenario=1");
//		  List<WebElement>l=w.findElements(By.xpath("//tr"));
//		    
//		   for(WebElement s:l) {
//			     
//			        String text=s.getText();
//			        System.out.println(text);
//		   }
//		  for(int i=0;i<l.size();i++) {
//			     
//		        String text=l.get(i).getText();
//		        System.out.println(text);
//	   }
//		  Iterator<WebElement> it = l.iterator();
//
//		  while (it.hasNext()) {
//		      String text = it.next().getText();
//		      System.out.println(text);
//		  }

		   List<WebElement>l=w.findElements(By.xpath("//td[1]"));
		    
		   for(WebElement s:l) {
			     
			        String text=s.getText();
			        System.out.println(text);
		   }
	          
	           

	}

}
