package com.qa.crm.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	int retryAttempts = 2;
	int count = 0;
	
	public boolean retry(ITestResult result) {
		

		
		if(count<retryAttempts) 
		{
			count++;
			
			return true;
		}
		else {
		return false;
	}}

}
