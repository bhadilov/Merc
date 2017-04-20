package com.codebind;



import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.By;  




public class AdminTest {
	private WebDriver driver;
	
	
	@Before
	public void openBrowser(){
		DesiredCapabilities capab = new DesiredCapabilities();
		capab.setJavascriptEnabled(true);
		capab.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-2.1.1-macosx/bin/phantomjs");
		
		 driver = new PhantomJSDriver(capab);
		 driver.get("http://hrm.seleniumminutes.com");
		 System.out.println("Shit");

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
