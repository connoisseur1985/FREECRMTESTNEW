package com.qa.crm.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.crm.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestListener  implements ITestListener{
	
		public ExtentReports report;
		public 	ExtentTest logger;
		
	public void onStart(ITestContext context) {
		
		System.out.println("Test Start");
		System.out.println(context.getName());
		
		report = new ExtentReports("C:\\Users\\ASUS\\eclipse-workspace\\FREECRMTESTNEW\\src\\main\\java\\com\\qa\\crm\\testoutput\\extent.html");
		logger = report.startTest("FreeCRMTest");
	}

	 public void onTestFailure(ITestResult result) {
		 
		 System.out.println("Test Fail");
		 
		 
		 try {
			logger.log(LogStatus.FAIL, "Test Failed "+logger.addScreenCapture(Utilities.getScreenShot())+" "+result.getMethod().getMethodName()+" "+result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
//		 try {
//			System.out.println(result.getInstanceName());
//			System.out.println(result.getMethod().getMethodName());
//			Utilities.getScreenShot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		// driver.quit();

	}
	 
	 public void onTestSuccess(ITestResult result) {

		 logger.log(LogStatus.PASS, "Test Passed "+result.getMethod().getMethodName());
	}
	 
	 public void onTestSkipped(ITestResult result) {
		 
	

		 logger.log(LogStatus.SKIP, "Test Skipped "+result.getMethod().getMethodName());
		 
	}
	 
	 public void onTestStart(ITestResult result) {
		 System.out.println(" ");
		 System.out.println("Test is starting");
		System.out.println(result.getInstance());
		 System.out.println(result.getMethod().getMethodName());
		 System.out.println(" ");
	 }
	 
	 public void onFinish(ITestContext context) {
 
		 
		 report.flush();
		 report.endTest(logger);
		
		 System.out.println("All Test Finished");
		 
		 //driver.close();
		 

	 }


	 
	 
	 
}
