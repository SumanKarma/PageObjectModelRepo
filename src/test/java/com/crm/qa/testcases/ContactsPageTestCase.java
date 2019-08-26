package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTestCase  extends TestBase{
	LoginPage loginpage;
	 HomePage homepage;
	 TestUtil testutil;
	 ContactsPage contactpage;
	 
	public ContactsPageTestCase(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginpage=new LoginPage();
		contactpage=new ContactsPage();
		testutil=new TestUtil();
		homepage=loginpage.logintoCRM(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame(prop.getProperty("framename"));
		contactpage=homepage.clickContactsLink();
	}
	
	@Test(priority=1)
	public void validateContactsPagelabelTest(){
		//testutil.switchToFrame(prop.getProperty("framename"));
		Boolean contactlabelExist=contactpage.verifyContactsLabel();
		Assert.assertTrue(contactlabelExist);
		
	}
	@Test(priority=2)
	public void selectContactsTest(){
		//testutil.switchToFrame(prop.getProperty("framename"));
		contactpage.selectContacts("test auto");
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

}
