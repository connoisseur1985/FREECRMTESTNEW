package com.qa.crm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.crm.base.TestBase;

public class Utilities extends TestBase implements ITestListener{
	
	
	public Utilities() throws IOException {
		super();
		
	}

	
	 public void onTestStart(ITestResult result) {
	
	}
	 
	 public void onTestFailure(ITestResult result) {

	}
	 
	 public void onTestSuccess(ITestResult result) {

	}
	 
	 public void onTestSkipped(ITestResult result) {

	}
	public static List<Object[]> getExcelData(String path,String sheetName) throws IOException 
	{
		FileInputStream fin = new FileInputStream(path);
		HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet ws = wb.getSheet(sheetName);
		
		int rowNum = ws.getPhysicalNumberOfRows();
		//int colNum = ws.getRow(0).getLastCellNum();
		
		List<Object []> list = new ArrayList<Object[]>();
		
				
		for(int i=1;i<rowNum;i++) 
		{
				System.out.println(rowNum+" "+i);			
				String email = ws.getRow(i).getCell(0).getStringCellValue(); 
				//System.out.println(email);
				String country = ws.getRow(i).getCell(1).getStringCellValue();
				//System.out.println(country);
				String phone = ws.getRow(i).getCell(2).getStringCellValue();
				//System.out.println(phone);
				Object obj[] = {email, country , phone};
				
				list.add(obj);
		}
		System.out.println("Hi");
				
		return list;
		
		
	}


}
