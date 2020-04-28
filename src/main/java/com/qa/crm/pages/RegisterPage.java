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
	
	@FindBy(css="div[id='country']")
	WebElement countryDropDown;
	
	@FindBy(css="input[name='phone']")
	WebElement phoneTextBox;
	
	@FindBy(id="terms")
	WebElement termsAndConditionsCheckBox;
	
	@FindBy(css="div[class='recaptcha-checkbox-border']")
	WebElement captchaCheckBox;
	
	@FindBy(css="button[name='action']")
	WebElement signUpButton;
	
	
	
	public SignUpPage fillRegistrationForm(String email,String country, String number) throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
		
		emailTextBox.sendKeys(email);
		selectCountry(country);
		phoneTextBox.sendKeys(number);
		phoneTextBox.click();
		termsAndConditionsCheckBox.click();
		signUpButton.click();
		
		return new SignUpPage();
		//captchaCheckBox.click();
	
	}
	
	public void selectCountry(String country) 
	{
		countryDropDown.click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='country']/div[@class='menu transition visible']/div"));
		
		Iterator<WebElement> it = list.iterator();
		
		while(it.hasNext()) 
		{
			WebElement countr = it.next();
			String coun = countr.getText();
			
			System.out.println(coun);
			if(coun.equalsIgnoreCase(country)) 
			{
				countr.click();
				break;
			}
		}
		
	}
	
}
