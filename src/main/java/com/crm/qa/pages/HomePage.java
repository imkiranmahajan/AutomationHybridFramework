package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Initialization the Page Objects:
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Page Factory - OR:
	@FindBy (css = ".user-display")
	WebElement accountHolderName; 
	
	@FindBy (css = "a[href='/calendar']")
	WebElement calendarLink;
	
	@FindBy (xpath = "//a[@href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(css = "a[href='/documents']")
	WebElement documentLink; 
	
	
	//Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAccountHolderName() {
		return accountHolderName.isDisplayed();
	}
	
	public CalendarPage clickOnCalendarLink() throws InterruptedException, IOException {
		calendarLink.click();
		Thread.sleep(5000);
		return new CalendarPage();
	}
	
	public ContactsPage clickOnContactLink() throws IOException, InterruptedException {
		contactsLink.click();
		Thread.sleep(2000);
		return new ContactsPage();
	}
	
	public DocumentsPage clickOnDocumentsLink() throws IOException{
		documentLink.click();
		return new DocumentsPage();
	}
	
	
	
	
	
	
	
}
