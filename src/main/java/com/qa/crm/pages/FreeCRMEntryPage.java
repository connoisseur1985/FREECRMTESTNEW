package com.qa.crm.pages;

import java.io.IOException;

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
	
	public void clickOnSignUpLink() 
	{
		signUpLink.click();
	}
	
	@FindBy(xpath = "//div[@class='rd-navbar-panel']")
	WebElement logoLink;
	
	public void clickOnLogoLink() 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(logoLink));
	
		logoLink.click();
	}
	
	@FindBy(linkText = "CRM")
	WebElement crmLinkDropDown;
	
	public void clickOnCrmLinkDropDown() 
	{
		crmLinkDropDown.click();
	}
	
	@FindBy(xpath = "//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']/preceding-sibling::li/a[text()='Apps']")
	WebElement appLinkDropDown;
	
	public void appLinkDropDown() 
	{
	
		appLinkDropDown.click();
		
	}
	
	@FindBy(css = "a[class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginButton;
	
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	
	@FindBy(linkText = " sign up")
	WebElement signUpButton;
	
	public void clickOnSignUpButton() 
	{
		signUpButton.click();
	}
	@FindBy(css = "div[class='intercom-fvs20o e2ujk8f2']")
	WebElement cogmentoButton;
	
	public void clickOnCogmentoButton() 
	{
		cogmentoButton.click();
	}
	
	@FindBy(css = "button[class='intercom-192ek0v ed73yuc0']")
	WebElement cogmentoNewMessageButton;
	
	public void clickOnCogmentoNewMessageButton() 
	{
		cogmentoNewMessageButton.click();
	}

}
