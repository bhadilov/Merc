package com.codebind;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Utility {

	WebDriver driver=new ChromeDriver();
    WebElement careers;


	public void clickOnCareers(){

		careers = driver.findElement(By.id("menu-item-1373"));
		careers.click();
	}
}
