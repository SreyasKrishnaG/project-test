package com.bestbuy.demotests.testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {

	@Test
	public void bestBuy(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manju\\workspace\\WebDriver\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bestbuy.com/");
		String currentWindowHandle=driver.getWindowHandle(); 
		
		System.out.println("Starting the system");

		String htmlModalWindowHandle=null; 
		for(String windowHandle:driver.getWindowHandles()) 
		{ 
		if (!windowHandle.equals(currentWindowHandle)) 
		htmlModalWindowHandle=windowHandle; 
		System.out.println(htmlModalWindowHandle); 
		} 
		driver.switchTo().window(htmlModalWindowHandle);
		driver.findElement(By.className("close")).click();
		System.out.println("Closing the system for merging in git");
		
	}
}
