package com.qa.crm.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		
		int retryAttempts = 2;
		int count =0;
		
		if(count<retryAttempts) 
		{
			count++;
			
			return true;
		}
		else {
		return false;
	}}

}
