package testngpractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.Basetest;
//
//@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)

public class InvoiceTest extends Basetest{
	
	 
	  @Test
	  public void Innvoice() {
		  
		    System.out.println("execute createInvoiceTest");
		       String actTitle=w.getTitle();
		       Assert.assertEquals(actTitle, "Login");
		        System.out.println("1st one");
		        System.out.println("2nd one");
		    
	  }
	  
	     @Test
	      public void createinnovoicewithContactTest() {
	    	 System.out.println("createinnovoicewithContactTest");
	    	 System.out.println("execute createInvoiceTest");
		       String actTitle=w.getTitle();
		       Assert.assertEquals(actTitle, "Login");
		        System.out.println("1st one");
		        System.out.println("2nd one");
	    	 
	    	 
	    	 
	    	 
	     }
	  

}
