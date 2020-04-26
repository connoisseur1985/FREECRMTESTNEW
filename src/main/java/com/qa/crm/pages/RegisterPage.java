package com.qa.crm.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.TestBase;

public class RegisterPage extends TestBase{
	
	public RegisterPage() throws IOException
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[name='email']")
	WebElement emailTextBox;
	
	@FindBy(css="input[class='search']")
	WebElement countryDropDown;
	
	@FindBy(css="input[name='phone']")
	WebElement phoneTextBox;
	
	@FindBy(id="terms")
	WebElement termsAndConditionsCheckBox;
	
	@FindBy(css="div[class='recaptcha-checkbox-border']")
	WebElement captchaCheckBox;
	
	@FindBy(css="button[name='action']")
	WebElement signUpButton;
	
	public void fillEmailTextBox(String email) 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
		
		emailTextBox.click();
		emailTextBox.sendKeys(email);
		
	}
	
	public void selectCountry(String country) 
	{
		countryDropDown.click();
		
		List<WebElement> list = driver.findElements(By.xpath("div[@class='menu transition visible']/div"));
		
		Iterator<WebElement> it = list.iterator();
		
		while(it.hasNext()) 
		{
			if(it.next().getText().equalsIgnoreCase(country)) 
			{
				it.next().click();
				break;
			}
		}
		
	}
	
	public void fillInPhoneNumber(String number) 
	{
		phoneTextBox.click();
		phoneTextBox.sendKeys(number);
	}

	public void clickOnTermsCheckBox() 
	{
		termsAndConditionsCheckBox.click();
	}
	
	public void clickOnCaptcha() 
	{
		captchaCheckBox.click();
		
	}
	
	public SignUpPage clickOnSignUpButton() throws IOException 
	{
		signUpButton.click();
		
		return new SignUpPage();
	}

}
