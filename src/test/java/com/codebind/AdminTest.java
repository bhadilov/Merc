package com.codebind;


import java.lang.Thread;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.eclipse.jetty.util.thread.*;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;  


public class AdminTest {
	
	
	private WebDriver driver;
	readExcel rex= new  readExcel();
	
	
	@Before
	public void openBrowser(){
		//DesiredCapabilities capab = new DesiredCapabilities();
		//capab.setJavascriptEnabled(true);
		//capab.setCapability("PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY", "phantomjs-2.1.1-macosx/bin/phantomjs");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		 driver = new MarionetteDriver(capabilities); 
		//driver = new FirefoxDriver();
		 //driver = new PhantomJSDriver(capab);
		 driver.get("https://za.deod.tv/en/");
		 System.out.println("Discover Digital");

	}
	@Test
	public void verifonLandingPage(){
		
		Assert.assertEquals("Verify Title", driver.getTitle(), "Deod.tv - What's New");
		driver.findElement(By.id("openSearch")).click();
		driver.findElement(By.id("filmList")).click();
	}

	@After
	public void saveScreenshotAndCloseBrowser() throws IOException{
		driver.quit();		
	}
	

}
