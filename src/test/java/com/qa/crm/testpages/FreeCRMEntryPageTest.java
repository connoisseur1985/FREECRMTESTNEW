package com.qa.crm.testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;


import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FreeCRMEntryPageTest extends TestBase{

	
	FreeCRMEntryPage freeCRMEntryPage;

	FreeCRMEntryPage freeCRMEntryPage1;
	
	public FreeCRMEntryPageTest() throws IOException {
		
		super();
		
	}

	@BeforeTest
	public void startReport() 
	{

	}
	

	@BeforeMethod
	public void setUp() throws IOException, AWTException {
		
		
		
		initialize();
		
		freeCRMEntryPage = new FreeCRMEntryPage();

	}

	@AfterMethod
	public void tear() {
		
		driver.close();
	}
	
	@AfterTest
		public void tearDown() {
		
		SessionId session = ((RemoteWebDriver)driver).getSessionId();
		
		
	
		if(session!= null)
			{
			System.out.println("tearDown");
			driver.quit();
			}
		
	}
	
	@Test(priority=1,groups= {"regression","sanity"})
	public void verifyLogoLink() throws IOException {
		
				
		System.out.println("Thread is verify Logo Link : "+Thread.currentThread().getId());
		
		
		freeCRMEntryPage1 = freeCRMEntryPage.clickOnLogoLink();
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://freecrm.co.in/");

	}
}
