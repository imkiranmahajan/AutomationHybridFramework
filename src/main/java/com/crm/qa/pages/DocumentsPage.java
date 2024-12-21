package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DocumentsPage extends TestBase{

	public DocumentsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@href='/documents/new']")
	WebElement createDocumentBtn;
	
	@FindBy(name ="title")
	WebElement addTitle;
	
	@FindBy(xpath = "//button[@class='ui small fluid positive toggle button']")
	WebElement accessBtn;
	
	@FindBy(name = "description")
	WebElement addDescription;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(css = "i[class='remove icon']")
	WebElement crossIcon;
	
	@FindBy(css = "button[class='ui button']")
	WebElement deleteDocument;
	
	public void createNewDocument(String title, String description) {
		createDocumentBtn.click();
		addTitle.sendKeys(title);
		accessBtn.click();
		addDescription.sendKeys(description);
		saveBtn.click();
	}
	
	public void deleteDocuments() {
		crossIcon.click();
		deleteDocument.click();
	}
	
	
}
















