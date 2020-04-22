package com.qa.crm.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		
		int retryAttempts = 3;
		int count =0;
		
		while(count<retryAttempts) 
		{
			count++;
			return true;
		}
		
		return false;
	}

}
