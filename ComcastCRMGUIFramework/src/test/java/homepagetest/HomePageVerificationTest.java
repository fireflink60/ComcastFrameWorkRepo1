package homepagetest;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class HomePageVerificationTest {

	@Test
	public void homePageTest(Method mtd) {
		  System.out.println(mtd.getName() +" Test Start");
		String ex = "Home P";
		WebDriver w = new ChromeDriver();
		w.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		LoginPage l = new LoginPage(w);
		l.login("admin", "admin");
		String text = w.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		 Assert.assertEquals(text, ex);

	}
	     @Test
	      public  void logo(Method mtd) {
	    	  System.out.println(mtd.getName() +" Test Start");
	  		 
	  		WebDriver w = new ChromeDriver();
	  		w.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
	  		LoginPage l = new LoginPage(w);
	  		l.login("admin", "admin");
	  		boolean text = w.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	  		if (!text) {
	  			System.out.println("fail");
	  		} else {
	  			System.out.println("Sucess");
	  		}

	  	}
	    	  
	    	  
	    	  
	      }


