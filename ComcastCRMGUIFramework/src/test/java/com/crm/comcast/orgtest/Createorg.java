package com.crm.comcast.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.crm.comcast.basetest.Basetest;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class Createorg extends Basetest {

	@Test(groups = "SmokeTest")
	public void createOrg() throws IOException {

		JavaUtility ju = new JavaUtility();
		String actualdate = ju.actualDate();

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

		String p1 = w.getWindowHandle();

		w.findElement(By.xpath("//a[text()='Organizations']")).click();
	 

		HomePage page = PageFactory.initElements(w, HomePage.class);
		page.getOrgbtn().click();

		w.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		OrganizationPage org = PageFactory.initElements(w, OrganizationPage.class);
		org.getPulsbtn().click();

		CreatingNewOrganizationPage cnp = PageFactory.initElements(w, CreatingNewOrganizationPage.class);
		cnp.Details(orgname, "Mir", "Energy");
		try {
		    Alert alert = w.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		} catch (NoAlertPresentException e) {
		    // No alert → safe to continue
		}
		
		 
	


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
		WebDriverUtility wt = new WebDriverUtility();
		wt.SelectByText("Organization Name", org1.getDropdn());
		org1.getSubmit().click();
		w.findElement(By.xpath("( //a[text()='" + orgname + "'])[2]/../../td[8]/a[2]")).click();
		wt.alertaccept(w);

	}

	@Test(groups = "RegressionTest")
	public void createOrgwith_Industries() throws IOException {
		  ListImpClass.test.log(Status.PASS,"it is created");
		  
		JavaUtility ju = new JavaUtility();
		String actualdate = ju.actualDate();

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

		String p1 = w.getWindowHandle();

		w.findElement(By.xpath("//a[text()='Organizations']")).click();

		HomePage page = PageFactory.initElements(w, HomePage.class);
		page.getOrgbtn().click();

		w.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Assert.fail();
		  UtilityClassObject.getTest().log(Status.PASS, "Organization created sucesss");

		OrganizationPage org = PageFactory.initElements(w, OrganizationPage.class);
		org.getPulsbtn().click();

		CreatingNewOrganizationPage cnp = PageFactory.initElements(w, CreatingNewOrganizationPage.class);
		cnp.Details(orgname, "Mir", "Energy");

		OrganizationInfoPage prp = PageFactory.initElements(w, OrganizationInfoPage.class);
		String txt = prp.getTxt().getText();
		if (txt.contains(orgname)) {
			  try {
				ListImpClass.test.log(Status.PASS, "it is passed");
			  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
		} else {
		     try {
				ListImpClass.test.log(Status.FAIL,"it is failed");
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		
	}

}
}
