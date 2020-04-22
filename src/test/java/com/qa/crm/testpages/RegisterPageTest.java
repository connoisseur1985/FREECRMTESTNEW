package com.qa.crm.testpages;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.FreeCRMEntryPage;
import com.qa.crm.pages.RegisterPage;
import com.qa.crm.pages.SignUpPage;
import com.qa.crm.utilities.Utilities;

public class RegisterPageTest extends TestBase {
	
	
	FreeCRMEntryPage freeCRMEntryPage;
	RegisterPage registerPage;
	SignUpPage signUpPage ;
	
	
	
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
		
		
		freeCRMEntryPage.clickOnSignUpLink();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test(enabled=true)
	
	public void verifyTitleTest() 
	{
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
	}
	
	@Test(dataProvider="data")
	public void fillRegistrationForm(String email, String country,String phone) throws IOException 
	{
		registerPage.fillEmailTextBox(email);
		
		registerPage.selectCountry(country);
		
		registerPage.fillInPhoneNumber(phone);
		
		registerPage.clickOnTermsCheckBox();
		
		registerPage.clickOnCaptcha();
		
		signUpPage = registerPage.clickOnSignUpButton();
		
	}
	
	@DataProvider
	public Iterator<Object[]> data() throws IOException 
	{
		
		Iterator<Object[]> it = Utilities.getExcelData("C:\\Users\\ASUS\\eclipse-workspace\\FREECRMTESTNEW\\src\\main\\java\\com\\qa\\crm\\data\\RegistrationExcel.xls", "Register").iterator();
		
		return it;

	}
}
