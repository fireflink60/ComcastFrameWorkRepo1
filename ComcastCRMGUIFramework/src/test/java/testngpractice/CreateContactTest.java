package testngpractice;

import org.testng.annotations.Test;

public class CreateContactTest {

	
	
	   @Test
	    public void  createContact() {
	    	System.out.println("craeted");
	    	
	    }
	   
	   @Test(priority = 1)
	       public void modifyContact() {
	    	        System.out.println("modified");
	       }
	   
	   @Test
	         public void delete() {
	        	       System.out.println("deleted"); 
	         }
	         
}
