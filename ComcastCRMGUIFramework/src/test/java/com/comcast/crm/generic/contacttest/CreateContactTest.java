package com.comcast.crm.generic.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JasonUtility;
import com.comcast.crm.generic.fileutility.XlUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws IOException, NullPointerException, ParseException {
		// TODO Auto-generated method stub

		JavaUtility jt=new JavaUtility();
		String actualdate = jt.actualDate() ;
		String after=jt.afterDate(30);

		 
		String afterDate = jt.beforeDate(30);

		 FileUtility f=new FileUtility();
		 JasonUtility j=new JasonUtility();
	   
		String url = f.getDataFromPropertiesFile("url");
		String username = f.getDataFromPropertiesFile("username");
		String password = f.getDataFromPropertiesFile("password");

	 int randomInt=jt.randomnumber();
		 XlUtility x=new XlUtility();
	 
		  String orgname=	 x.getDataFromExcelFile(0, 7,2 )+randomInt;
		String lastname =  x.getDataFromExcelFile(0, 7,3) + randomInt;
		
	 

 

		WebDriver w = new ChromeDriver();
		  WebDriverUtility webd=new WebDriverUtility();
		  
         webd.waitToLoad(w,15);
		w.get(url);
		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='text']"))
				.sendKeys(username);

		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='password']"))
				.sendKeys(password);
		Actions a = new Actions(w);
		a.sendKeys(Keys.ENTER).perform();
		   String p1=w.getWindowHandle();
		
	 
		

		w.findElement(By.xpath("//a[text()='Contacts']")).click();
		w.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		w.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		String parent=w.getWindowHandle();
		  
		    
		w.findElement(By.xpath("//input[@name='support_end_date']")).clear();
		   w.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(after);
		   w.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		   w.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(actualdate);
		   
		 
		w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		
//		WebElement w2 = w.findElement(By.id("dtlview_Support End Date"));
//		   a.scrollToElement(w2).perform();
//		   
//		String text = w2.getText();
//		System.out.println(text);
//        System.out.println(afterDate);
//		if (text.equals(afterDate)) {
//			System.out.println(text + "date created");
//		} else {
//			System.out.println("not created");
//		}
//
//	}

}
}