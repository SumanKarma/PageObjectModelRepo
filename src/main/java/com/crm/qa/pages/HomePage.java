package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	//PageFactory
		@FindBy(xpath= "//td[contains(text(),'sousri sinha')]")
		WebElement UserNameLabel;
		
		@FindBy(xpath= "//a[contains(text(),'Contacts')]")
		WebElement ContactsLink;
		
		@FindBy(xpath= "//a[contains(text(),'Deals')]")
		WebElement DealsLink;
		
		@FindBy(xpath= "//a[contains(text(),'Tasks')]")
		WebElement TaskLink;
		
		
		
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		public String verifyHomePageTitle(){
			 return driver.getTitle(); 
		 }
			
		 public Boolean verifyUserlabel(){
//(prop.getProperty("framename"));
			  return UserNameLabel.isDisplayed();
			 
		 }
		 public ContactsPage clickContactsLink(){
			// driver.switchTo().frame(prop.getProperty("framename"));
			 ContactsLink.click();
			 return new ContactsPage();
			 
		 }
		 public DealsPage ClickDealsLink(){
			 driver.switchTo().frame(prop.getProperty("framename"));
			 DealsLink.click();
			 return new DealsPage();
		 }
}
