package testngpractice;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.XlUtility;

public class DataProviderAmazon {
	
	
	        @DataProvider
	        
	        public Object[][]  buyProduct() throws IOException, ParseException{
	        	
	        	     XlUtility x=new XlUtility();
	        	     
	        	      int r= x.getRowCountFromExcelFile(1);
	        	          
	        	       
	        	       
	        	     Object[][] obj=new Object[r][2];
	        	     
	        	     obj[0][0]=   x.getDataFromExcelFile(1,1,0);
	        	     obj[0][1]=x.getDataFromExcelFile(1,1,1);
	        	     obj[1][0]=   x.getDataFromExcelFile(1,2,0);
	        	 
	        	     obj[1][1]=x.getDataFromExcelFile(1,2,1);
	        	     obj[2][0]=x.getDataFromExcelFile(1,3,0);
	        	     obj[2][1]=x.getDataFromExcelFile(1,3,1);
	        	     
	        	  return obj;
	        }
	            @Test(dataProvider = "buyProduct")
	          public void enter(String firstname,String Lastname) {
	        	  WebDriver w=new ChromeDriver();
	        	  w.get("https://www.amazon.com/India/b?ie=UTF8&node=13153885011");
	        	    w.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        	  w.findElement(By.id("twotabsearchtextbox")).sendKeys(firstname);
	        	  Actions a=new Actions(w);
	        	  
	        	  a.sendKeys(Keys.ENTER).perform();
	        	WebElement web=  w.findElement(By.xpath("//span[contains(text(),'"+Lastname+"')]"));
	        	      a.scrollToElement(web).perform();
	        	  System.out.println(web.getText());
	        	  
	        	         
	        	  
	        	  
	          }

}
