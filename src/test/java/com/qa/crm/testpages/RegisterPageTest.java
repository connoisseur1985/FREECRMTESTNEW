package com.qa.crm.testpages;

import java.io.IOException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	public void setUp() throws IOException 
	{
		initialize();
		
		freeCRMEntryPage = new FreeCRMEntryPage();
		registerPage = new RegisterPage();
		signUpPage = new SignUpPage();
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test(priority=1,groups= {"regression","sanity"})
	
	public void verifyTitleTest() throws IOException 
	{
		
		registerPage = freeCRMEntryPage.clickOnSignUpLink();
		
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitleTest",dataProvider="data",groups= {"ddt","regression"})
	public void fillRegistrationForm(String email, String country,String phone) throws IOException 
	{
	
			
		registerPage = freeCRMEntryPage.clickOnSignUpLink();
		
		registerPage.fillEmailTextBox(email);
		
		registerPage.selectCountry(country);
		
		registerPage.fillInPhoneNumber(phone);
		
		registerPage.clickOnTermsCheckBox();
		
		registerPage.clickOnCaptcha();
		
		signUpPage = registerPage.clickOnSignUpButton();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.freecrm.com/");
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> data() throws IOException 
	{
		
		Iterator<Object[]> it = Utilities.getExcelData("C:\\Users\\ASUS\\eclipse-workspace\\FREECRMTESTNEW\\src\\main\\java\\com\\qa\\crm\\data\\RegistrationExcel.xls", "Register").iterator();
		
		return it;

	}
}
