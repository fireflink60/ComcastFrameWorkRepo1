package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SimpleTest_WithPom {

	   
	 @FindBy(name = "user_name")
	 WebElement w1;
	 
	 @FindBy(name="user_password")
	 WebElement w2;
	 
	 @FindBy(id = "submitButton")
	 WebElement w3;
	 
	 
	      
	 
	      @Test
	     public void sampleTest() {
			     
	    	 WebDriver driver =new ChromeDriver();
		     driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		     
		     SimpleTest_WithPom s=    PageFactory.initElements( driver,SimpleTest_WithPom.class);
		        s.w1.sendKeys("admin");
		        s.w2.sendKeys("admin");
		             driver.navigate().refresh();
		             s.w1.sendKeys("admin");
				        s.w2.sendKeys("admin");
		        s.w3.click();
		      
		     
		        
		     
		}
	 
	
	
}
