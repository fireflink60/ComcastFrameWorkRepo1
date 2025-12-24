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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

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
		int randomInt = random.nextInt(800000);
		String path1 = "./testScriptData/Contacts.xlsx";
		FileInputStream fis1 = new FileInputStream(path1);

		Workbook wb = WorkbookFactory.create(fis1);
		Sheet s = wb.getSheetAt(0);
		Row r = s.getRow(7);
		String orgname = r.getCell(2).toString() + randomInt;
		String lastname = r.getCell(3).toString() + randomInt;

		WebDriver w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		w.get(p.getProperty("url"));
		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='text']"))
				.sendKeys(p.getProperty("username"));

		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='password']"))
				.sendKeys(p.getProperty("password"));
		Actions a = new Actions(w);
		a.sendKeys(Keys.ENTER).perform();
		String p1 = w.getWindowHandle();

		w.findElement(By.xpath("//a[text()='Organizations']")).click();
		w.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		w.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		w.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("miryalaguda");
		w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		WebElement w3 = w.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG' ]"));
		a.moveToElement(w3).perform();
		w.findElement(By.linkText("Sign Out")).click();

		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='text']"))
				.sendKeys(p.getProperty("username"));

		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='password']"))
				.sendKeys(p.getProperty("password"));
		Actions a1 = new Actions(w);
		a1.sendKeys(Keys.ENTER).perform();

//	  WebElement   Web1=   w.findElement(By.xpath("//a[text()='Contacts']"));
//	      a.moveToElement(Web1).perform();

		w.findElement(By.xpath("//a[text()='Contacts']")).click();
		w.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		w.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		String parent = w.getWindowHandle();
		System.out.println(parent + " parent");
		w.findElement(By.xpath("//img[@title='Select'][1]")).click();
		Set<String> child = w.getWindowHandles();
		System.out.println(child);
		String Child1 = "";
		for (String t : child) {
			if (!t.equals(parent)) {
				w.switchTo().window(t);
				System.out.println(t);
				Child1 += t;
			}
		}

		boolean b = false;
		w.findElement(By.id("search_txt")).sendKeys(orgname);
		w.findElement(By.xpath("//input[@name='search']")).click();
		WebElement web = w.findElement(By.xpath("//a[@id='1']"));

		web.click();

		/*
		 * 
		 * Set<String> child=w.getWindowHandles(); String Child1=""; for(String t:child)
		 * { if(!t.equals(parent)) { Child1+=t; w.switchTo().window(Child1);
		 * w.findElement(By.id("search_txt")).sendKeys(orgname); WebElement web=
		 * w.findElement(By.xpath("//a[@id='1']")); if((web.getText()).equals(orgname))
		 * { System.out.println("organization there"); }
		 * 
		 * }
		 * 
		 * } w.switchTo().window(parent);
		 * 
		 */
		   Set<String> k=w.getWindowHandles();
		   System.out.println("windows"+k);
	w.switchTo().window(parent);
		WebElement we = w.findElement(By.xpath("//input[@name='support_end_date']"));
		a.scrollToElement(we).perform();
		w.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(afterDate);
		w.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(actdate);
	       
 
		w.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		/*

		WebElement w2 = w.findElement(By.id("dtlview_Support End Date"));
		a.scrollToElement(w2).perform();

		String text = w2.getText();
		System.out.println(text);
		System.out.println(afterDate);
		if (text.equals(afterDate)) {
			System.out.println(text + "date created");
		} else {
			System.out.println("not created");
		}
		*/

	}

}