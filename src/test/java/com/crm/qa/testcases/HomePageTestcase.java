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

public class HomePageTestcase extends TestBase {
	
	 LoginPage loginpage;
	 HomePage homepage;
	 TestUtil testutil;
	 ContactsPage contactpage;
	 
	public HomePageTestcase(){
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
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest(){
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest(){
		//testutil.switchToFrame(FRName);
		Boolean userExist=homepage.verifyUserlabel();
		Assert.assertTrue(userExist);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		contactpage=homepage.clickContactsLink();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
