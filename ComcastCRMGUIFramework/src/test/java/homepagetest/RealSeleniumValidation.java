package homepagetest;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutility.JasonUtility;
import com.comcast.crm.generic.fileutility.XlUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class RealSeleniumValidation{
	
	JavaUtility jt=new JavaUtility();
	String actualdate = jt.actualDate() ;
	String after=jt.afterDate(30);

	 
	String afterDate = jt.beforeDate(30);

 
	 JasonUtility j=new JasonUtility();
	 int randomInt=jt.randomnumber();
	 XlUtility x=new XlUtility();

	 @Test
	 public void validate() throws IOException, ParseException {
		 Reporter.log("create contact");
		 String url =  j.getDataFromPropertiesFile("url");
	     WebDriver w=new ChromeDriver();
	        w.get(url);
		  String orgname=	 x.getDataFromExcelFile(0, 7, 2)+randomInt;
		String lastname =  x.getDataFromExcelFile(0, 7,3) + randomInt;
		      LoginPage l=new LoginPage(w);
		       l.login("admin", "admin");

			w.findElement(By.xpath("//a[text()='Contacts']")).click();
			w.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

			w.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			w.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			WebElement w1 = w.findElement(By.className("dvHeaderText"));
			String text1=w1.getText();
             boolean k=text1.contains(lastname);
             Assert.assertEquals(true, k);
			
			WebElement w2 = w.findElement(By.id("dtlview_Last Name"));
			
			 
			  
			   
			String text2 = w2.getText();
			Reporter.log(text2);
			SoftAssert sa=new SoftAssert();
			 sa.assertEquals(lastname,text2);
	       
		    sa.assertAll();
			 
		 
		 
		 
		 
	 }

}
