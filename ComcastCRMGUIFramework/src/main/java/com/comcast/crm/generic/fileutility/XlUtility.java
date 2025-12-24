package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XlUtility {
	
	
	public String getDataFromExcelFile(int sheetname,int rowNum,int cellNum) throws IOException, ParseException {
		 
		String path = "./testScriptData/Contacts.xlsx";
	 FileInputStream fis=new FileInputStream(path);
	  Workbook work=   WorkbookFactory.create(fis);
	          Sheet s=  work.getSheetAt(sheetname);
	          
	      String data=    s.getRow(rowNum).getCell(cellNum).getStringCellValue();
	  
		     return data;
		     
 }
	            
	public int getRowCountFromExcelFile(int sheetname) throws IOException, ParseException {
		 
		String path = "./testScriptData/Contacts.xlsx";
	 FileInputStream fis=new FileInputStream(path);
	  Workbook work=   WorkbookFactory.create(fis);
	          Sheet s=  work.getSheetAt(sheetname);
	      int data=    s.getLastRowNum();
	  
		     return data;
		     
 }
	public void setDataFromExcelFile(int sheetname,int rowNum,int cellNum) throws IOException, ParseException {
		 
		String path = "./testScriptData/Contacts.xlsx";
	 FileInputStream fis=new FileInputStream(path);
	  Workbook work=   WorkbookFactory.create(fis);
	          Sheet s=  work.getSheetAt(sheetname);
	         s.getRow(rowNum).createCell(cellNum);
	  
		     FileOutputStream fos=new FileOutputStream(path);
		     work.write(fos);
		     work.close();
		     
 }

}
