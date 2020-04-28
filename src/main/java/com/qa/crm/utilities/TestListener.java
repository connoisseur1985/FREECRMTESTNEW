package com.qa.crm.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.crm.base.TestBase;



public class TestListener  implements ITestListener{
	
	
	public void onStart(ITestContext context) {
		
		System.out.println("Test Start");
		System.out.println(context.getName());

	}

	 public void onTestFailure(ITestResult result) {
		 
		 System.out.println("Test Fail");
		 
		 try {
			System.out.println(result.getInstanceName());
			System.out.println(result.getMethod().getMethodName());
			Utilities.getScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// driver.quit();

	}
	 
	 public void onTestSuccess(ITestResult result) {

		 System.out.println("Test Pass");
			System.out.println(result.getInstanceName());
			System.out.println(result.getMethod().getMethodName());
			
			//driver.quit();
		 

	}
	 
	 public void onTestSkipped(ITestResult result) {
		 
		 System.out.println("Test Skipped");
		 
		 
		 try {
				System.out.println(result.getInstanceName());
				System.out.println(result.getMethod().getMethodName());
			Utilities.getScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //driver.quit();
		 
	}
	 
	 public void onTestStart(ITestResult result) {
		 System.out.println(" ");
		 System.out.println("Test is starting");
		System.out.println(result.getInstance());
		 System.out.println(result.getMethod().getMethodName());
		 System.out.println(" ");
	 }
	 
	 public void onFinish(ITestContext context) {
 
		 System.out.println("All Test Finished");
		 
		 //driver.close();
		 

	 }


	 
	 
	 
}
