package com.codebind;


import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdminTest {
	private WebDriver driver;
	
	DSTVTest sel = new DSTVTest();
	
	@Before
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "/Users/Bhadilov/Documents/chromedriver");
		driver  = new ChromeDriver();
		driver.get("http://hrm.seleniumminutes.com");

	}
	@Test
	public void testWebsite(){
		Assert.assertEquals("Verify Title", driver.getTitle(), "OrangeHRM");
		successfulAdminlogin();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());	
		
	}
	public void successfulAdminlogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		Utility.captureScreenshot(driver, "say cheeeeeese");
	}

	@After
	public void saveScreenshotAndCloseBrowser() throws IOException{
		driver.quit();		
	}
	

}
