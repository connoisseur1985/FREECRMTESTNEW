package com.qa.crm.testpages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;
import com.qa.crm.pages.FreeCRMLoginPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.utilities.Utilities;

public class FreeCRMLoginPageTest extends TestBase{

	FreeCRMEntryPage freeCRMEntryPage;
	FreeCRMLoginPage freeCRMLoginPage;
	HomePage homePage;
	//Utilities utilities;
	
	public FreeCRMLoginPageTest() throws IOException {
		
		super();
				
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException, AWTException 
	{
		initialize();
		
		freeCRMEntryPage = new FreeCRMEntryPage();
		
		freeCRMLoginPage = freeCRMEntryPage.clickOnLoginButton();
		
		
		
		
	}
	
	@Test(groups= {"sanity","regression"} ,priority =1)
	public void verifyLoginTitleTest() throws IOException 
	{
		
		System.out.println("Thread is verify Login Title Test : "+Thread.currentThread().getId());
				
		Assert.assertEquals(driver.getTitle(),"Cogmento CRM");
	
	}
	
	@Test(dataProvider="getDataForValidLogin", groups= {"ddt","regression"},dependsOnMethods="verifyLoginTitleTest",priority=3)
	public void fillValidLoginDetails(String email,String password) throws IOException 
	{
		System.out.println("Thread is Valid Login- "+Thread.currentThread().getId());
		homePage = freeCRMLoginPage.validLogin(email, password);
		
		Assert.assertEquals(homePage.checkUserLabel(), "Ankur Mahajan");
	}
		
		
	
	@Test(priority=2,dataProvider="getDataForInvalidLogin", groups= {"ddt","regression"},dependsOnMethods="verifyLoginTitleTest")
	public void fillInValidLoginDetails(String email,String password) throws IOException 
	{
		System.out.println("Thread is Invalid login - "+Thread.currentThread().getId());
		
		freeCRMLoginPage.inValidLogin(email, password);
		
		Assert.assertTrue(freeCRMLoginPage.checkVisibilityOfSomethingWrong());
	}
	
	@AfterMethod
	public void tear() {
		
		driver.close();
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();SessionId session = ((RemoteWebDriver)driver).getSessionId();
		
		if(session!= null)
			{
			driver.quit();
			}
		
	}
	
	@DataProvider
	public Object[][] getDataForValidLogin() throws IOException 
	{
		//System.out.println("Thread Id is Data Provider Valid Login: "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
		Object[][] obj = Utilities.getExcelDataForValidLogin();
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] getDataForInvalidLogin() throws IOException 
	{
		
		//System.out.println("Thread Id is Data Provider Invalid Login: "+Thread.currentThread().getId());
		Object[][] obj = Utilities.getExcelDataForInValidLogin();
		
		
		return obj;
		
	}
}
