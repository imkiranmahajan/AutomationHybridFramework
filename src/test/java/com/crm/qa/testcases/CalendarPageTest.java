package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CalendarPageTest extends TestBase {
	
	LoginPage login;
	HomePage homePage;
	CalendarPage calendarPage;
	
	public CalendarPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		calendarPage = new CalendarPage();
		homePage = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		calendarPage = homePage.clickOnCalendarLink();
	}
	
	@Test(priority=1)
	public void createCalendar() throws InterruptedException, IOException {
		calendarPage.createCalendar();
	}
	
	@Test(priority=2)
	public void clickOnNextMonthCalendar() throws InterruptedException {
		calendarPage.clickOnNextMonthCalendar();
	}
	
//	@Test(priority=3)
	public void manageAndAddCalendar() throws InterruptedException {
		calendarPage.manageAndAddCalendar();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
