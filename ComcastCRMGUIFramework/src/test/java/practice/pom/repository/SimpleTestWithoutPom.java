package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTestWithoutPom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		WebDriver driver =new ChromeDriver();
		     driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		  WebElement w1=driver.findElement(By.name("user_name"));
		   WebElement w2=driver.findElement(By.name("user_password"));
		   WebElement w3=driver.findElement(By.id("submitButton"));
		           driver.navigate().refresh();
		   w1.sendKeys("admin");
		   w2.sendKeys("admin");
		   w3.click();
		
		
		
	}

}
