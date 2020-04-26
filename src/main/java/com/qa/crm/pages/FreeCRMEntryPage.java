package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.TestBase;

public class FreeCRMEntryPage extends TestBase{

	public FreeCRMEntryPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(xpath = "//span[@class='brand-slogan']/parent::a[@title='free crm home']/parent::div[@class='rd-navbar-brand']")
	WebElement logoLink;
	
	@FindBy(linkText = "CRM")
	WebElement crmLinkDropDown;
	
	@FindBy(xpath = "//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']/preceding-sibling::li/a[text()='Apps']")
	WebElement appLinkDropDown;
	
	@FindBy(xpath ="//span[text()='Log In']")
	WebElement loginButton;
	
	@FindBy(linkText = " sign up")
	WebElement signUpButton;
	
	@FindBy(css = "div[class='intercom-fvs20o e2ujk8f2']")
	WebElement cogmentoButton;
	
	@FindBy(css = "button[class='intercom-192ek0v ed73yuc0']")
	WebElement cogmentoNewMessageButton;

	
	public RegisterPage clickOnSignUpLink() throws IOException 
	{
		signUpLink.click();
		return new RegisterPage();
	}
	

	public FreeCRMEntryPage clickOnLogoLink() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		wait.until(ExpectedConditions.elementToBeClickable(logoLink));
		
		logoLink.click();
		
		return new FreeCRMEntryPage();
	}
	

	
	public void clickOnCrmLinkDropDown() 
	{
		crmLinkDropDown.click();
	}
	
	
	public void appLinkDropDown() 
	{
	
		appLinkDropDown.click();
		
	}
	

	
	public FreeCRMLoginPage clickOnLoginButton() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver,waits_Value);
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		
		loginButton.click();
		return new FreeCRMLoginPage();
	}
	

	
	public void clickOnSignUpButton() 
	{
		signUpButton.click();
	}
	
	public void clickOnCogmentoButton() 
	{
		cogmentoButton.click();
	}
	

	
	public void clickOnCogmentoNewMessageButton() 
	{
		cogmentoNewMessageButton.click();
	}

}
