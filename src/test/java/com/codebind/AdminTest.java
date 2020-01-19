package com.codebind;


import java.lang.Thread;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
    Utility util = new Utility();
	private WebDriver driver;

	
	@Before
	public void openBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver" , "/usr/local/applications/repos/todelete/Java-Project-Selenium/chromedriver");
		driver=new ChromeDriver();


	}


	@Test
	public void stepFive(){

		driver.navigate().to("https://www.ilabquality.com/");
		//driver.get("https://www.ilabquality.com/");
		//driver.wait(4000);
		Assert.assertEquals("Verify Title", driver.getTitle(), "Home Page - iLAB");
		util.clickOnCareers();
		//util.clickOnCareers();
		//Assert.assertEquals("Verify Title", driver.getTitle(), "CAREERS - iLAB");

	}
	@After
	public void finalAct() throws IOException{
		driver.quit();
	}
	

}
