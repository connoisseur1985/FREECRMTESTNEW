package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.TestBase;

public class FreeCRMLoginPage extends TestBase {

	public FreeCRMLoginPage() throws IOException {
	
		PageFactory.initElements(driver,this);
	
	}
	
	//WebElements --Author Ankur Mahajan

	@FindBy(css="input[name='email']")
	WebElement emailTextBox;

	@FindBy(css="input[name='password']")
	WebElement passwordTextBox;

	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordButton;
	
	@FindBy(css="div[class='ui negative message']")
	WebElement someThingWrongLabel;
	
	
	
	
	//Methods Author -- Ankur Mahajan
	
	public boolean checkVisibilityOfSomethingWrong() 
	{
		if(someThingWrongLabel.isDisplayed()) 
		{
			return true;
		}
		else
			return false;
	}
		
	public void enterEmailId(String email) 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		
		wait.until(ExpectedConditions.visibilityOf(emailTextBox));
		
		emailTextBox.click();
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password) 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		
		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		
		passwordTextBox.click();
		passwordTextBox.sendKeys(password);
	}
	
	public HomePage clickOnLoginButton() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		
		loginButton.click();
		
		return new HomePage();
	}
	
}
