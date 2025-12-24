package com.crm.comcast.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JasonUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class Basetest {

	public WebDriver w = null;
	public static WebDriver sdriver = null;
	public DataBaseUtility db = new DataBaseUtility();
	public FileUtility f = new FileUtility();
	public JasonUtility j = new JasonUtility();
	 
	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void beforeSuite() {
		 

		System.out.println("=============Connect to DB=========");
	}

	@BeforeClass
	public void launchBrowser() throws IOException, ParseException {
		System.out.println("== bc launchbrowser ==");

		w = new ChromeDriver();
		System.out.println(w.getCurrentUrl());

		 UtilityClassObject.setDriver(w);
          
//        String url =  j.getDataFromPropertiesFile("url");
//        w.get(url);
		String url = j.getDataFromPropertiesFile("url");
		w.get(url);
	}

	@BeforeMethod
	public void login() {

		LoginPage l = new LoginPage(w);
		l.login("admin", "admin");
	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void loginOut() {
		System.out.println("am logout");
		HomePage h = new HomePage(w);
		h.logOut();
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void closeBrowser() {
		System.out.println("==== close the browser ====");
		w.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void afterSuite() {
	 
		System.out.println("=========close the Db======");
	}
}
