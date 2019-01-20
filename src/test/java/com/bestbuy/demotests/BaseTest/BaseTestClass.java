package com.bestbuy.demotests.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bestbuy.demo.utils.Driver.BrowserDriver;
import org.apache.log4j.Logger;

public class BaseTestClass {
	
	public WebDriver driver;
	
	public static Logger log = Logger.getLogger("errorLogger");
	
	@BeforeMethod
	public void setUp() {			
		driver = new BrowserDriver("chrome");
		
		driver.manage().window().maximize(); 
	}   
	      
	@AfterMethod
	public void tearDown() { 
		driver.quit(); 
	} 

}
