package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class DocumentsPageTest extends TestBase{

	public DocumentsPageTest() throws IOException {
		super();
	}
	
	LoginPage login;
	HomePage homePage;
	DocumentsPage documentsPage; 
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		homePage = login.Login(prop.getProperty("username"), prop.getProperty("password")); // This will return homePage.
		documentsPage = homePage.clickOnDocumentsLink(); // This will return documentsPage.
	}
	
	@Test
	public void CreateNewDocument() {
		documentsPage.createNewDocument("Selenium", "Hello Kiran");
	}
	
//	@Test
	public void deleteDocument() {
		documentsPage.deleteDocuments();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
