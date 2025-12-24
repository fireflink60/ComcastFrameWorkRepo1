package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.basetest.Basetest;

public class ListImpClass implements ITestListener,ISuiteListener,IRetryAnalyzer {
	public static ExtentReports report ;
	public  ExtentSparkReporter spark;
	public static  ExtentTest test;
    

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String time=new Date().toString().replace(" ","_").replace(":","_");
		     
		 spark = new ExtentSparkReporter("./AdvanceReport/"+time+".html");
			spark.config().setDocumentTitle("Crm Test  Suite Results");
			spark.config().setReportName("Crm Report");
			spark.config().setTheme(Theme.DARK);

			// add Env information && create test
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("Os", "Windows10");
			report.setSystemInfo("BROWSER", "CHROME-100");
		 System.out.println("report Configuration");
		 
		 
			 
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		 System.out.println("Report Backup");
		 
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		     String results=result.getMethod().getMethodName();
	    test = report.createTest(results);
	    UtilityClassObject.setText(test);
	    test.log(Status.PASS,results+" >==== completed <===");
	 
		
	    System.out.println("=============="+result.getMethod().getMethodName() +">========START=======");
	} 

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+">========END=======");
	}

//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		String time=new Date().toString().replace(" ","_").replace(":","_");
//		
//		
//		 
//		   EventFiringWebDriver efw=new EventFiringWebDriver(Basetest.sdriver);
//		     File src=  efw.getScreenshotAs(OutputType.FILE);
//		     try {
//				FileUtils.copyFile(src, new File("./Screenshot/"+time+".png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		     
//		       
//	} 
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String time=new Date().toString().replace(" ","_").replace(":","_");
		
		
		 
		   EventFiringWebDriver efw=new EventFiringWebDriver(UtilityClassObject.getDriver());
		   
		     String filepath=  efw.getScreenshotAs(OutputType.BASE64)+time;
		     if ("HDFCC".equals("HDFC")) {
					test.log(Status.PASS, "contact is Created");

				} else {
					test.addScreenCaptureFromBase64String(filepath);

				}

		     
		       
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		  String results=result.getMethod().getMethodName();
		    test = report.createTest(results);
		    test.log(Status.PASS,results+" >==== Skipped <===");
		   
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	  
	   
		  int count = 0;
		    int maxRetry = 4;

		    @Override
		    public boolean retry(ITestResult result) {
		        if (count < maxRetry) {
		            count++;
		            System.out.println("Retrying test: "
		                    + result.getMethod().getMethodName()
		                    + " | Retry count: " + count);
		            return true;
		        }
		        return false;
		    }

 
	

}
