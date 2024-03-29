package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTestCase extends TestBase {
	
	 LoginPage loginpage;
	 HomePage homepage;
	public LoginPageTestCase(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void validateCRMLogoTest(){
		Boolean flag=loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage=loginpage.logintoCRM(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
