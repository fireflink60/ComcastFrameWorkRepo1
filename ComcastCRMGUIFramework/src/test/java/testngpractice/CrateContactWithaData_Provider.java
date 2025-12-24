package testngpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrateContactWithaData_Provider {
	
	
	
	
	
	            @DataProvider
	            public Object[][] createContact(){
	            	
	            	    Object[][] obj=new Object[3][3];
	            	    obj[0][0]="sai";
	            	    obj[0][1]="Kiran";
	            	    obj[0][2]="Kiran";
	            	    obj[1][0]="Vara";
	            	    obj[1][1]="Preasad";
	            	    obj[1][2]="Preasad";
	            	    obj[2][0]="Virat";
	            	    obj[2][1]="kohli";
	            	    obj[2][2]="kohli";
	            	    return obj;
	            	    
	            	
	            	
	            	
	            	
	            }
	
	

	
	     @Test(dataProvider = "createContact")
	     public void createContactTest(String firstName,String LastName,String k) {
	    	   System.out.println(firstName);
	    	   System.out.println(LastName);
	    	 
	    	 
	     }
	
	
	
	
}
