package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=2, groups={"Regression"})
	public void validateLoginPageTitile() {
		String titleName = loginPage.validateLoginPageTitle();
		Assert.assertEquals(titleName, "Cogmento CRM");
	}
	
	@Test(priority=1)
	public void login() throws IOException {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password")); //The reason we used HomePage Object here is, after login we return the HomePage.
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		driver.quit();
	}
	
}
