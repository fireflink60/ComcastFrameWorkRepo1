package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	      
	    public int randomnumber() {
	    	
	    	Random r=new Random();
	    	  int ransomInt=  r.nextInt(1000);
	    	  return ransomInt;
	    	
	    	
	    }
	    
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	         public String actualDate() {
	        	 
	        		Date dateobj = new Date();
	        	 
	        		String actdate = sim.format(dateobj);
	        		String actualdate = actdate;
					return actualdate;
	         }
	         
	              public String beforeDate(int num) {
	            	  
	            	  
	            		Calendar c = sim.getCalendar();
	            		c.add(Calendar.DAY_OF_MONTH, -num);
	            		String afterDate = sim.format(c.getTime());
						return afterDate;
	              }
	              public String  afterDate(int num) {
	            	  
	            	  
	            		Calendar c = sim.getCalendar();
	            		c.add(Calendar.DAY_OF_MONTH,num);
	            		String afterD = sim.format(c.getTime());
						return afterD;
	              }
	              

}
