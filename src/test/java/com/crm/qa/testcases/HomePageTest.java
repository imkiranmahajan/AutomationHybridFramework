package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	
	public HomePageTest() throws IOException {
		super();
	}
	
	//test cases should be separated -- independent with each other.
	//before each test case -- launch the browser and login.
	//@Test -- execute the test cases.
	//after each test case -- close the browser.
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		calendarPage = new CalendarPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password")); //The reason we used HomePage Object here is, after login we return the HomePage.
	}
	
	@Test(priority=1)
	public void validateHomePageTitle() {
		String HomePagetitle =  homePage.validateHomePageTitle();
		Assert.assertEquals(HomePagetitle, "Cogmento CRM","Home page title not matched"); // if the title not matched to the actual name, it will print this.
	}
	
	@Test(priority=2)
	public void verifyAccountHolderName() {
		//Assert.assertTrue(homePage.verifyAccountHolderName()); -> You can also write like this. 
		boolean accountHolderName = homePage.verifyAccountHolderName();
		Assert.assertTrue(accountHolderName);
	}
	
	@Test(priority=3)
	public void verifyCalendarLinkTest() throws InterruptedException, IOException {
		calendarPage = homePage.clickOnCalendarLink(); //This will return the calendar page.
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
