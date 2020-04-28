package com.qa.crm.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.crm.base.TestBase;

public class Utilities extends TestBase{
	
	

	
	public Utilities() throws IOException {
		super();
		
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
				//System.out.println(rowNum+" "+i);			
				String email = ws.getRow(i).getCell(0).getStringCellValue(); 
				//System.out.println(email);
				String country = ws.getRow(i).getCell(1).getStringCellValue();
				//System.out.println(country);
				String phone = ws.getRow(i).getCell(2).getStringCellValue();
				//System.out.println(phone);
				Object obj[] = {email, country , phone};
				
				list.add(obj);
				
				//wb.close();
		}
		//System.out.println("Hi");
				
		return list;
		
		
	}
	
	public static String getScreenShot() throws IOException 
	{
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(java.util.Calendar.getInstance().getTime());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\testoutput\\"+timestamp+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

	public static Object[][] getExcelDataForValidLogin() throws IOException {
	
		FileInputStream fin = new FileInputStream(prop.getProperty("pathExcelLogin"));
		HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet ws = wb.getSheet("Valid Login");
		
		int rowNum = ws.getPhysicalNumberOfRows();
		int colNum = ws.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(colNum);
		Object[][] obj = new Object[rowNum-1][colNum];
		
		for(int i=0;i<rowNum-1;i++) 
		{
			for(int j=0;j<colNum;j++) 
			{
				obj[i][j] = ws.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		
		//wb.close();
		
		System.out.println(Arrays.deepToString(obj));
		return obj;
	}

	public static Object[][] getExcelDataForInValidLogin() throws IOException {
		
		System.out.println("hi");
		 FileInputStream fin = new FileInputStream(prop.getProperty("pathExcelLogin"));
		 HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet ws = wb.getSheet("Invalid Login");
		
		
		int rowNum = ws.getPhysicalNumberOfRows();
		int colNum = ws.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(colNum);
		Object[][] obj = new Object[rowNum-1][colNum];
		
		for(int i=0;i<rowNum-1;i++) 
		{
			for(int j=0;j<colNum;j++) 
			{
				obj[i][j] = ws.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		
		//wb.close();
		
		System.out.println(Arrays.deepToString(obj));
		return obj;	}


}
