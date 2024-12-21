package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase {

	public CalendarPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory:
	@FindBy(xpath = "//div[@class='rbc-date-cell rbc-now rbc-current']")
	WebElement selectEndDate;
	
	@FindBy(name="title")
	WebElement titleName;
	
	@FindBy(xpath = "//form[@class='ui form segment custom-form-container']//div[2]//div[@class='field'][2]")
	WebElement clickOnDateAndTime;
	
	@FindBy(xpath = "//div[@aria-label='Choose Monday, 9 December 2024']")
	WebElement desireDate;
	
	@FindBy(xpath = "//li[text()='18:00']")
	WebElement desireTime;
	
	@FindBy(name = "description")
	WebElement description;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement savebtn;
	
	@FindBy(css = "i[class='chevron right icon']")
	WebElement rightSideBtn;
	
	@FindBy(xpath = "//span[@class='today-button']")
	WebElement  timePassClick;
	
	@FindBy(linkText = "Manage Calendars")
	WebElement gotoManageCalendar;
	
	@FindBy(css = "button[class='ui linkedin button']")
	WebElement addCalendarBtn;
	
	@FindBy(css = "div[class='ui fluid input']")
	WebElement addCalendarName;
	
	@FindBy(css = "button[class='ui green button']")
	WebElement createCalendarBtn;
	
	@FindBy(xpath = "//button[@class='ui button']")
	WebElement backBtn;
	
	//Actions:
	public void createCalendar() {
		selectEndDate.click();
		titleName.sendKeys(prop.getProperty("titleName"));
		clickOnDateAndTime.click();
		desireDate.click();
		desireTime.click();
		description.sendKeys(prop.getProperty("description"));
		savebtn.click();
	}
	
	
	public void clickOnNextMonthCalendar() throws InterruptedException {
		for(int i = 1; i <= 4; i++) {
			rightSideBtn.click();
			Thread.sleep(3000);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	
	public void manageAndAddCalendar() throws InterruptedException {
		timePassClick.click();
		gotoManageCalendar.click();
		addCalendarBtn.click();
		Thread.sleep(2000);
		addCalendarName.sendKeys("Krishna's Calendar");
		createCalendarBtn.click();
//		backBtn.click();
	}
	
	

}
