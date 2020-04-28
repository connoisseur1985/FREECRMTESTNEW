package com.qa.crm.testpages;

import java.awt.AWTException;
import java.io.IOException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;
import com.qa.crm.pages.RegisterPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.utilities.Utilities;


//@Listeners(com.qa.crm.utilities.TestListener.class)

public class RegisterPageTest extends TestBase {
	
	
	FreeCRMEntryPage freeCRMEntryPage;
	RegisterPage registerPage;
	SignUpPage signUpPage ;
	//Utilities utilities;
	
	
	public RegisterPageTest() throws IOException 
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException, AWTException 
	{
		initialize();
		
		
		
		freeCRMEntryPage = new FreeCRMEntryPage();
		
		registerPage = freeCRMEntryPage.clickOnSignUpLink();
		
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void tear() {
		
		driver.close();
	}
	
	@AfterTest
	public void tearDown() 
	{
		SessionId session = ((RemoteWebDriver)driver).getSessionId();
		
		if(session!= null)
			{
			driver.quit();
			}
		
	}
	
	@Test(priority=1,groups= {"regression","sanity"})
	
	public void verifyTitleTest() throws IOException 
	{
		System.out.println("Thread is Verify Title Test - "+Thread.currentThread().getId());
		
		
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitleTest",dataProvider="data",groups= {"ddt","regression"})
	public void verifyRegistration(String email, String country, String number) throws IOException 
	{
	
		System.out.println("Thread is Registration Form Test - "+Thread.currentThread().getId());
				
		signUpPage = registerPage.fillRegistrationForm(email, country, number);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.freecrm.com/");
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> data() throws IOException 
	{
		
		Iterator<Object[]> it = Utilities.getExcelData("C:\\Users\\ASUS\\eclipse-workspace\\FREECRMTESTNEW\\src\\main\\java\\com\\qa\\crm\\data\\RegistrationExcel.xls", "Register").iterator();
		
		return it;

	}
}
