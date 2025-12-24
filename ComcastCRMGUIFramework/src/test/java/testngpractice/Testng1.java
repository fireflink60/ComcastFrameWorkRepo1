package testngpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng1 {
	    
	@Test
	public void tc1() {
		
		System.out.println("hii1");
	}
	    @Test(dependsOnMethods ="tc3" )
	      public void tc2() {
	    	   System.out.println("hii2");
	      }
	    
	         @Test
	       public void tc3() {
	    	      System.out.println("hii3");
	    	         Assert.fail();
	       }
	      

}
