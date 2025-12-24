package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	 public String getDataFromPropertiesFile(String key) throws IOException {
		 
			String path = "./configAppData/Oraganization.properties.txt";
			FileInputStream fis = new FileInputStream(path);

		    Properties p=new Properties();
		    p.load(fis);
		    String r=  p.getProperty(key);
		    
		     
		 
		 return  r;
	 }

}
