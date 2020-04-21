package com.qa.crm.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;

public class FreeCRMEntryPageTest extends TestBase{

	
	FreeCRMEntryPage freeCRMEntryPage;
	
		
	public FreeCRMEntryPageTest() throws IOException {
		
		super();
		
	}

	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialize();
		freeCRMEntryPage = new FreeCRMEntryPage();
	}
	
	@AfterMethod
		public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogoLink() {
		
		freeCRMEntryPage.clickOnLogoLink();
		Assert.assertEquals(driver.getCurrentUrl(),"https://freecrm.co.in/");
	}
}
