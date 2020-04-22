package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class SignUpPage extends TestBase{

	public SignUpPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	

}
