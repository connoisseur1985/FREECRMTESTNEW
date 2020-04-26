package com.qa.crm.testpages;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
	public void setUp() throws IOException 
	{
		System.out.println("Thread Id is Before Method: "+Thread.currentThread().getId());
		initialize();
		
		freeCRMEntryPage = new FreeCRMEntryPage();
		freeCRMLoginPage = new FreeCRMLoginPage();
		homePage = new HomePage();	
	}
	
	@Test(groups= {"sanity","regression"} ,priority =1)
	public void verifyTitleTest() throws IOException 
	{
		freeCRMLoginPage = freeCRMEntryPage.clickOnLoginButton();
		
		System.out.println("Thread Id is verifyTitle: "+Thread.currentThread().getId());
		
		
		Assert.assertEquals(driver.getTitle(),"Cogmento CRM");
	}
	
	@Test(dataProvider="getDataForValidLogin", groups= {"ddt","regression"},dependsOnMethods="verifyTitleTest",priority=3)
	public void fillValidLoginDetails(String email,String password) throws IOException 
	{
		freeCRMLoginPage = freeCRMEntryPage.clickOnLoginButton();
		
		System.out.println("Thread Id is Valid Login: "+Thread.currentThread().getId());
		try {
		freeCRMLoginPage.enterEmailId(email);
		freeCRMLoginPage.enterPassword(password);
		homePage = freeCRMLoginPage.clickOnLoginButton();
		
		Assert.assertEquals(homePage.checkUserLabel(), "Ankur Mahajan");
	}catch (Exception e) 
		{
		
		//driver.quit();
		}
		}
		
		
	
	@Test(priority=2,dataProvider="getDataForInvalidLogin", groups= {"ddt","regression"},dependsOnMethods="verifyTitleTest")
	public void fillInValidLoginDetails(String email,String password) throws IOException 
	{
		freeCRMLoginPage = freeCRMEntryPage.clickOnLoginButton();
		System.out.println("Thread Id is Invalid Login: "+Thread.currentThread().getId());   
		try {
		freeCRMLoginPage.enterEmailId(email);
		freeCRMLoginPage.enterPassword(password);
		freeCRMLoginPage.clickOnLoginButton();
		}catch(Exception e) 
		{
			//driver.quit();
		}
		Assert.assertTrue(freeCRMLoginPage.checkVisibilityOfSomethingWrong());
	}

	@AfterMethod
	public void tearDown() 
	{
		System.out.println("Thread Id is After Mthod: "+Thread.currentThread().getId());
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDataForValidLogin() throws IOException 
	{
		System.out.println("Thread Id is Data Provider Valid Login: "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
		Object[][] obj = Utilities.getExcelDataForValidLogin();
		
		return obj;
		
	}
	
	@DataProvider
	public Object[][] getDataForInvalidLogin() throws IOException 
	{
		
		System.out.println("Thread Id is Data Provider Invalid Login: "+Thread.currentThread().getId());
		Object[][] obj = Utilities.getExcelDataForInValidLogin();
		
		
		return obj;
		
	}
}
