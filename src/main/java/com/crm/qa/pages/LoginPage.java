package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(xpath= "//input[@name='username']")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	//@FindBy(xpath=//input[@type='submit']")
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	//@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement CRMLOgo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogo(){
		return CRMLOgo.isDisplayed();
	}
	
	public HomePage logintoCRM(String un,String pwd) {
		Boolean usernameExist=UserName.isDisplayed();
		Boolean PwdExist=Password.isDisplayed();
		Boolean logbtn=LoginBtn.isEnabled();
		if((usernameExist==true) && (logbtn==true)){
		System.out.println("username and password editbox are displayed..");
			
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		//LoginBtn.click();
		Actions action=new Actions(driver);
		action.moveToElement(LoginBtn).click().perform();
		
		
		//Thread.sleep(5);
		}
		 return new HomePage();
	}
}
