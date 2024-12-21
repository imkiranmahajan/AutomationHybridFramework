package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {

	LoginPage login;
	ContactsPage contactPage;
	HomePage homePage;

	public ContactPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		contactPage = new ContactsPage();
		homePage = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContactLink();
	}
	
	@Test(priority=2)
	public void printContactText() {
		String textName = contactPage.verifyContactText();
		Assert.assertEquals(textName, "Contacts");
	}
	
	
	@Test(priority=1) //(dataProvider ="getTestData")
	public void verifyNewContact() throws InterruptedException {
		contactPage.createNewContact("Kiran", "Mali");
	}

//	@DataProvider
	public Object[][] getTestData() {
		return new Object[][] { { "Kiran", "Mali" }, {"Radha", "Wagh"} };
	}

	/*
	 * @Test (dataProvider="getAllTesData") 
	 * public void verifyNewContact(HashMap<String, String> input)throws InterruptedException {
	 * contactPage.createNewContact(input.get("name"), input.get("surname")); }
	 * 
	 * //What is the HashMap? --> HashMap is a data structure that uses the Map interface and a hash table for storing key-value pairs.
	 * //This below method is another way to achieve data-driven testing, here we can add multiples parameters with multiple value.
	 * 
	 * @DataProvider public Object[][] getAllTesData(){ 
	 * HashMap<String, String> hashMap1 = new HashMap<>(); 
	 * hashMap1.put("name", "Kiran");
	 * hashMap1.put("surname", "Mali");
	 * 
	 * HashMap<String, String> hashMap2 = new HashMap<>(); 
	 * hashMap2.put("name","Shubhangi");
	 * hashMap2.put("surname", "Wagh");
	 * 
	 * HashMap<String, String> hashMap3 = new HashMap<>(); 
	 * hashMap3.put("name","Bhupesh"); 
	 * hashMap3.put("surname", "Mahajan");
	 * 
	 * HashMap<String, String> hashMap4 = new HashMap<>(); 
	 * hashMap4.put("name","Pankaj"); 
	 * hashMap4.put("surname", "Sonavane");
	 * 
	 * return new Object[][] {{hashMap1}, {hashMap2}, {hashMap3}, {hashMap4}}; }
	 */

//	@Test(dependsOnMethods = { "verifyNewContact" }) //dependsOnMethods is a annotation which is depends on previous method.
	public void deleteCreatedContact() {
		contactPage.deleteContact();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
