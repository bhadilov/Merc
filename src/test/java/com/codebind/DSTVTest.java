package com.codebind;

import static org.junit.Assert.*;
import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui .*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DSTVTest {
	public static FirefoxDriver driver;
	WebElement ele;
	
	
	@BeforeClass
	public static void openBrowser() {
		driver  = new FirefoxDriver();
		driver.get("http://m-net.dstv.com/South/home");	
	}
	
	@Test
	public void verifyOnHomePage(){
		getTestNAme();
		Assert.assertTrue(MyTitle().contains("M-Net |"));
	
	}
	@Test
	public void verifylocalcontent() throws InterruptedException{
		getTestNAme();
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[3]/ul/li[6]/a"))).click();;
		assertTrue(driver.getCurrentUrl().contains("shark-tank"));
		Thread.sleep(2000);
		
	}
	
	public String MyTitle()
	{
		return driver.getTitle();
	}
	public void getTestNAme()
	{
		System.out.println("Starting test " +new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@AfterClass
	public static void closeBrowser(){
	driver.quit();
	}
}
