package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonUtility {
	   
	public String getDataFromPropertiesFile(String key) throws IOException, ParseException {
		 
		String path = "./configAppData/apCommondatas.json";
		FileReader fis = new FileReader(path);
		    JSONParser parser =new JSONParser();
		    Object obj=parser.parse(fis);
		     JSONObject map=(JSONObject)obj;
		     String data=map.get(key).toString();
		     return data;
		     
		    
		    
       
	  
 }

}
