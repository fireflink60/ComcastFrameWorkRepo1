package com.comcast.crm.generic.orgtest;

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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateorgwithIndusrires {

	public static void main(String[] args) throws IOException, NullPointerException {
		// TODO Auto-generated method stub

		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(dateobj);
		String actualdate = actdate;

		Calendar c = sim.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, -30);
		String afterDate = sim.format(c.getTime());

		String path = "./configAppData/Oraganization.properties.txt";
		FileInputStream fis = new FileInputStream(path);

		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");

		Random random = new Random();
		int randomInt = random.nextInt(10000);
		String path1 = "./testScriptData/Orgdata.xlsx";
		FileInputStream fis1 = new FileInputStream(path1);

		Workbook wb = WorkbookFactory.create(fis1);
		Sheet s = wb.getSheetAt(0);
		    Row r=s.getRow(7);
		  String orgname=r.getCell(2).toString()+randomInt;
		String lastname = r.getCell(3).toString() + randomInt;
		String indname=s.getRow(4).getCell(3).toString();
		String type=s.getRow(4).getCell(4).toString();
		
	 

 

		WebDriver w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		w.get(p.getProperty("url"));
		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='text']"))
				.sendKeys(p.getProperty("username"));

		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='password']"))
				.sendKeys(p.getProperty("password"));
		Actions a = new Actions(w);
		a.sendKeys(Keys.ENTER).perform();
		   String p1=w.getWindowHandle();
		
		
	     w.findElement(By.xpath("//a[text()='Organizations']")).click();
	        w.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	        
	        w.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
	        w.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("miryalaguda");
	        
	        WebElement selectwe=  w.findElement(By.xpath("//select[@name='industry']"));
          Select select=new Select(selectwe);
         select.selectByVisibleText(indname);
         WebElement selectwe1=  w.findElement(By.xpath(" //select[@name='accounttype']"));
           Select select1=new Select(selectwe1);
           select1.selectByVisibleText(type);
            
          //select[@name='accounttype']
           
//              w.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
	        
	        
	        w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	}
}