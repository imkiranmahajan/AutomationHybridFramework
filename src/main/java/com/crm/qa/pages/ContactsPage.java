package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span[class='selectable ']")
	WebElement contactText;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement createNewContactBtn;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']//input[@type='text']")
	WebElement company;
	
	@FindBy(xpath = "//span[text()='Google']")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath = "//i[@class='checkmark icon']")
	WebElement emailCheckmark;
	
	@FindBy(name= "category")
	WebElement SelectCategory;
	
	@FindBy(xpath= "//span[text()='Lead']")
	WebElement categoryName;
	
	@FindBy(xpath = "//input[@placeholder='Number']")
	WebElement phoneNo;
	
	@FindBy(xpath= "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[@class='ui button icon']")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[@class='ui red button']")
	WebElement FinalDeleteBtn;
	
	public String verifyContactText() {
		return contactText.getText();
	}
	
	public void createNewContact(String ftName, String ltName) throws InterruptedException {
		createNewContactBtn.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys("G");
		Thread.sleep(2000);
		emailCheckmark.click();
		SelectCategory.click();
		categoryName.click();
		saveBtn.click();
	}
	
	public void deleteContact() {
		deleteBtn.click();
		FinalDeleteBtn.click();
	}
	
}
