package com.qa.crm.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.Assert;


import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FreeCRMEntryPageTest extends TestBase{

	
	FreeCRMEntryPage freeCRMEntryPage;

	public FreeCRMEntryPageTest() throws IOException {
		
		super();
		
	}

	@BeforeTest
	public void startReport() 
	{

	}
	
	@AfterTest
	public void endReport() 
	{
	
	}
	@BeforeMethod
	public void setUp() throws IOException {
		
		System.out.println("Thread is Before Method : "+Thread.currentThread().getId());
		
		initialize();
		
		freeCRMEntryPage = new FreeCRMEntryPage();

	}
	
	@AfterMethod
		public void tearDown() {
		System.out.println("Thread is After : "+Thread.currentThread().getId());
		driver.quit();
	}
	
	@Test(priority=1,groups= {"regression","sanity"})
	public void verifyLogoLink() throws IOException {
		
		System.out.println("Thread is verify Logo Link : "+Thread.currentThread().getId());
		freeCRMEntryPage = freeCRMEntryPage.clickOnLogoLink();
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://freecrm.co.in/");

	}
}
