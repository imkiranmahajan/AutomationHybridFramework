package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Initialization the Page Objects:
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Page Factory - OR:
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(@class,'submit button')]")
	WebElement submitbtn;

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage Login(String un, String pw) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pw);
		submitbtn.click();
		
		return new HomePage();
	}
	
	

}
