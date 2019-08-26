package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//PageFactory
	@FindBy(xpath= "//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath= "//input[@value='New Contact']")
	WebElement newContactslink;
	
	
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	public Boolean verifyContactsLabel(){
		 return ContactsLabel.isDisplayed();
	 }
	
	/*public void createNewContact(){
		newContactslink.click();
	}*/
	public void selectContacts(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//child::input[@name='contact_id']")).click();
	}
	

}
