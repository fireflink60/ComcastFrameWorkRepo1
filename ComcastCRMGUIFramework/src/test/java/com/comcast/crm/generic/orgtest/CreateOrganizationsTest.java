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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationsTest {

	public static void main(String[] args) throws IOException, NullPointerException {
		// TODO Auto-generated method stub

	 
		
		  JavaUtility ju=new JavaUtility();
		  String actualdate =   ju.actualDate();

		 
		String afterDate = ju.beforeDate(30);

		String path = "./configAppData/Oraganization.properties.txt";
		FileInputStream fis = new FileInputStream(path);

		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");

		 
		int randomInt = ju.randomnumber();
		String path1 = "./testScriptData/Orgdata.xlsx";
		FileInputStream fis1 = new FileInputStream(path1);

		Workbook wb = WorkbookFactory.create(fis1);
		Sheet s = wb.getSheetAt(0);
		Row r = s.getRow(7);
		String orgname = r.getCell(2).toString() + randomInt;
		String lastname = r.getCell(3).toString() + randomInt;

		WebDriver w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		w.get(p.getProperty("url"));

		LoginPage lg = new LoginPage(w);

//		  LoginPage lg=PageFactory.initElements(w,LoginPage.class);
		lg.getUsernameEdt().sendKeys("admin");

		lg.getPasswordEdt().sendKeys("admin");
		lg.getLoginBtn().click();

//                lg.login("admin", "admin");

//		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='text']"))
//				.sendKeys(p.getProperty("username"));
//
//		w.findElement(By.xpath("//div[@class='inputs']/descendant::input[@type='password']"))
//				.sendKeys(p.getProperty("password"));
//		Actions a = new Actions(w);
//		a.sendKeys(Keys.ENTER).perform();

		String p1 = w.getWindowHandle();

//	     w.findElement(By.xpath("//a[text()='Organizations']")).click();

		HomePage page = PageFactory.initElements(w, HomePage.class);
		page.getOrgbtn().click();

//		   
//	        w.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		OrganizationPage org = PageFactory.initElements(w, OrganizationPage.class);
		org.getPulsbtn().click();
		

//	        w.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
//	        w.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("miryalaguda");
//	        w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
//	         
		CreatingNewOrganizationPage cnp = PageFactory.initElements(w, CreatingNewOrganizationPage.class);
//		           cnp.Details(orgname,"Miryalagudaaa");
//		           cnp.getActname().sendKeys("sai11");
//		           cnp.getAdress().sendKeys("Miryalaguda");
//		           cnp.getSave().click();
		cnp.Details(orgname, "Mir", "Energy");

		OrganizationInfoPage prp = PageFactory.initElements(w, OrganizationInfoPage.class);
		String txt = prp.getTxt().getText();
		if (txt.contains(orgname)) {
			System.out.println("they are equal");
		} else {
			System.out.println("not equal");
		}
		
		
		HomePage page1 = PageFactory.initElements(w, HomePage.class);
		page1.getOrgbtn().click();
		   
		OrganizationPage org1 = PageFactory.initElements(w, OrganizationPage.class);
		org1.getSearchbtn().sendKeys(orgname);
		    WebDriverUtility wt=new WebDriverUtility();
		    wt.SelectByText("Organization Name",org1.getDropdn());
		    org1.getSubmit().click();
		       w.findElement(By.xpath("( //a[text()='"+orgname+"'])[2]/../../td[8]/a[2]")).click();
		       wt.alertaccept(w);
		    
		

	}
}