package com.qa.crm.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase{

	
	public HomePage() throws IOException 
	{
		PageFactory.initElements(driver,this);
		
		driver.manage().timeouts().pageLoadTimeout(waits_Value,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(waits_Value, TimeUnit.SECONDS);
	}
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userLabel;
	
	public String checkUserLabel() 
	{
		userLabel.isDisplayed();
		
		return userLabel.getText();
	}
}
