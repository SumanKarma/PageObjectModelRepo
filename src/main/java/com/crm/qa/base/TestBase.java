package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try{
			
		prop=new Properties();
		FileInputStream ip=new FileInputStream("/Users/karmasu/workspace/freeCRMTestMaven/src/main/java/com/crm/qa/config/config.properties");
		prop.load(ip);
		
		} catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Python27\\Scripts\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Python27\\Scripts\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		//driver.manage().window().maximize();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("no-sandbox");
		//Fix for cannot get automation extension
		chromeOptions.addArguments("disable-extensions");
		chromeOptions.addArguments("--start-maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(10);
		
	}

	
	
	
	
	
	
	
	
}
